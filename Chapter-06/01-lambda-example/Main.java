import java.util.Arrays;

interface Add5 {
    int add5(int x);
}

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world:)");
        Add5 myAdd5Obj = x -> x + 5;
        System.out.println(myAdd5Obj.add5(10));

        int[] array = Arrays.stream(new int[]{1, 2, 3, 4, 5}).map(a -> a * 5).toArray();
        for (int e : array) {
            System.out.println(e);
        }
    }
}