import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SumOfCuatro {
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

        
        for(int i = 0 ; i < n-3; i++){
            for(int j = i+1 ; j < n-2; j++){
                for(int k = j+1; k < n-1; k++){

                    long want = req - (a[i]+a[j]+a[k]);
                    if(map.containsKey(want) && map.get(want) != i && map.get(want) != j && map.get(want) != k){
                        // System.out.println(a[i] + a[j] + a[k] + a[map.get(want)]);
                        System.out.printf("%d %d %d %d\n", i+1, j+1, k+1, map.get(want) +1);
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
