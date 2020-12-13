package ch18.sec1;

/**
 * 〈功能概述〉<br>
 *
 * @author 王涵威
 * @date 20.12.13 16:38
 */
public class ZhaoYun {

    public static void main(String[] args) {
        Context jinNang;

        System.out.println("arrive wu");
        jinNang = new Context(new BackDoor());
        jinNang.operate();

        System.out.println("-----------");

        System.out.println("Liu Bei forget shu.");
        jinNang = new Context(new GivenGreenLight());
        jinNang.operate();


        System.out.println("------------------");
        System.out.println("sun quan get touch of Liu Bei");
        jinNang = new Context(new BlockEnemy());
        jinNang.operate();


    }
}
