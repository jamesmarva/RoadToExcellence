package ch18.sec2;

import java.util.Objects;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 16:53
 */
public class Context {

    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public  void doAnything() {
        Objects.requireNonNull(this.strategy, "strategy is null").doSomething();
    }
}
