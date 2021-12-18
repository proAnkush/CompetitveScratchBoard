import java.util.Arrays;
import java.util.Scanner;

public class Apartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < m; i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0, count = 0;
        while(i < n && j < m){
            if(inRange(a[i], b[j], k)){
                j++;
                count++;
                i++;
            }else{
                if(a[i] > b[j]+k){
                    j++;
                }else{
                    i++;
                }
            }
        }
        System.out.println(count);

    }
    public static boolean inRange(int a, int b, int k){
        if(a >= b-k && a <= b+k) return true;
        return false;
    }
}
