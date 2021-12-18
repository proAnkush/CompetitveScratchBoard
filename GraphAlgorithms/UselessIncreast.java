import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * UselessIncreast
 */
public class UselessIncreast {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String s = br.readLine();
            int n = s.length();
            StringBuilder pq = new StringBuilder();
            StringBuilder sq = new StringBuilder();
            char[] sarr = s.toCharArray();
            Arrays.sort(sarr);
            StringBuilder pre = new StringBuilder(new String(sarr));
            if(pre.equals(s)){
                System.out.println(pre);
                continue;
            }
            int p2 = 0;
            int p1 = 0;
            while(p1 < n && p2 < pre.length()){
                boolean appended = false;
                for(int i = p2; i < pre.length(); i++){
                    if(s.charAt(p1) == pre.charAt(i)){
                        pq.append(pre.charAt(i));
                        pre.deleteCharAt(i);
                        appended = true;
                        break;
                    }
                }
                if(!appended){
                    sq.append(s.charAt(p1));
                }

                p1++;
            }
            System.out.println(pq.toString() + sq.toString());
        }

    }
    static char min(char a, char b){
        if(a <= b) return a;
        return b;
    }
    public static String min(String a, String b){
        if(a.compareTo(b) < 0){
            return a;
        }else return b;
    }
}