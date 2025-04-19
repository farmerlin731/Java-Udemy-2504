public class Teacher extends People{
    private String subject;

    public Teacher(String name, int age, String address, String subject){
        super(name,age,address);
        this.subject = subject;
    }

    public void teach(){
        System.out.println("i am teach "+this.subject+"...");
    }
}
