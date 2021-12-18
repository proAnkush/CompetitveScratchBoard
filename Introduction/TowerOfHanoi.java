
import java.util.Scanner;

/**
 * TowerOfHanoi
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println((int)Math.pow(2, n)-1);
        toh(n, 1, 2, 3);
    }
    public static void toh(int n, int a, int b, int c) {
        if(n == 1){
            System.out.println(a + " " + c);
            return;
        }
        toh(n-1, a, c, b);
        System.out.println(a + " " + c);
        toh(n-1, b, a, c);

    }

}
class Pair{
    int a, b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}