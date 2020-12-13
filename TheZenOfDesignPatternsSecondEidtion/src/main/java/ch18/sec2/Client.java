package ch18.sec2;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 16:54
 */
public class Client {

    public static void main(String[] args) {
        Strategy strategy1 = new ConcreteStrategy1();

        Context context = new Context(strategy1);

        context.doAnything();

    }
}
