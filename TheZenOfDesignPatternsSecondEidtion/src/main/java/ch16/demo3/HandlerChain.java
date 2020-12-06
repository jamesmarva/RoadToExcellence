package ch16.demo3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-12-06 13:36
 **/
public class HandlerChain {

    Map<Level, Handler> chain = new ConcurrentHashMap<>();



    public static void put(Level level, Handler handler) {

    }

}
