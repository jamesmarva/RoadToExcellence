package ch18.sec4.third;

/**
 * 代码清单18-16 上下文
 *
 * @author 王涵威
 * @date 20.12.13 18:58
 */
public class Context {

    private Calculator calculator = null;

    public Context(Calculator calculator) {
        this.calculator = calculator;
    }

    public int exec(int a, int b) {
        return this.calculator.exec(a, b);
    }
}
