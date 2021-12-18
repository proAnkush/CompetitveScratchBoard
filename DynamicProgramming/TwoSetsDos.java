import java.util.Scanner;

public class TwoSetsDos {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int mod = (int) 1e9+7;

        int maxSum = (n*(n+1))/2;
        if((maxSum&1)==1){
            System.out.println(0);
            return;
        }
        maxSum /= 2;
        int[][] dp = new int[n+1][maxSum+1];
        dp[0][0] = 1;
        for(int i=1; i < n; i++){
            for(int j = 0; j <= maxSum; j++){
                dp[i][j] = dp[i-1][j];
                if(j-i >= 0){
                    dp[i][j] += dp[i-1][j-i];
                    dp[i][j] %= mod;
                }
            }

        }
        System.out.println(dp[n-1][maxSum]);

    }
}
