package ch18.sec1;

/**
 *
 * 代码清单18-4 孙夫人断后
 * @author 王涵威
 * @date 20.12.13 16:31
 */
public class BlockEnemy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("第三个妙计是在逃跑的时候，让新娘子孙夫人断后，谁来砍谁");
    }
}
