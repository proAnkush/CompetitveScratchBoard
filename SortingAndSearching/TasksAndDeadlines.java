import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TasksAndDeadlines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AD[] arr = new AD[n];
        for(int i = 0; i < n; i++){
            arr[i] = new AD(sc.nextLong(), sc.nextLong());
        }
        sc.close();
        Arrays.sort(arr, new Comparator<AD>() {
            public int compare(AD m, AD n){
                if(m.a == n.a) return Long.compare(m.d, n.d);
                return Long.compare(m.a, n.a);
            }
        });
        long currTime = 0;
        long profit = 0;
        for(AD t : arr){
            currTime += t.a;
            profit += t.d - currTime;
        }
        System.out.println(profit);
    }
}
class AD{
    long a, d;
    public AD(long x, long y){
        a = x;
        d = y;
    }
}
