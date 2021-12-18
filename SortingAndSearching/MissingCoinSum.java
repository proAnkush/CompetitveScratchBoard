import java.util.Arrays;
import java.util.Scanner;

public class MissingCoinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long cs = 0;
        for(int i = 0 ; i < n; i++){
            if(cs+1 < a[i]) break;
            cs+=a[i];
        }
        System.out.println(cs+1);
        sc.close();
    }
}
