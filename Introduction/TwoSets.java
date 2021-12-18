
import java.util.Scanner;
import java.util.Stack;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(((n*(n+1))/2)%2== 0){
            System.out.println("YES");
            long a, b; a = b= 0;
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            while(n > 0){
                if(a <= b){
                    a+=n;
                    s1.add(n);
                }else{
                    b+=n;
                    s2.add(n);
                }
                n--;
            }
            System.out.println();
            System.out.println(s1.size());
            while(!s1.isEmpty()){
                System.out.print(s1.pop() + " ");
            }
            System.out.println();
            System.out.println(s2.size());
            while(!s2.isEmpty()){
                System.out.print(s2.pop() + " ");
            }
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
