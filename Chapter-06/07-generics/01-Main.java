class Info<T, K> {
    private T Key;
    private K value;


    public T getKey() {
        return Key;
    }

    public void setKey(T key) {
        Key = key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}


public class Main {
    public static void main(String[] args) {
        Info<String,Integer> myInfo = new Info<>();
        myInfo.setKey("Farmer");
        myInfo.setValue((3000));
        System.out.println("Key:"+myInfo.getKey()+",and the Value is:"+ myInfo.getValue());
    }
}
