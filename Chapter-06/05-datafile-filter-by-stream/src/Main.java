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
        Stream<String> rows = Files.lines(Paths.get("data.txt"), StandardCharsets.UTF_8);

        rows.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x->Integer.parseInt(x[1])>15)
                .forEach(x-> System.out.println(String.join(",",x)));

        rows.close();
    }
}