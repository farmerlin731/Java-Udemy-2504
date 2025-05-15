interface Add5{
    int add5(int x);
}

public class Main{
    public static void main(String[] args){
        System.out.println("hello world:)");
        Add5 myAdd5Obj = x -> x+5;
        System.out.println(myAdd5Obj.add5(10));
    }
}