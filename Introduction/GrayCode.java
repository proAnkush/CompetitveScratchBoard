import java.util.ArrayList;
import java.util.Scanner;

/**
 * GrayCode
 */
public class GrayCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        ArrayList<String> al = new ArrayList<>();
        al.add("0");
        al.add("1");
        for(int i = 2; i < (1 << n); i=i<<1){
            int j;
            for(j = i-1; j >= 0; j--){
                al.add(al.get(j));
            }
            for(j = 0; j < i; j++){
                al.set(j, "0" + al.get(j));
            }
            for(j = i; j < 2*i; j++){
                al.set(j, "1" + al.get(j));
            }
        }
        for(String s : al){
            System.out.println(s);
        }

    }
}