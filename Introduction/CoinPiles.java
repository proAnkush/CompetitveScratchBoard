import java.util.Scanner;

/**
 * CoinPiles
 */
public class CoinPiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

            long a = sc.nextLong();
            long b = sc.nextLong();
            if(a < b){
                long T = a; a = b; b =T;
            }
            if(a > 2*b){
                System.out.println("NO");
            }else{
                a %= 3; b %=3 ;
                if(a < b){ long T = a; a = b; b = T; }
                if((a == 2 && b==1) || (a==0 && b==0)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}