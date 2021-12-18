import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MoneySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            max += x[i];
        }
        sc.close();
        boolean[][] dp = new boolean[n+10][max+10];
        dp[0][0] = true;
        for(int i = 1 ; i <= n; i++){
            for(int j = 0 ; j <= max; j++){
                dp[i][j] = dp[i-1][j];
                int p = j - x[i-1];
                if(p >= 0 && dp[i-1][p]){
                    dp[i][j] = true;
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i <= max; i++){
            if(dp[n][i]) al.add(i);
        }
        System.out.println(al.size());
        for(int t : al){
            System.out.printf("%d ", t);
        }
        System.out.println();
    }
}
