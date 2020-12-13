package ch18.sec4.forth;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 19:11
 */
public class Client {

    public static void main(String[] args) {
        int a = 10002;
        int b = 1003;
        String symbol = "+";

        System.out.println("result: " + Calculator.ADD.exec(a, b));
    }
}
