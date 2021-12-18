import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class BuildingRoads {
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
        // count connected components
        int ccCount = 0;
        ArrayList<Integer> secondary = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i, al, visited);
                ccCount++;
                secondary.add(i);
            }
        }
        System.out.println(ccCount-1);
        for(int i = 1 ; i < secondary.size(); i++){
            System.out.printf("%d %d\n", secondary.get(0), secondary.get(i));
        }


    }
    public static void dfs(int i , ArrayList<ArrayList<Integer>> al, boolean[] visited){
        visited[i] = true;
        for(int t : al.get(i)){
            if(!visited[t]){
                dfs(t, al, visited);
            }
        }
    }
}
