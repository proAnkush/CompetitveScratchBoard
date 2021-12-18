import java.util.ArrayList;
import java.util.Scanner;

/**
 * Towers
 */
public class Towers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> cubes = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            long curr = sc.nextLong();
            int lo = 0, hi = cubes.size();
            while(lo < hi){
                 int mid = (lo+hi) / 2;
                 if(cubes.get(mid) > curr) hi = mid;
                 else lo = mid + 1;
            }
            if(lo == cubes.size()) cubes.add(curr);
            else cubes.set(lo, curr); 
        }
        System.out.println(cubes.size());
    }
}