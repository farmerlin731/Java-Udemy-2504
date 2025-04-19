public class Student extends People{
    private int grade;
    public Student(String name, int age, String address,int grade){
        super(name,age,address);
        this.grade = grade;
    }

    public void test(){
        System.out.println("I got "+grade);
    }
}
