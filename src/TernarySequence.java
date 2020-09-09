import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TernarySequence {
	static FastScanner fs;
	static int a0, a1, a2, b0, b1, b2;
	static int sum = 0;
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
		 a0 = fs.nextInt(); a1 = fs.nextInt(); a2 = fs.nextInt(); b0 = fs.nextInt(); b1 = fs.nextInt(); b2 = fs.nextInt();
		int good = Math.min(a2, b1);
		a2 -= good;
		b1 -= good;
		sum += good*2;
		greda(a2);
		greda(a0);
		
		int bad = Math.min(a1, b2);
		sum -= bad*2;
		
		System.out.println(sum);
		
		sum = 0;
		
	}
	
	private static void greda(int len) {
		int leftover = len;
		while(leftover > 0) {
			if(b2 > 0) {
				int subs = Math.min(b2, leftover);
				leftover -= subs;
				b2 -= subs;
			}
			else if(b0 > 0) {
				int subs = Math.min(b0, leftover);
				leftover -= subs;
				b0 -= subs;
			}
			else {
				leftover = 0;
				b1 = 0;
			}
		}
	}
	
//	private static void gredb(int len) {
//		int leftover = len;
//		while(leftover > 0) {
//			if(b1 > 0) {
//				
//			}
//			else if(b0 > 0) {
//				
//			}
//			else {
//				
//			}
//		}
//	}
	
	
	
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
