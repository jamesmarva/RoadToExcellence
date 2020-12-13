package ch18.sec4.third;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 19:00
 */
public class Client {

    private final static String ADD_SYMBOL = "+";

    private final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
        int a = 1000;

        int b = 2000;

        String symbol = "+";

        Context context = null;
        if (symbol.equals(ADD_SYMBOL)) {
            context = new Context(new Add());
        } else if (symbol.equals(SUB_SYMBOL)) {
            context = new Context(new Sub());
        }

        System.out.println("result " + context.exec(a, b));
    }
}
