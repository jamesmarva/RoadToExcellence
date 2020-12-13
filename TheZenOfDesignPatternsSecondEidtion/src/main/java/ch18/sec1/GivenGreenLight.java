package ch18.sec1;

/**
 * 代码清单18-3 吴国太开绿灯
 *
 * @author 王涵威
 * @date 20.12.13 16:28
 */
public class GivenGreenLight implements IStrategy{
    @Override
    public void operate() {
        System.out.println("第二个妙计是找吴国太哭诉，企图给自己开绿灯");
    }
}
