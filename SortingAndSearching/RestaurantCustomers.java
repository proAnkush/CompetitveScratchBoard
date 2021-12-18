import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * RestaurantCustomers
 */
public class RestaurantCustomers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] arr = new Pair[n*2];
        for(int i = 0 ; i< n*2; i++){
            arr[i] = new Pair(sc.nextLong(), true);
            arr[++i]  = new Pair(sc.nextLong(), false);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2){
                return Long.compare(p1.start, p2.start);
            }
        });
        int count = 0;
        int maxCount = 1;
        for(Pair p : arr){
            if(p.enter){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count--;
            }
        }
        System.out.println(maxCount);
    }
}
/**
 * Pair
 */
class Pair {
    long start;
    boolean enter;
    Pair(long s, boolean e){
        start = s;
        enter = e;
    }
    
}