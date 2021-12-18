import java.util.Scanner;

public class SubarrayDivisi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }
        sc.close();
        long count = 0;
        for(int i = 0 ; i < n; i++){
            long sum = a[i];
            if(sum % n == 0) count++;
            for(int j = i+1; j < n; j++){
                sum += a[j];
                if(sum % n == 0) count++;
            }
        }
        System.out.println(count);
    }
}
