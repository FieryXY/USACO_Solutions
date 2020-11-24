import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    private static boolean[] explored;
    private static ArrayList<Integer>[] adj;

    private static int acyclic() {
        //write your code here
        for(int i = 0; i < explored.length; i++) {
            if(explored[i]) continue;
            if(explore(i, new ArrayList<Integer>())) return 1;
        }

        return 0;
    }

    private static boolean explore(int ind, ArrayList<Integer> arr) {
        if(arr.contains(ind)) return true;
        explored[ind] = true;
        arr.add(ind);
        for(int i = 0; i < adj[ind].size(); i++) {
            if(explore(adj[ind].get(i),arr)) return true;
        }
        arr.remove(arr.size()-1);

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        explored = new boolean[n];
         adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic());
    }
}

