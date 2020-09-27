import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MortalKombatTower {
    static FastScanner fs;
    public static void main(String[] args) {
//		try {
//			System.setIn(new FileInputStream("testinput.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        fs = new FastScanner(System.in);
        int cases = fs.nextInt();
        for(int i = 0; i < cases; i++) {
            solve();
        }
    }

    private static void solve() {
        int size = fs.nextInt();
        int[] a = new int[size];
        for(int i = 0; i < size; i++) {
            a[i] = fs.nextInt();
        }
        int points = 0;
        for(int i = 0; i < a.length; i += 2) {
            int one = a[i];
            int two = (i+1 < a.length) ? a[i+1] : -1;
            if(one == 1) points++;
            i++;
            if (two == 0) i++;
        }
        System.out.println(points);
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
