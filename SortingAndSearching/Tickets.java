import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Tickets
 */
public class Tickets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            a.add(i, sc.nextLong());
        }
        long[] b = new long[m];
        for(int i = 0 ; i < m; i++){
            b[i] = sc.nextLong();
        }
        Collections.sort(a);
        for(int i = 0 ; i < m; i++){
            if(a.size()==0){
                System.out.print("-1 ");
                continue;
            }
            int x = binSearch(a, b[i]);
            if(x == -1) System.out.print("-1 ");
            else{
                
                System.out.print(a.get(x) + " ");
                a.remove(x);
            }
        }
        System.out.println();

    }
    public static int binSearch(ArrayList<Long> a, long key){
        int l = 0;
        int r = a.size()-1;
        int ans = l;
        while(l <= r){
            int mid = (l + r)/2;
            if(a.get(mid) == key){
                return mid;
            }
            else if(a.get(mid) < key){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        if(a.get(ans) <= key) return ans;
        return -1;
    }
}