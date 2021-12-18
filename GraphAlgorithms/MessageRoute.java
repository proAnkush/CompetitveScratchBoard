import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class MessageRoute {
    public static int minVertex;
    public static String s = "";
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        // Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.get(x).add(y);
            al.get(y).add(x);
        }
        // bfs from 1 to n
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Queue<Integer> q = new LinkedList<>(); q.add(1);
        boolean[] visited = new boolean[n+1]; visited[0] = true;
        while(!q.isEmpty()){
            int t = q.remove();
            for(int x : al.get(t)){
                if(!visited[x]){
                    dist[x] = dist[t] + 1;
                    visited[x] = true;
                    parent[x] = t;
                    q.add(x);
                }
            }
        }   
        if(!visited[n]){
            System.out.println("IMPOSSIBLE");
            return;
        }
        int u = n;
        int b = dist[n];
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = b; i >= 0; i--){
            ans.add(u);
            u = parent[u];
        }
        System.out.println(ans.size());
        for(int i = ans.size()-1; i >= 0; i--){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}