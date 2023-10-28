package dao;

import util.SequenceId;

public class Client {
    private final int id ;
    private final String name ;
    private Wallet wallet;



    public Client(String name, Wallet wallet) {
        this.id = SequenceId.nextVal();
        this.name = name;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wallet=" + wallet +
                '}';
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
