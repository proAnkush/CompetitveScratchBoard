import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;;

public class UseLessIncreast2 {
    static int ec = 0;
    public static void main(String[] args) throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        Scanner sc = new Scanner(System.in);
        // permute("elephantit", "");
        // System.out.println(ec);
    //     String s = "loremipsumdolorsitametconsecteturadipiscingelitseddoeiusmodtemporincididuntutlaboreetdoloremagnaaliquautenimadminimveniamquisnostrudexercitationullamcolaborisnisiutaliquipexeacommodoconsequatduisauteiruredolorinreprehenderitinvoluptatevelitessecillumdoloreeufugiatnullapariaturexcepteursintoccaecatcupidatatnonproidentsuntinculpaquiofficiadeseruntmollitanimidestlaborum";
    //    System.out.println(first(s, s.length()).equals(sortedcheck(s, s.length())));
    //     System.out.println(first(s, s.length()));
        int T = sc.nextInt();
        while(T-- > 0){
            String s = sc.next();
            int n = s.length();
            System.out.println(third(s, n));
        }
    }
    public static char[] pre(String s){
        int n = s.length();
        char[] c = new char[n+1];
        c[n] = '{';
        c[n-1] = s.charAt(n-1);
        for(int i = n-2; i >= 0; i--){
            c[i] = s.charAt(i);
            if(c[i+1] < c[i]){
                c[i] = c[i+1];
            }
        }
        return c;
    }
    public static String third(String s, int n){
        char[] pre = pre(s);
        boolean sqisbig = true;
        StringBuilder pq = new StringBuilder();
        StringBuilder sq = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == pre[i] && sqisbig){ // inner
                pq.append(s.charAt(i));
                char temp = pre[i+1];
                if(sq.length() != 0 && temp > sq.charAt(0)){
                    sqisbig = false;
                }
                else if(sq.length() != 0 && temp == sq.charAt(0)){
                    String a = sq.toString() + temp;
                    String b = temp + sq.toString();
                    if(a.compareTo(b) < 0){
                        sqisbig = false;
                    }
                }
                else{
                    sq.append(s.charAt(i));
                }

            }
        }
        return pq.toString() + sq.toString();
    }
    static void permute(String s , String answer)
    {  
        if (s.length() == 0)
        {
            String firstAnswer = first(answer, answer.length()) ;
            String secondAnswer = sortedcheck(answer, answer.length());
            if(!(firstAnswer.equals(secondAnswer))){
                System.out.printf("Caller: %s, first: %s, second: %s \n", answer, firstAnswer, secondAnswer);
                ec++;
            }
            if(answer.compareTo(firstAnswer) < 0){
                System.out.println(answer);
            }
            // System.out.println(answer);
            return;
        }
        
        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }
    public static String first(String s, long n){
        char[] pre = pre(s);
        String preString = new String(pre);
        if(preString.equals(s)){
            return preString;
        } 

        StringBuilder sq = new StringBuilder();
        StringBuilder pq = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            if(String.valueOf(s.charAt(i)).compareTo(String.valueOf(pre[i])) <= 0){
                //  && (sq.length() == 0 || sq.charAt(0) >= s.charAt(i))
                if(sq.length() == 0){
                    pq.append(s.charAt(i));
                }else{
                    if(String.valueOf(sq.charAt(0)).compareTo(String.valueOf(s.charAt(i))) >= 0){
                        pq.append(s.charAt(i));
                    }else{

                        pq.append(min(sq.toString(), s.substring(i)));
                        pq.append(max(sq.toString(), s.substring(i)));
                        // System.out.println(pq.toString());
                        sq.setLength(0);
                        return pq.toString();
                    }
                }
            }else{
                sq.append(s.charAt(i));
            }
        }
        return (pq.toString() + sq.toString());
        
    }
    public static String sortedcheck(String s, int n){
        Stack<Character> stack = new Stack<>(); // residual stack
        StringBuilder greaters = new StringBuilder(); // store greater values between two current smaller values
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sq = new StringBuilder();
        String[] dp = new String[n];
        for(int i = n-1; i >= 0; i--){
            arr = s.substring(i).toCharArray();
            Arrays.sort(arr);
            dp[i] = new String(arr);
        }
        for(int i = 0 ; i < n; i++){
            // System.out.printf("%d: %s\n" , i, greaters.toString());
            if(s.charAt(i) == dp[i].charAt(0)){
                if(greaters.length() != 0 && greaters.charAt(0) < dp[i].charAt(0)){
                    greaters.append(s.charAt(i));
                }else{
                    sq.append(s.charAt(i));

                }
            }else{
                greaters.append(s.charAt(i));
            }
        }
        return sq.toString() + greaters.toString();
    }
    public static String min(String a, String b){
        if(a.compareTo(b) < 0) return a;
        else return b;
    }
    public static String max(String a, String b){
        if(a.equals(min(a, b))){
            return b;
        }else{
            return a;
        }
    }
}
