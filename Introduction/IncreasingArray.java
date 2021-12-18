import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long count = 0;
        long bneck = sc.nextLong();
        for(int i = 0 ; i <n-1; i++){
            long curr = sc.nextLong();
            if(curr >= bneck){
                bneck = curr;
            }else{
                count += (bneck-curr);
            }

        }
        System.out.println(count);

    }
}
