import java.util.Scanner;

/**
 * Premutations
 */
public class Premutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int eN = (n %2 == 0) ? n : n-1;
        if(n == 1){
            System.out.print(1);
            return;
        }
        else if(n <= 3){
            System.out.print("NO SOLUTION");
            return;
        }else if(n==4){
            System.out.print("2 4 1 3");
            return;
        }
        while(eN >= 1){
            System.out.print(eN + " ");
            eN -= 2;
        }
        eN = (n % 2 == 1) ? n : n-1;
        while(eN >= 1){
            System.out.print(eN + " ");
            eN -= 2;
        }
        
    }
}