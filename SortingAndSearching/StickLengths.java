import java.util.Arrays;
import java.util.Scanner;

/**
 * StickLengths
 */
public class StickLengths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }
        if(n == 1) {
            System.out.println(0);
            return;
        }
        sc.close();
        Arrays.sort(a);
        long median = a[n/2];
        long x = 0;
        for(int i = 0; i < n; i++){
            x += Math.abs(median - a[i]);
        }
        System.out.println(x);
    }
}