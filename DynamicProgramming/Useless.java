import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Useless
 */
public class Useless {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            // ArrayList<Pair> al = new ArrayList<>();
            long number = -1;
            for(long i = 0 ; i < n; i++){
                number = sc.nextInt();
                map.put(number, map.getOrDefault(number, 0l)+1);
            }
            long max = -1;
            for(long val : map.values()){
                max = Math.max(val, max);
            }
            if(n == 1 | max == n){
                System.out.println(0);
                continue;
            } 

            if(map.isEmpty() || max <= 1){
                System.out.println(-1);
                continue;
            }
            long count = n - max + 1;
            System.out.println(count);



        }
        sc.close();



    }
}
class Pair{
    int e;
    int count;
    Pair(int a, int b){
        e = a;
        count = b;
    }
}