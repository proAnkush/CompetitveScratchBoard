import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.validation.SchemaFactoryConfigurationError;

/**
 * SumOfTwoValues
 */
public class SumOfTwoValues {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long x;
        n = sc.nextInt();
        x = sc.nextLong();
        HashMap<Long, Integer> map = new HashMap<>();
        long[] arr = new long[n+1];
        long low = Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;
        long lessHigh = Integer.MIN_VALUE;
        for(int i =1; i <= n; i++){
            long key = sc.nextLong();
            low = Math.min(low, key);
            if(key >= high){
                lessHigh = high;
                high = key;
            }
            arr[i] = key;
            map.put(key, i);
        }
        sc.close();
        if((x < low && low != Integer.MAX_VALUE) || ((high+lessHigh) < x && high >= 0 && lessHigh >= 0)){
            System.out.println("IMPOSSIBLE");
            return;
        }
        for(int i = 1 ; i <=n; i++){
            long diff = x - arr[i];
            if(diff >= 0 && map.containsKey(diff) && map.get(diff) != i){
                System.out.println(i + " " + map.get(diff));
                return;
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}