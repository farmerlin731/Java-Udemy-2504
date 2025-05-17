import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        //Example1
        Stream<String> bands = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);

        bands.sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

        //Example2
        Stream<String> bandsB = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);

        List<String> myList = bandsB.filter(x -> x.contains("jit"))
                .toList();

        myList.forEach(System.out::println);
        bandsB.close();


    }
}