import java.util.Scanner;

public class RedAndBlueBeans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println();
        while(t-- > 0){
            long r, b, d;
            r = sc.nextLong(); b = sc.nextLong(); d = sc.nextLong();
            if(d == 0){
                if(r == b){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                continue;
            }
            if((Math.max(r, b) / Math.min(r, b)) <= d){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
