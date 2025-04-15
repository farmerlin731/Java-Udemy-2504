public class FindMax {
    public static int findMax(int[] array){
        int ans = 0;
        for(int i : array){
            if(i>ans) ans = i;
        }
        return  ans;
    }
    public static void main(String[] args) {
        int[] array = {4, 3, 6, 7, 9, 10, 33, 0, -4, 12, 400, 133, 324, 1234231, 12334};
        System.out.println(findMax(array));
    }
}
