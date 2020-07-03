package ch03;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

/**
 * 统计汇总
 * 用户希望获取流中的元素的数量、总和、最小值，最大值，以及平均值
 *
 * @author 王涵威
 * @date 2020/6/30 9:36
 */
public class Ch03Sec08 {
    public static void main(String[] args) {
        summaryStatistics();
        double ans = 0.0;
        ans = 2/5;
        System.out.println(ans);
    }

    /**
     * 利用SummaryStatistics 进行数据统计
     */
    private static void summaryStatistics() {
        DoubleSummaryStatistics statistics = DoubleStream.generate(Math::random)
                .limit(1000_000)
                .summaryStatistics();
        System.out.println(statistics);

        System.out.println("count: " + statistics.getCount());
        System.out.println("min: " + statistics.getMin());
        System.out.println("max: " + statistics.getMax());
        System.out.println("sum: " + statistics.getSum());
        System.out.println("ave: " + statistics.getAverage());

    }


}
