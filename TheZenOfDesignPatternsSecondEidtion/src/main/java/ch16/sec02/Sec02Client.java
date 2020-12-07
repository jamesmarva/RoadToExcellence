package ch16.sec02;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-12-06 12:12
 **/
public class Sec02Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();

        Handler handler2 = new ConcreteHandler2();

        Handler handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        Response response = handler1.handleMessage(new Request());
    }

}
