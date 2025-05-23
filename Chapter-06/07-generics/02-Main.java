interface Content<T> {
    T text();
}

class GenericsContent<T> implements Content<T> {
    private T myText;

    GenericsContent(T text) {
        this.myText = text;
    }

    @Override
    public T text() {
        return this.myText;
    }
}

public class Main implements Content<Integer> {
    public static void main(String[] args) {
        //From Implement
        Main m = new Main();
        System.out.println("From Main::" + m.text());

        //From Outer Class
        GenericsContent<String> gt= new GenericsContent<>("Hello World!:)");
        System.out.println("From Class:" + gt.text());

        //From Inner Method
        System.out.println(printHello("Farmer"));
    }

    public static <T> T printHello(T obj){
        System.out.println(obj.getClass().getName());
        return  (T) (obj+" - yayaya!");
    }
    @Override
    public Integer text() {
        return 666;
    }
}
