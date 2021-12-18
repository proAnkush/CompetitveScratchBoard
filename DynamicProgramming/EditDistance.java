import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, 100069);
        }
        for(int i = 0 ; i <= n; i++){
            for(int j = 0 ; j <= m; j++){
                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }else if(j == 0){
                    dp[i][j] = i;
                    continue;
                }
                else if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                } 
                dp[i][j] =1+ min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[n][m]);

        // System.out.println(help(s, t, 0, 0));
    }
    public static int help(String s, String t, int x, int y){
        if(x >= s.length() & y >= t.length()) return 0;
        else if(x >= s.length() && y < t.length()) return t.length() - y;
        else if(x < s.length() && y >= t.length()) return s.length() - x;

        if(s.charAt(x) == t.charAt(y)) return help(s, t, x+1, y+1);
        else return min(
            help(s, t, x, y+1) + 1, 
            help(s, t, x+1, y) + 1, 
            help(s, t, x+1, y+1) + 1);

    }
    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
