import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * MovieTickets
 */
public class MovieTickets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MoviePair[] arr = new MoviePair[n];
        for(int i = 0 ; i < n; i++){
            long s = sc.nextLong();
            long e = sc.nextLong();
            arr[i] = new MoviePair(s, e);
        }
        Arrays.sort(arr, new Comparator<MoviePair>() {
            @Override
            public int compare(MoviePair p1, MoviePair p2) {
                return Long.compare(p1.end, p2.end);
            }
        }.thenComparing(new Comparator<MoviePair>() {
            @Override
            public int compare(MoviePair p1, MoviePair p2) {
                return Long.compare(p1.start, p2.start);
            }
        }));
        int count = 0;
        long currTime = 0;
        int maxCount = 1;
        for(int i = 0 ; i < n; i++){
            if(arr[i].start >= currTime){
                count++;
                currTime = arr[i].end;
            }
            maxCount = Math.max(count, maxCount);
        }
        System.out.println(maxCount);
        sc.close();
    }
}
class MoviePair{
    long start, end;
    MoviePair(long s, long e){
        this.start = s;
        this.end = e;
    }
}