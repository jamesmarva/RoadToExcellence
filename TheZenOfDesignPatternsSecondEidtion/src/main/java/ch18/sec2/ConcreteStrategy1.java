package ch18.sec2;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 16:51
 */
public class ConcreteStrategy1 implements Strategy {


    @Override
    public void doSomething() {
        System.out.println("Concrete Strategy 1");
    }
}
