import java.util.Scanner;

public class ReadingBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for(int i = 0 ; i < n; i++){
            sum += sc.nextLong();
        }
        sc.close();
        System.out.println(sum + n);
        // The question has worst description


    }
}
