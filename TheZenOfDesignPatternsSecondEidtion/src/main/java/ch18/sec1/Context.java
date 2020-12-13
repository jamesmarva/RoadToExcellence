package ch18.sec1;

/**
 * 代码清单18-5 锦囊
 *
 *
 * @author 王涵威
 * @date 20.12.13 16:35
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}
