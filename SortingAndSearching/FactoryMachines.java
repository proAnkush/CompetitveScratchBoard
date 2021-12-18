import java.util.Scanner;

public class FactoryMachines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long[] m = new long[n];
        for(int i = 0 ; i < n; i++){
            m[i] = sc.nextLong();
        }
        long ans = 0;
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while(lo <= hi){
            long sum = 0;
            long mid = (lo + hi)/2;
            for(long k : m){
                sum += mid/k;
                if(sum >= t) break;
            }
            if(sum >=t){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }

        }
        System.out.println(ans);
    }
}
