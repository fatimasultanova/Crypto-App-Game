package service.inter;

public interface CryptoServiceInter {
    void buyCoin(boolean isRobot);
    void sellCoin(boolean isRobot);
    void seeCurrency(boolean isRobot);
    void seeMyCoins(boolean isRobot);
}
