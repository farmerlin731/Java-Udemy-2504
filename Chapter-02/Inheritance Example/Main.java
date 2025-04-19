public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Mary",25,"English","Math");
        Student s1 = new Student("Farmer",15,"Taipei",99);

        t1.sleep();
        t1.teach();

        s1.walk();
        s1.test();
    }
}
