import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SumOfTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long req = sc.nextLong();
        long[] a = new long[n];
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            long in = sc.nextLong();
            a[i] = in;
            map.put(in, i);
        }
        for(int i = 0 ; i < n-2; i++){
            for(int j = i+1 ; j < n-1; j++){
                long want = req - (a[i]+a[j]);
                if(map.containsKey(want) && map.get(want) != i && map.get(want) != j){
                    System.out.printf("%d %d %d\n", i+1, j+1, map.get(want) +1);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
