import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BoatsCompetition {
	
	
	private static FastScanner fs = new FastScanner(System.in);
	
	
	private static Integer[][] dp;
	private static Integer[][] sums;
	private static int[] a;
	
	public static void main(String[] args) {
		int cases = fs.nextInt();
		for(int i = 0; i < cases; i++) {
			solve();
		}
	}
	
	private static void solve() {
		int n = fs.nextInt();
		a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		Arrays.sort(a);
		dp = new Integer[n][n];
		sums = new Integer[n][n];
		System.out.println(getDp(0, n-1));
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print((dp[i][j] == null) ? "n" : dp[i][j]);
//			}
//			System.out.println();
//		}
		
	}
	
	private static int getDp(int lb, int rb) {
		if(dp[lb][rb] != null) {
			return dp[lb][rb];
		}
		if(rb-lb <= 1) {
			dp[lb][rb] = rb-lb;
			sums[lb][rb] = (rb-lb == 1) ? a[lb]+a[rb] : 0;
			return rb-lb;
		}
		int one = getDp(lb+1, rb), two = getDp(lb, rb-1), three = getDp(lb+1, rb-1);
		
		if(sums[lb+1][rb-1] == a[lb]+a[rb]) {
			three++;
		}
		
		
		
		int ans =  max(one, two, three);
		if(ans == three) {
			sums[lb][rb] = sums[lb+1][rb-1];
		}
		 else if(ans == one) {
			sums[lb][rb] = sums[lb+1][rb];
		}
		else if(ans == two) {
			sums[lb][rb] = sums[lb][rb-1];
		}
		
		dp[lb][rb] = ans;
		return ans;
	}
	
	private static int max(int o, int t, int th) {
		return Math.max(o, Math.max(t, th));
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
                	String line = br.readLine();
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                catch(NullPointerException e) {
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
