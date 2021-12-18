import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 1;
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) ans = ans*2 % ((int)1e9 + 7);
        System.out.println(ans);
        sc.close();
    }
}
