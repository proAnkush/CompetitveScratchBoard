import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        int i = 0, j = n-1;
        while(i <= j){
            if(a[i] + a[j] <= x){
                count++;
                i++;
                j--;
            }else{
                j--;
                count++;
            }
        }
        System.out.println(count);


    }
}
