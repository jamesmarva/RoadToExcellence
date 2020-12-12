package ch18.sec1;

/**
 代码清单18-1 妙计接口
 * 定义了一个方法operate，每个妙计都是可执行的，否则那叫什么妙计
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-12-12 14:44
 **/
public interface IStrategy {

    /**
     * op
     */
    public void operate();
}
