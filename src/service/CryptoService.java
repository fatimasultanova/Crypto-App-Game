package service;

import dao.Client;

import static globalData.GlobalData.*;

import dao.Coin;
import dao.Wallet;
import globalData.GlobalData;
import service.inter.CryptoServiceInter;
import util.InputUtil;

import java.util.Random;


public class CryptoService implements CryptoServiceInter {


    Client client = clients.get(0);

    int buyCount;


    @Override
    public void buyCoin(boolean isRobot) {
        if (!isRobot) {
            for (int i = 0; i < coins.size(); i++) {
                System.out.println(coins.get(i));
            }
            Integer whichCoin = InputUtil.inputInt("Choose coinId: ");
            if (whichCoin > 0 && whichCoin <= 8) {
                Integer coinCount = InputUtil.inputInt("Choose coin count: ");
                Coin coin = coins.get((whichCoin - 1));
                if (coinCount <= 10 && client.getWallet().getClientMoney() >= coin.getCurrency() * coinCount) {
                    Integer integerCount = client.getWallet().getCoins().get(coin);
                    client.getWallet().setCoins(coin, (integerCount - coinCount));
                   // client.getWallet().getCoins().replace(coin, (integerCount + coinCount));
                    client.getWallet().setClientMoney((client.getWallet().getClientMoney()) - (coin.getCurrency() * coinCount));
                    System.out.println("You buy:  " + coin.getType() + "count:  " + coinCount);
                    coin.setBuyCoinCount(coin.getBuyCoinCount() + 1);
                    buyCount++;
                }
            } else {
                System.out.println("You cant buy coin!");
            }
        }
        if (isRobot) {
            Random random = new Random();
            Client randomClient = clients.get(random.nextInt(8));
            Integer whichCoin = random.nextInt(9);
            Integer coinCount = random.nextInt(11);
            Coin coin = coins.get((whichCoin - 1));
            if (randomClient.getWallet().getClientMoney() >= coin.getCurrency() * coinCount) {
                Integer integerCount = randomClient.getWallet().getCoins().get(coin);
                randomClient.getWallet().getCoins().replace(coin, (integerCount + coinCount));
                coin.setBuyCoinCount(coin.getBuyCoinCount() + 1);
                randomClient.getWallet().setClientMoney((randomClient.getWallet().getClientMoney()) - (coin.getCurrency() * coinCount));
            }
        }
    }

    @Override
    public void sellCoin(boolean isRobot) {
        if (!isRobot) {
            System.out.println(client.toString());
            Integer whichCoin = InputUtil.inputInt("Choose coinId: ");
            if (whichCoin > 0 && whichCoin <= 8) {
                Integer coinCount = InputUtil.inputInt("Choose coin count: ");
                Coin coin = coins.get((whichCoin - 1));
                if (coinCount <= 7 && coinCount <= client.getWallet().getCoins().get(coin)) {
                    Integer integerCount = client.getWallet().getCoins().get(coin);
                    client.getWallet().setCoins(coin, (integerCount - coinCount));
                    //client.getWallet().getCoins().replace(coin, (integerCount - coinCount));
                    client.getWallet().setClientMoney((client.getWallet().getClientMoney()) + (coin.getCurrency() * coinCount));
                    coin.setBuyCoinCount(coin.getSellCoinCount() + 1);
                    System.out.println("You sell:  " + coin.getType() + "count:  " + coinCount);
                }
            } else {
                System.out.println("You cant sell coin!");
            }
        }
        if (isRobot) {
            Random random = new Random();
            Client randomClient = clients.get(random.nextInt(8));
            Integer whichCoin = random.nextInt(9);
            Coin coin = coins.get(whichCoin - 1);
            Integer coinCount = random.nextInt(randomClient.getWallet().getCoins().get(coin) + 2);

            if (coinCount <= 7) {
                Integer integerCount = randomClient.getWallet().getCoins().get(coin);
                randomClient.getWallet().getCoins().replace(coin, (integerCount - coinCount));
                coin.setBuyCoinCount(coin.getSellCoinCount() + 1);
                randomClient.getWallet().setClientMoney((randomClient.getWallet().getClientMoney()) + (coin.getCurrency() * coinCount));

            }
        }
    }


    @Override
    public void seeCurrency(boolean isRobot) {
        if (!isRobot) {
            if (buyCount == 10) {
                System.out.println(coins.toString());
            }
        }
    }

    @Override
    public void seeMyCoins(boolean isRobot) {
        if (!isRobot) {
            System.out.println(client.toString());
        }
    }

    public static void ckeckCurrency() {
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getBuyCoinCount() % 5 != 0) {
                if ((coins.get(i).getCurrency() <= 5000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() + ((coins.get(i).getCurrency() * 22) / 100));
                }
                if ((coins.get(i).getCurrency() > 5000) && (coins.get(i).getCurrency() <= 10000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() + ((coins.get(i).getCurrency() * 12) / 100));
                }
                if ((coins.get(i).getCurrency() > 10000) && (coins.get(i).getCurrency() <= 20000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() + ((coins.get(i).getCurrency() * 6) / 100));
                }
                if ((coins.get(i).getCurrency() > 20000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() + ((coins.get(i).getCurrency() * 2) / 100));
                }

            }
            if (coins.get(i).getSellCoinCount() % 5 != 0){
                if ((coins.get(i).getCurrency() <= 5000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() - ((coins.get(i).getCurrency() * 18) / 100));
                }
                if ((coins.get(i).getCurrency() > 5000) && (coins.get(i).getCurrency() <= 10000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() - ((coins.get(i).getCurrency() * 10) / 100));
                }
                if ((coins.get(i).getCurrency() > 10000) && (coins.get(i).getCurrency() <= 20000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() - ((coins.get(i).getCurrency() * 5) / 100));
                }
                if ((coins.get(i).getCurrency() > 20000)) {
                    coins.get(i).setCurrency(coins.get(i).getCurrency() - ((coins.get(i).getCurrency() * 1) / 100));
                }
            }
        }
    }

}

