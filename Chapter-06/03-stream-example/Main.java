import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Farmer", "Ron", "Grace", "Jack", "Ray"};

        //Example 1
        Arrays.stream(names)
                .filter(name -> name.startsWith("R"))
                .forEach(name -> System.out.println(name));

        //Example2
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(num -> num*num)
                .average()
                .ifPresent(System.out::println);

        //Example3
        ArrayList<String> people = new ArrayList<>();
        people.add("Allen");
        people.add("Aloha");
        people.add("Mary");
        people.add("Jason");
        people.stream()
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

    }
}