package service;

import service.inter.CryptoServiceInter;
import service.inter.ManagementInter;
import util.MenuUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Management implements ManagementInter {

    CryptoServiceInter cryptoService = new CryptoService();

    @Override
    public void manage() {
        Thread unRealmanageBuy =unRealmanageBuy();
        Thread unRealmanageSell = unRealmanageSell();
        Thread checkCurrency = checkCurrency();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(unRealmanageBuy);
        executorService.execute(unRealmanageSell);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleWithFixedDelay(checkCurrency,0,2, TimeUnit.SECONDS);

        while (true){
            int option = MenuUtil.entryMenu();

            switch (option){
                case 1:
                    cryptoService.buyCoin(false);
                    break;
                case 2:
                    cryptoService.sellCoin(false);
                    break;
                case 3:
                    cryptoService.seeCurrency(false);
                    break;
                case 4:
                    cryptoService.seeMyCoins(false);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }



    }

    @Override
    public Thread unRealmanageSell() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    cryptoService.sellCoin(true);
                }
            }
        });
    }

    @Override
    public Thread unRealmanageBuy() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    cryptoService.buyCoin(true);
                }
            }
        });
    }

    @Override
    public Thread checkCurrency() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    CryptoService.ckeckCurrency();
                }
            }
        });
    }


}
