import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CollectingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            int t = a[i];
            if(!map.containsKey(t-1)){
                map.put(t, new ArrayList<>());

            }else{
                ArrayList<Integer> temp = map.get(t-1);
                temp.add(t-1);
                map.put(t, temp);
                map.remove(t-1);
            }
        }
        System.out.println(map.size());
    }
}
