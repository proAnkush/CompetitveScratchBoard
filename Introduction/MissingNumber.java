
import java.util.Scanner;
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n-1; i++){
            a[sc.nextInt()-1] = 1;
        }
        for(int i = 0 ; i < n; i++){
            if(a[i] == 0) System.out.println(i+1);
        }
        
        sc.close();
    }
}
