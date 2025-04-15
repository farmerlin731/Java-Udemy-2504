public class Main {
    public static void ninetable(){
                for(int i = 1;i<=9;i++){
            for(int j = 1;j<=9;j++){
                String ans = i+" * "+j+" = "+i*j;
                System.out.println(ans);
            }
        }
    }
    public static void main(String[] args) {
        ninetable();
    }
}