
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * CountingRooms
 */
public class CountingRooms {

    public static void main(String[] args) {
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
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if((!visited[i][j]) && g[i][j] == '.'){
                    bfs(g, visited, i, j);
                    count++;
                }
                visited[i][j] = true;
            }
        }
        System.out.println(count);
    }
    public static void bfs(char[][] g, boolean[][] visited, int i, int j){
        if(i < 0 | i >= g.length | j < 0 | j >= g[0].length) return;
        if(g[i][j] == '#') return;
        // visited[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            visited[p.a][p.b] = true;
            if(p.a-1 >= 0 && !visited[p.a-1][p.b] && g[p.a-1][p.b] =='.'){
                q.add(new Pair(p.a-1, p.b));
                visited[p.a-1][p.b] = true;
            }
            if(p.b-1 >= 0 && !visited[p.a][p.b-1] && g[p.a][p.b-1] =='.'){
                q.add(new Pair(p.a, p.b-1));
                visited[p.a][p.b-1] = true;

            }
            if(p.a+1 < g.length && !visited[p.a+1][p.b] && g[p.a+1][p.b] =='.'){
                q.add(new Pair(p.a+1, p.b));
                visited[p.a+1][p.b] = true;

            }
            if(p.b+1 < g[0].length && !visited[p.a][p.b+1] && g[p.a][p.b+1] =='.'){
                q.add(new Pair(p.a, p.b+1));
                visited[p.a][p.b+1] = true;

            }
            

        }


    }

}