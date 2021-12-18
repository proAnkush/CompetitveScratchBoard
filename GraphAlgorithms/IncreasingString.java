import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IncreasingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- >0){
            String s = sc.next();
            int n = s.length();
            
            // System.out.println(another( s,  n));
            System.out.println(sortedcheck(s, n));
        }
    }
    public static String another(String s, int n){
        Stack<Character> stack = new Stack<>(); // residual stack
        StringBuilder greaters = new StringBuilder(); // store greater values between two current smaller values
        StringBuilder leftSq = new StringBuilder(); // store values removed from greaters
        StringBuilder reverse = new StringBuilder(); // use for reversing the stack
        StringBuilder sq = new StringBuilder();
        

        for(int i = 0 ; i < n; i++){
            while (!stack.isEmpty() && stack.peek() > s.charAt(i)) {
                greaters.append(stack.pop());
            }
            stack.push(s.charAt(i));
            // System.out.println(i + greaters.toString());
            // leftSq.append(greaters.reverse().toString());
            // greaters.setLength(0);
        }
        // System.out.println("Leftsq: " + leftSq.toString());
        
        while (!stack.isEmpty() && leftSq.length() >= 1 && stack.peek() > leftSq.charAt(0)) {
            greaters.append(stack.pop());
        }
        // System.out.println("greaters: " + greaters.toString());

        leftSq.append(greaters.reverse().toString());
        while(!stack.isEmpty()){
            reverse.append(stack.pop());
        }
        sq.append(reverse.reverse().toString());
        sq.append(leftSq.toString());


        return sq.toString();

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
}
