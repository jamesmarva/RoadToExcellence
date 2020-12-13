package ch18.sec4.second;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 17:02
 */
public class Calculator {

    private final static String ADD_SYMBOL = "+";

    private final static String SUB_SYMMOL = "-";

    public int execute(int a, int b, String symbol) {
        return symbol.equals(ADD_SYMBOL) ? a + b : a - b;
    }
}
