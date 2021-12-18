import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Useless2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] baseCount = new int[501];
        int prev = 1;
        baseCount[1] = 1;
        for(int i = 2 ; i < 501; i++){
            baseCount[i] = (i*i) + baseCount[i-1];
        }
        while(T-->0){
            ArrayList<String> al = new ArrayList<>();
            int N = sc.nextInt();
            for(int i = 0 ; i < N; i++){
                al.add(sc.next());
            }
            int[][] ddp = new int[N+1][N+1];
            int[][] rdp = new int[N+1][N+1];
            int count = 0;
            for(int i = 1 ; i <= N; i++){
                for(int j = 1 ; j <= N; j++){
                    String s = al.get(i-1);
                    rdp[i][j] = rdp[i][j-1];
                    ddp[i][j] = ddp[i-1][j];
                    if(s.charAt(j-1) == '1'){
                        count++;
                        rdp[i][j] = rdp[i][j] + 1;
                        ddp[i][j] = ddp[i][j] + 1;
                    }
                }
            }
            // if k == 0 dist = 1
            if(count == 0) {
                System.out.println(0);
                continue;
            }else if(count == (N*N)){

                System.out.println(baseCount[N]);
                continue;
            }

            int k = 0;
            if(ddp[2][2] == 2 && rdp[2][2] == 2){
                k = 1;
            }
            for(int i = 2 ; i <= N; i++){
                if(ddp[i][i] == ddp[i-1][i-1]){
                    count += (k*k);
                    k++;
                }else{
                    count+=1;
                    k = 0;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
