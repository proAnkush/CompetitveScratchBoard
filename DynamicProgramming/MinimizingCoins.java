import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n coins
        int x = sc.nextInt(); // amount to make
        int[] c = new int[n]; // all available coins
        int[] dp = new int[x+10];
        Arrays.fill(dp, Integer.MAX_VALUE-169);
        for(int i = 0 ; i < n; i++){
            c[i] = sc.nextInt();
        }
        dp[0] = 0;
        for(int i = 1; i <= x; i++){
            for(int a : c){
                if(i-a >= 0){
                    dp[i] = Math.min(dp[i], dp[i-a] + 1);
                }
            }
        }
        if(dp[x] == Integer.MAX_VALUE-169){
            System.out.println(-1);
        }else{

            System.out.println(dp[x]);
        }
        // System.out.println(help(c, x));

        

    }
    public static int help(int[] c, int x){
        if(x < 0){
            return 10000;
        }
        if(x == 0){
            return 0;
        }
        int min = 10000;
        for(int a : c){
            min = Math.min(min, help(c, x - a) +1);
        }
        return min;
    }
}
