import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //example 1
        IntSummaryStatistics s = IntStream.of(3, 4, 5, 7, 9, 11, 66).summaryStatistics();
        System.out.println("======== Ex 1 ===========");
        System.out.println(s.getMax());
        System.out.println(s.getMin());
        System.out.println(s.getAverage());
        System.out.println(s.getSum());
        System.out.println(s.getCount());

        //example 2 -Reduce Example
        System.out.println("======== Ex 2 ===========");
        int result = IntStream.of(3, 4, 5, 7, 9, 11, 66).reduce(0, (a, b) -> a + b);
        System.out.println("Reduce Result : " + result);

        //example 3 -Parallel Programing
        System.out.println("======== Ex 3-1 =========");
        Random random = new Random();
        int[] list = random.ints(50000000).toArray();
        System.out.println("Number of proccessors: " + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list)
                .filter(e -> e > 0)
                .sorted()
                .limit(5)
                .toArray();
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime - startTime) + " milliseconds.");

        System.out.println("======== Ex 3-2 =========");
        long startTime2 = System.currentTimeMillis();
        int[] list2 = IntStream.of(list)
                .parallel()
                .filter(e -> e > 0)
                .sorted()
                .limit(5)
                .toArray();
        System.out.println(Arrays.toString(list2));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime2 - startTime2) + " milliseconds.");

    }
}
