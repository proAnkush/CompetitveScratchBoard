
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;


public class Labyrinth {
    public static boolean ans = false;
    public static String out = "";
    public static int len = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // can i spell lebirynth, maybe
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] g = new char[n][m];
        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                g[i][j] = s.charAt(j);
                // g[i][j] = '.';
            }
        }
        sc.close();
        char[][] visited = new char[n][m+1];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(g[i][j] == 'A'){
                    visited[i][j] = 'A';
                    StringBuilder sb = new StringBuilder();
                    bfs(g, visited, i, j);
                }
                if(ans) break;
            }
            if(ans) break;
        }
        if(ans){
            System.out.println("YES");
            System.out.println(len);
            System.out.println(out);
        }else{
            System.out.println("NO");
        }

    }
    public static void bfs(char[][] g, char[][] visited, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int count = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            // System.out.printf("X: %d, Y: %d\n", p.a, p.b);
            if(g[p.a][p.b] == 'B'){
                out = backtrack(visited, p.a, p.b);
                ans = true;
                len = out.length();
                return;
            }
            if(p.a-1 >= 0 && g[p.a-1][p.b] != '#' && visited[p.a-1][p.b] == 0){
                visited[p.a-1][p.b] = 'U';
                q.add(new Pair(p.a-1, p.b));
            }
            if(p.b-1 >= 0 && g[p.a][p.b-1] != '#' && visited[p.a][p.b-1] == 0){
                visited[p.a][p.b-1] = 'L';
                q.add(new Pair(p.a, p.b-1));
            }
            if(p.a+1 < g.length && g[p.a+1][p.b] != '#' && visited[p.a+1][p.b] == 0){
                visited[p.a+1][p.b] = 'D';
                q.add(new Pair(p.a+1, p.b));
            }
            if(p.b+1 < g[0].length && g[p.a][p.b+1] != '#' && visited[p.a][p.b+1] == 0){
                visited[p.a][p.b+1] = 'R';
                q.add(new Pair(p.a, p.b+1));
            }
        }
    }
    public static String backtrack(char[][] visited, int i, int j){
        StringBuilder sb = new StringBuilder();
        
        while(visited[i][j] != 'A'){
            sb.append(visited[i][j]);
            if(visited[i][j] == 'U'){
                i++;
            }else if(visited[i][j] == 'L'){
                j++;
            }else if(visited[i][j] == 'D'){
                i--;
            }else{
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
class Pair{
    int a, b;
    Pair(int x, int y){
        a = x;
        b = y;
    }
}