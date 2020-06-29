package ch03;

import java.util.stream.Stream;

/**
 * 获取流元素的数量
 *
 * @author 王涵威
 * @date 2020/6/29 21:42
 */
public class Ch03Sec07 {


    public static void main(String[] args) {

    }

    /**
     *
     */
    public static void countOfStream() {
        long count = Stream.of(1, 2, 3, 4, 1,1,1,1,1,1)
                .count();
        System.out.println("count: " + count);
    }

    /**
     *
     */
    public static void countByMap() {
        long count = Stream.of(1, 2, 3, 4, 1,1,1,1,1,1)
                .mapToLong(n -> 1L)
                .sum();
        System.out.println("count: " + count);
    }
}
