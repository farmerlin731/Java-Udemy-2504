public class Main {
    public static void main(String[] args) {
        int x = 5 ;
        //x = x+1;
        x += 1; // Syntax Sugar
        System.out.println(x);

        //String methods.
        String name = "FarmerLin";
        //For any String, index 0,1,2,3,...
        System.out.println(name.length());
        System.out.println(name.toLowerCase());
        System.out.println(name.charAt(2));
        System.out.println(name.indexOf("Li"));

        //Relational & Conditional operator
        System.out.println( (3 == 3) && (5 > 2) );

        //non-primitive
        System.out.println("Farmer".equals("Farmer"));

        //concat
        System.out.println(15+15+"15"+15+15);
    }
}
