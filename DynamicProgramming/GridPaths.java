import java.util.Arrays;
import java.util.Scanner;

public class GridPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int)1e9+7;
        char[][] g= new char[n][n];
        for(int i = 0 ; i < n; i++){
            String in = sc.next();
            for(int j = 0 ; j < n; j++){
                g[i][j] = in.charAt(j);
            }
        }
        sc.close();

        int[][] dp = new int[n][n];
        dp[n-1][n-1] = 1;
        if(g[n-1][n-1] == '*'){
            dp[n-1][n-1] = 0;
            System.out.println(0);
            return;
        }
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(g[i][j] == '*') continue;
                if(i > 0 && g[i-1][j] == '.'){
                    dp[i-1][j] += dp[i][j];
                    dp[i-1][j] %= mod;
                }
                if(j > 0 && g[i][j-1] == '.'){
                    dp[i][j-1] += dp[i][j];
                    dp[i][j-1] %= mod;
                }
            }
        }

        System.out.println(dp[0][0]);
        //System.out.println(help(g, 0, 0));
    }
    public static int help(char[][] g, int i, int j){
        int n = g.length;
        if(i == n-1 && j == n-1){
            return 1;
        }
        if(i == n | j == n) return 0;
        if(g[i][j] == '*') return 0;
        if( (j < n-1 && g[i][j+1] == '*') && ( i < n-1 && g[i+1][j] == '*')) return 0;
        return help(g, i+1, j) + help(g, i, j+1);

    }
}
