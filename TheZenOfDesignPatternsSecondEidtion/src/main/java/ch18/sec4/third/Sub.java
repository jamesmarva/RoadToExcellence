package ch18.sec4.third;

/**
 * 代码清单18-15 具体策略
 *
 * @author 王涵威
 * @date 20.12.13 18:55
 */
public class Sub implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
