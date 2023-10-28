package util;

import globalData.GlobalData;
import util.InputUtil;

public class MenuUtil {


    public static int entryMenu() {
        System.out.println(
                "-------------Crypto-------------\n"+
                "[1] -> Buy Coin\n" +
                        "[2] → Sell Coin\n" +
                        "[3] → See Currency\n" +
                        "[4]-> See my coins");
        return InputUtil.inputInt("Choose option: ");
    }
}
