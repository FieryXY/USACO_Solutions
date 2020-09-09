import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DistanceAndAxis {
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
		int n = fs.nextInt();
		int k = fs.nextInt();
		if(n < k) {
			System.out.println(k-n);
			return;
		}
		
		double currentB = (((double) n)/2) - (((double) k)/2);
		if(currentB == (int) currentB) {
			System.out.println("0");
			return;
		}
		double floor = Math.floor(currentB);
		double ceil = Math.ceil(currentB);
		
		double ans = Math.min(n-(2*floor+k), (2*ceil+k)-n);
		
		System.out.println((int) ans);
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
