import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class UseLessGridSquarBR {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int T = Integer.parseInt(br.readLine());
        long[] squares = new long[501];
        squares[1] = 1;
        for(int i = 2; i < 500; i++){
            squares[i] = squares[i-1] + (i*i);
        }
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] a = new String[n];
            long count = 0;
            for(int i = 0 ; i < n; i++){
                a[i] = br.readLine();
                for(int j = 0 ; j < n; j++){
                    if(a[i].charAt(j) == '1'){
                        count++;
                    }
                }
            }
            if(count == n*n){
                System.out.println(squares[n]);
                continue;
            }
            if(count <= 3){
                System.out.println(count);
                continue;
            }
            int[][] downCount = new int[n][n];
            int[][] rightCount = new int[n][n];

            for(int i = 0 ; i < n; i++){
                
                for(int j = 0 ; j < n; j++){
                    if(i == 0 && j==0){
                        if(a[i].charAt(j) == '1'){
                            downCount[i][j] = 1;
                            rightCount[i][j] = 1;
                        }
                        continue;
                    }
                    if(i == 0 ){
                        if(a[i].charAt(j) == '1'){
                            downCount[i][j] = 1;
                            rightCount[i][j] = rightCount[i][j-1] + 1;
                        }
                        continue;
                    }
                    if(j == 0){
                        if(a[i].charAt(j) == '1'){
                            downCount[i][j] = downCount[i-1][j] + 1;
                            rightCount[i][j] = 1;
                        }
                        continue;
                    }
                    downCount[i][j] = downCount[i-1][j];
                    rightCount[i][j] = rightCount[i][j-1];
                    if(a[i].charAt(j) == '1'){
                        rightCount[i][j] += 1;
                        downCount[i][j] += 1;
                    }
                }
            }
            // print(downCount, rightCount);

            boolean[][] visited = new boolean[n][n];
            for(int k = 2; k <= n; k++){
                for(int i = k-1; i < n; i++){
                    for(int j = k-1; j < n; j++){
                        if(a[i].charAt(j) == '1' && checkFrame(a, i, j, k, downCount, rightCount)){
                            // System.out.printf("I: %d, J: %d, K: %d\n", i, j, k);
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static boolean checkFrame(String[] a, int i, int j, int k,int[][] downCount, int[][] rightCount){
        boolean ans = false;
        k-=1;
        // System.out.printf("I: %d, J: %d, K: %d\n", i, j, k);
        // System.out.printf("dc[i][j] = %d, dc[i-k][j] = %d, dc[i][j-k] = %d, dc[i-k][j-k] = %d\n", downCount[i][j],
        //     downCount[i-k][j], downCount[i][j-k], downCount[i-k][j-k]);

        // System.out.printf("rc[i][j] = %d, rc[i][j-k] = %d, rc[i-k][j] = %d, rc[i-k][j-k] = %d\n", rightCount[i][j],
        //     rightCount[i][j-k], rightCount[i-k][j], rightCount[i-k][j-k]);
        if(downCount[i][j] - downCount[i-k][j] == (k) &&
        rightCount[i][j] - rightCount[i][j-k] == (k) &&
        rightCount[i-k][j] - rightCount[i-k][j-k] == (k) &&
        downCount[i][j-k] - downCount[i-k][j-k] == (k) && 
        a[i].charAt(j-k) == '1' && a[i-k].charAt(j) == '1' &&
        a[i-k].charAt(j-k) == '1'){
            ans = true;
        }
        return ans;

    }
    public static void print(int[][] dc, int[][] rc){
        System.out.println("Down Count ======");
        for(int[] a : dc){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("Right Count =======");
        for(int[] a : rc){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("Print dc,rc finishedd");
    }
}
