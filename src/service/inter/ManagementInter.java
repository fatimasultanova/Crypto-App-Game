package service.inter;

public interface ManagementInter {
    void manage();
    Thread unRealmanageBuy();
    Thread unRealmanageSell();
    Thread checkCurrency();

}
