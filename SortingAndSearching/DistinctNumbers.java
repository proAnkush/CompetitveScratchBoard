import java.util.Arrays;
import java.util.Scanner;

/**
 * DistinctNumbers
 */
public class DistinctNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(i < n-1 && arr[i] == arr[i+1]){
                continue;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}