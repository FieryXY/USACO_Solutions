import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Mama Pants
//^ I'm Byaa
//^ I'm Man

public class BlackWhiteTree {
    static FastScanner fs;

    static Vertex[] vertices;
    static int end1, end2;

    static int[] dist1;
    static int[] dist2;

    static int maxtoi;

    public static void main(String[] args) {
//		try {
//			System.setIn(new FileInputStream("testinput.txt"));
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
        fs = new FastScanner(System.in);
        int cases = fs.nextInt();
        for(int i = 0; i < cases; i++) {
            solve();
        }
    }

    //Update adjacency list with new edge
    private static void addEdge(int j, int k) {

        if(vertices[j] == null) vertices[j] = new Vertex();
        if(vertices[k] == null) vertices[k] = new Vertex();

        vertices[j].adj.add(k);
        vertices[k].adj.add(j);
    }

    private static void bfs1(int p, int u) {
        if(p < 0) {
            dist2[u] = 0;
        }
        else {
            dist2[u] = dist2[p]+1;
        }

        if(dist2[u] > maxtoi && !vertices[u].isBlack) {
            maxtoi = dist2[u];
            end1 = u;
        }
        else if(dist2[u] == maxtoi && !vertices[u].isBlack) {
            if(u > end1) {
                end1 = u;
            }
        }

        for(int c : vertices[u].adj) {
            if(c == p) continue;

            bfs1(u, c);
        }
    }

    private static void bfs2(int p, int u) {
        if(p < 0) {
            dist1[u] = 0;
        }
        else {
            dist1[u] = dist1[p]+1;
        }

        if(dist1[u] > maxtoi && !vertices[u].isBlack) {
            maxtoi = dist1[u];
            end2 = u;
        }
        else if(dist1[u] == maxtoi && !vertices[u].isBlack) {
            if(u > end2) {
                end2 = u;
            }
        }

        for(int c : vertices[u].adj) {
            if(c == p) continue;

            bfs2(u, c);
        }
    }

    private static void solve() {
        int n = fs.nextInt(), m = fs.nextInt();
        vertices = new Vertex[n];
        vertices[0] = new Vertex();

        dist1 = new int[n];
        dist2 = new int[n];

        for(int i = 1; i < vertices.length; i++) {
            if(vertices[i] == null) {
                vertices[i] = new Vertex();
            }
            int parent = fs.nextInt() - 1;
            addEdge(i, parent);
        }

        maxtoi = -1;
        bfs1(-1, 0);

        maxtoi = -1;
        bfs2(-1, end1);

        maxtoi = -1;
        bfs1(-1, end2);

        for(int j = 0; j < m; j++) {
            int current = fs.nextInt()-1;
            int farthest;




            boolean painted = false;
            if(vertices[current].isBlack) {
                painted = true;
                vertices[current].isBlack = false;


                if(dist1[current] > dist1[end2]) {
                    updateBfs();
                }

                else if(dist2[current] > dist2[end1]) {
                    updateBfs();
                }
            }

            if(dist1[current] > dist2[current]) {
                farthest = end1;
            }
            else if(dist1[current] < dist2[current]) {
                farthest = end2;
            }
            else {
                farthest = Math.max(end1, end2);
            }


            if(!painted) {
                vertices[current].isBlack = true;

                if(current == end1) {
                    updateBfs();
                }
                else if(current == end2) {
                    updateBfs();
                }
            }

            System.out.println(farthest+1);
        }



    }

    private static void updateBfs() {
        maxtoi = -1;
        bfs1(-1, end2);
        maxtoi = -1;
        bfs2(-1, end1);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

class Vertex {
    ArrayList<Integer> adj = new ArrayList<Integer>();
    boolean isBlack = false;
}
