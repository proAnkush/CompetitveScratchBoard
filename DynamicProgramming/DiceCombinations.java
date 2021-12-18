import java.util.Arrays;
import java.util.Scanner;

/**
 * DiceCombinations
 */
public class DiceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = (long) (1e9+7);
        sc.close();
        long[] dp = new long[n+2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i < dp.length; i++){
            for(int d = 1; d <= 6; d++){
                if(i >= d){
                    dp[i] += dp[i-d];
                    dp[i] %= m;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[n+1]);


    }
    
}