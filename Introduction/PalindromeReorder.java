import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int oddTotal = 0;
        char oddChar = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Character c : map.keySet()){
            if(map.get(c) % 2 == 1){
                oddTotal++;
                oddChar = c;
            }
        }
        if(oddTotal > 1 || (oddTotal == 1 && s.length()%2 == 0)){
            System.out.println("NO SOLUTION");
            return;
        }
        StringBuilder fh = new StringBuilder();
        StringBuilder lh = new StringBuilder();
        for(Entry<Character, Integer> e : map.entrySet()){
            StringBuilder ss = new StringBuilder();
            for(int i = 0 ; i < e.getValue()/2; i++){
                ss.append(e.getKey());
            }
            fh.append(ss);
            lh.insert(0, ss);
        }
        if(oddTotal == 1){
            fh.append(oddChar);
            fh.append(lh.toString());
            System.out.println(fh.toString());
        }else{
            fh.append(lh);
            System.out.println(fh.toString());
        }


    }
}
