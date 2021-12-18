import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumUno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long req = sc.nextLong();
        long count =0;
        long currSum = 0;
        HashMap<Long, Long> map = new HashMap<>(); 
        for(int i = 0 ; i < n; i++){
            long currValue =sc.nextLong();
            currSum += currValue;
            if(currSum == req) count++;
            if(map.containsKey(currSum - req)){
                count += map.get(currSum - req);
            }
            map.put(currSum, map.getOrDefault(currSum, 0l)+1);

        }
        sc.close();
        System.out.println(count);
    }
}
