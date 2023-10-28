package dao;

public class Coin {
    private final int id ;
    private final String type;
    private double currency ;
    private int buyCoinCount= 0;
    private int sellCoinCount = 0;



    public int getBuyCoinCount() {
        return buyCoinCount;
    }

    public void setBuyCoinCount(int buyCoinCount) {
        this.buyCoinCount = buyCoinCount;
    }

    public int getSellCoinCount() {
        return sellCoinCount;
    }

    public void setSellCoinCount(int sellCoinCount) {
        this.sellCoinCount = sellCoinCount;
    }

    public Coin(int id, String type, double currency) {
        this.id = id;
        this.type = type;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", currency=" + currency +
                '}';
    }
}
