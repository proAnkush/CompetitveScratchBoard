import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] vals = new long[n];
        for(int i = 0 ; i < n; i++){
            vals[i] = sc.nextLong();
        }
        Stack<NearPair> stack = new Stack<>();
        stack.push(new NearPair(vals[0], 0));
        System.out.print("0 ");
        for(int i = 1 ; i < n; i++){
            while(!stack.isEmpty() && stack.peek().val >= vals[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }else{
                if(stack.peek().val < vals[i]){
                    System.out.printf("%d ", stack.peek().index+1);
                }else{
                    System.out.print("0 ");
                }
            }
            stack.push(new NearPair(vals[i], i));

        }
    }
}

class NearPair{
    long val;
    int index;
    NearPair(long l, int i){
        this.val = l;
        this.index = i;
    }
}