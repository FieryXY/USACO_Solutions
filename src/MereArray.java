import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MereArray {
	static FastScanner fs;
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("testinput.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 fs = new FastScanner(System.in);
		int cases = fs.nextInt();
		for(int i = 0; i < cases; i++) {
			solve();
		}
	}
	
	private static void solve() {
		int n = fs.nextInt();
		int[] a = new int[n];
		int[] sorted = new int[n];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) { 
			a[i] = fs.nextInt();
			sorted[i] = a[i];
			min = Math.min(min,  a[i]);
		}
		Arrays.sort(sorted);
		
		
		boolean no = false;
		
		for(int i = 0; i < n; i++) {
			if(a[i] != sorted[i] && a[i]%min != 0) {
				System.out.println("NO");
				no = true;
				break;
			}
		}
		
		if(!no) {
			System.out.println("YES");
		}		
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
