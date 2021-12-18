import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int maxPrev = 1;
        int max = 1;
        char prev = s.charAt(0);
        for(int i = 1 ; i < n; i++){
            char c = s.charAt(i);
            if(prev == c){
                max += 1;
            }else{
                prev = c;
                max = 0;
                max++;
            }
            maxPrev = Math.max(max, maxPrev);
        }
        System.out.println(Math.max(max, maxPrev));
    }
}
