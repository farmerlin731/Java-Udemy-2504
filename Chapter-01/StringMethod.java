public class Main {
    public static void main(String[] args) {
        String s = "Hello, how r u doing today?";
        String[] myArr = s.split(" ");
        for(String word:myArr){
            System.out.println(word);
        }

        String newS = "Hello World :)";
        newS = newS.substring(0,4);
        System.out.println(newS+);
    }
}