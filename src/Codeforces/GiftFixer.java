package Codeforces;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GiftFixer {
	public static void main(String[] args) throws Exception {
		
//		String setIn = "5\n" + 
//				"3\n" + 
//				"3 5 6\n" + 
//				"3 2 3\n" + 
//				"5\n" + 
//				"1 2 3 4 5\n" + 
//				"5 4 3 2 1\n" + 
//				"3\n" + 
//				"1 1 1\n" + 
//				"2 2 2\n" + 
//				"6\n" + 
//				"1 1000000000 1000000000 1000000000 1000000000 1000000000\n" + 
//				"1 1 1 1 1 1\n" + 
//				"3\n" + 
//				"10 12 8\n" + 
//				"7 5 4\n" + 
//				"";
//		System.setIn(new ByteArrayInputStream(setIn.getBytes()));
		
		
		FastScanner fs = new FastScanner(System.in);
		int cases = fs.nextInt();
		
		for(int i = 0; i < cases; i++) {
			int size = fs.nextInt();
			long mino = Long.MAX_VALUE;
			long minc = Long.MAX_VALUE;
			long[] o = new long[size];
			long[] c = new long[size];
			
			for(int j = 0; j < size; j++) {
				c[j] = fs.nextInt();
				minc = Math.min(c[j], minc);
			}
			for(int j = 0; j < size; j++) {
				o[j] = fs.nextInt();
				mino = Math.min(o[j], mino);
			}
			System.out.println(solve(c, o, minc, mino));
		}
			
			
	
		
	}
	
	private static long solve(long[] c, long[] o, long mc, long mo) {
		long ans = 0;
		
		for(int i = 0; i < c.length; i++) {
			ans += Math.max(c[i]-mc, o[i]-mo);
		}
		
		return ans;
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
