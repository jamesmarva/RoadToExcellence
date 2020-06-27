package ch03;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-06-27 18:42
 **/
public class Ch03Sec01 {

    public static void main(String[] args) {
        createStreamByIterate();
    }
    private static void createStreamOf() {
        try {
            String names = Stream.of("www", "hhh", "www")
                    .collect(Collectors.joining(";"));
            System.out.println("names:" + names);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createArraysStream() {
        String[] names = {"wwww", "hhh", "wwww"};
        String allNaem = Arrays.stream(names).collect(Collectors.joining(";"));
    }

    private static void createStreamByIterate() {
        List<BigDecimal> list = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(list);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1))
                .limit(10)
                .forEach(System.out::println);
    }
}
