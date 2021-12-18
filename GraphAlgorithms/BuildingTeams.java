import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
public class BuildingTeams {
    static boolean possible = true;
    static boolean[] team;
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
        possible = true;
        team = new boolean[n+1];
        if(n == 2 && m == 0){
            System.out.println("1 1");
        }
        if(n == 2 && m == 1){
            System.out.println("1 2");
            return;
        }
        boolean[] visited = new boolean[n+1];
        if(n*(n-1)/2 == m){
            System.out.println(n*(n-1)/2);
            System.out.println("IMPOSSIBLE1");
            return;
        }else{
            team = new boolean[n+1];
            for(int i = 1; i <= n; i++){
                if(!visited[i] && possible){
                    bfs(i, al, visited);
                }
            }
        }
        if(possible){
            System.out.println(Arrays.toString(visited));
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
    public static void bfs(int i, ArrayList<ArrayList<Integer>> al, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int u = q.remove();
            if(!visited[u]){
                for(int v : al.get(u)){
                    if(visited[v] && team[i] == team[u]){
                        possible = false;
                        return;
                    }
                    if(!visited[v]){
                        q.add(v);
                    }
                    
                    team[v] = !team[u];
                }
                
            }
        }
    }
}
