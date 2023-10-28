package globalData;

import dao.Client;
import dao.Coin;
import dao.Wallet;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GlobalData {

    public static CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Coin> coins = new CopyOnWriteArrayList<>();


    static {

        clients.add(new Client("Fatima", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima1", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima2", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima3", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima4", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima5", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima6", new Wallet(new ConcurrentHashMap<>())));
        clients.add(new Client("Fatima7", new Wallet(new ConcurrentHashMap<>())));


        coins.add(new Coin(1, "Bitcoin", 58000));
        coins.add(new Coin(2, "Ethereum", 34000));
        coins.add(new Coin(3, "Cardano", 1800));
        coins.add(new Coin(4, "Toncoin", 99));
        coins.add(new Coin(5, "Filecoin", 198));
        coins.add(new Coin(6, "EOS", 9));
        coins.add(new Coin(7, "Tether", 120));
        coins.add(new Coin(8, "Solana", 12560));
    }


}
