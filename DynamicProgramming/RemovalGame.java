import java.util.Scanner;

public class RemovalGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0 ; i  <n;i++){
            a[i] = sc.nextLong();
        }
        long[][] dp = new long[n+5][n+5];
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++,j++){
                long x = ((i+2) <= j) ? dp[i+2][j] : 0;
                long y = ((i+1) <= (j-1) ) ? dp[i+1][j-1] : 0;
                long z = ((i) <= j-2) ? dp[i][j-2] : 0;
                dp[i][j] = Math.max(a[i] + Math.min(x, y), a[j] + Math.min(y,z));
            }
        }
        System.out.println(dp[0][n-1]);

        // System.out.println(help(a, 0, n-1));
    }
    public static long help(long[] a, int l, int r){
        if(l == r) return a[l];
        if(r == l+1) return Math.max(a[l], a[r]);
        return Math.max(a[l] + Math.min(help(a, l+2, r), help(a, l+1, r-1)), a[r] + Math.min(help(a, l, r-2), help(a, l+1, r-1)));
    }

}
