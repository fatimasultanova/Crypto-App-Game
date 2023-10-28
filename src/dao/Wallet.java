package dao;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Wallet {
    private ConcurrentHashMap<Coin, Integer> coins = new ConcurrentHashMap<>();
    private double clientMoney = 30000;


    public double getClientMoney() {

        return clientMoney;
    }

    public void setClientMoney(double clientMoney) {
        this.clientMoney = clientMoney;
    }

    public Wallet(ConcurrentHashMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public ConcurrentHashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public void setCoins(ConcurrentHashMap<Coin, Integer> coins) {
        this.coins = coins;
    }



    @Override
    public String toString() {
        return "Wallet{" +
                "coins=" + coins +
                ", clientMoney=" + clientMoney +
                '}';
    }

    public void setCoins(Coin coin, Integer coinCount) {
        coins.put(coin,coinCount);
    }
}
