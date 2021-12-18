import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[n+20];
        Arrays.fill(dp, Integer.MAX_VALUE-10000);
        for(int i = 0; i < 10; i++){
            dp[i] = 1;
        }
        for(int i = 10 ; i <= n; i++){
            int temp = i;
            
            while(temp > 0){
                int digit = temp %10;
                temp/=10;
                if(digit == 0) continue;
                dp[i] = Math.min(dp[i], dp[i-digit]+1);
            }

        }
        System.out.println(dp[n]);
        // System.out.println(help(n));
    }
    public static int help(int n){
        if(n < 0) return Integer.MAX_VALUE;
        if(n < 10){
            return 1;
        }
        int count = Integer.MAX_VALUE;
        int temp = n;
        while(temp > 0){
            int digit = temp % 10;
            temp /= 10;
            if(digit == 0) continue;
            count = Math.min(count, help(n-digit)+1);
        }
        return count;
    }

}
