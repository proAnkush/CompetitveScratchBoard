import java.util.Arrays;
import java.util.Scanner;

/**
 * ApplesDivision
 */
public class ApplesDivision {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextLong();
        }
        sc.close();
        long S = sum(a);
        System.out.println(helpRec(a, n, 0, S));
    }
    public static long helpRec(long[] a, int n, long s1, long S) {
        if(n == 0){
            return Math.abs((S-s1)-s1);
        }else{
            return Math.min(
                helpRec(a, n-1, s1+a[n-1], S),
                helpRec(a, n-1, s1, S)
            );
        }
    }

    public static long sum(long[] a) {
        long sum =0;
        for(long t : a){
            sum += t;

        }
        return sum;
    }


}