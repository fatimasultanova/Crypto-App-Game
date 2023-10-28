import service.Management;
import service.inter.ManagementInter;


public class Main {
    public static void main(String[] args) {
        ManagementInter managementInter = new Management();
        managementInter.manage();
    }
}