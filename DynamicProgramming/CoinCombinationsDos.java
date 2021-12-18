import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoinCombinationsDos {
    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int x = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int mod = (int) 1e9+7;
        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[x+10];
        dp[0] = 1;
        for(int a : c){
            for(int i = 1; i <= x; i++){
                if(i - a >= 0){
                    dp[i] += dp[i-a];
                    dp[i] %= mod;
                }
            }
        }
        System.out.println(dp[x]);
        // System.out.println(help(c, x));
    }
    public static int help(int[] c, int x){
        if(x < 0) return 0;
        if(x == 0) return 1;
        int count = 0;
        for(int a : c){
            if(x - a >= 0){
                count += help(c, x-a);
                count %= 1e9+7;
            }
        }
        return count;

    }
}
