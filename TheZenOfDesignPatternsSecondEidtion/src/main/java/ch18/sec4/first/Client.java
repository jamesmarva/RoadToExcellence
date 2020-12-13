package ch18.sec4.first;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 17:03
 */
public class Client {

    public static void main(String[] args) {
        int a = 10000;

        int b = 10000;
        Calculator calculator =  new Calculator();
        int result = calculator.exec(a, b, "+");
        System.out.println("result: " + result);


    }
}
