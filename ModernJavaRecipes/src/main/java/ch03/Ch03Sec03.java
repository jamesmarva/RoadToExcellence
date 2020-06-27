package ch03;

import java.io.PipedReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 *
 * 用户希望通过流操作生成单一值
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-06-27 21:50
 **/
public class Ch03Sec03 {


    public static void main(String[] args) {
        reduceDemo01();
        addPowTwoWrong();
        addPowTwoRight();
    }


    private void reduceDemo() {
        String[] stringArray = "this is an array of Strings.".split(" ");
        long countt = Arrays.stream(stringArray).map(String::length).count();

        System.out.println("long: " +   countt);

        int totalLength = Arrays.stream(stringArray).mapToInt(String::length).sum();

        System.out.println("sum : " + totalLength);

        OptionalDouble average  = Arrays.stream(stringArray).mapToInt(String::length).average();

        OptionalInt max = Arrays.stream(stringArray).mapToInt(String::length).max();

        OptionalInt min = Arrays.stream(stringArray).mapToInt(String::length).min();
    }

    /**
     *
     */
    private static void reduceDemo01() {
        int sum = IntStream.rangeClosed(1, 10).reduce((x, y) -> {
            System.out.printf("x=%d, y=%d \n", x, y);
            return x + y;
        }).orElse(0);
        System.out.println("sum: " + sum);

    }

    private static void addPowTwoWrong() {
        int doubleSum = IntStream.rangeClosed(1, 10).reduce((x, y) -> x + 2 * y).orElse(0);
        System.out.println("doubleSum: " + doubleSum);
    }


    private static void addPowTwoRight() {
        int doubleSum = IntStream.rangeClosed(1, 10).reduce(0, (x, y) -> x + 2 * y);
        System.out.println("oubleSum: " + doubleSum);
    }
}
