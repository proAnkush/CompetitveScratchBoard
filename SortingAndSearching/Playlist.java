import java.util.HashSet;
import java.util.Scanner;

public class Playlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        HashSet<Long> set = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextLong();
        }
        sc.close();
        int elmer = 0;
        int daffy = 0;
        int maxDist = 0;
        while(daffy < n){
            // System.out.println(" Elmer: " + elmer + " Daffy: " + daffy);
            if(!set.contains(a[daffy])){
                set.add(a[daffy]);
                daffy++;
            }else if(a[elmer] == a[daffy]){
                set.remove(a[elmer]);
                elmer++;
            }
            else{
                set.remove(a[elmer]);
                elmer++;
            }
            maxDist = Math.max(maxDist, daffy-elmer);
        }
        System.out.println(maxDist);
        
    }
}
