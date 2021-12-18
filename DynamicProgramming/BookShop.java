import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookShop {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int x = sc.nextInt();
        // int[] price = new int[n];
        // int[] pages = new int[n];
        // for(int i = 0 ; i < n; i++){
        //     price[i] = sc.nextInt();
        // }
        // for(int i = 0 ; i < n; i++){
        //     pages[i] = sc.nextInt();
        // }
        // sc.close();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		// Read in the cost array.
		int[] price = new int[n];
		st = new StringTokenizer(b.readLine());
		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// Read in the pages array.
		int[] pages = new int[n];
		st = new StringTokenizer(b.readLine());
		for (int i = 0; i < n; i++) {
			pages[i] = Integer.parseInt(st.nextToken());
		}



        int[][] dp = new int[n+10][x+10];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j <= x; j++){
                dp[i+1][j] = dp[i][j];
                if(price[i] <= j){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-price[i]]+pages[i]);
                }
            }
        }
        System.out.println(dp[n][x]);



        // System.out.println(help(price, pages, x, n-1, 0));
    }
    public static int help(int[] price, int[] pages, int x, int n, int count){
        if(x == 0 | n < 0) return count;
        if(price[n] <= x ){
            return Math.max(help(price, pages, x, n-1, count), help(price, pages, x-price[n], n-1, count+pages[n]));
        }
        return help(price, pages, x, n-1, count);
    }
}
