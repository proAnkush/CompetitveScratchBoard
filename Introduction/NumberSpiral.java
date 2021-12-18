import java.util.Scanner;

public class NumberSpiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            long x = sc.nextLong(); long y = sc.nextLong();
            if(x < y){
                if(y % 2 ==1){
                    long r = y*y;
                    System.out.println(r-x+1);
                }else{
                    long r = ((y-1)*(y-1)) +1;
                    System.out.println(r+x-1);
                }
            }else{
                if(x % 2 == 0){
                    long r = x*x;
                    System.out.println(r-y+1);
                }
                else{
                    long r = ((x-1) * (x-1)) + 1;
                    System.out.println(r+y-1);
                }
            }
        }
        sc.close();

    }
}
