package ch18.sec4.first;

/**
 * 代码清单18-11 最直接的加减法
 *
 * @author 王涵威
 * @date 20.12.13 17:01
 */
public class Calculator {

    private final static String ADD_SYMSOL = "+";

    private final static String SUB_SYMSOL = "-";

    public int exec(int a, int b, String symbol) {
        int result = 0;
        if (symbol.equals(ADD_SYMSOL)) {
            result = this.add(a, b);
        } else if (symbol.equals(SUB_SYMSOL)) {
            result = this.sub(a, b);
        }
        return result;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }
}
