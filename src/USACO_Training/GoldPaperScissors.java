package USACO_Training;

import java.io.*;
import java.util.StringTokenizer;

public class GoldPaperScissors {

    static Integer[][][] dp;
    static FastScanner fastScanner;
    static int[][] wins;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        fastScanner = new FastScanner(new FileInputStream("hps.in"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("hps.out"), true);
        int answer = solve();
        pw.print(answer);
        pw.close();
    }

    static int solve() {
        int n = fastScanner.nextInt();
        int k = fastScanner.nextInt();
        dp = new Integer[n+1][k+1][3];
        wins = new int[n][3];
        arr = new int[n];
        //Initialize Win Variables
        for(int i = 0; i < n; i++) {
            int next = fastScanner.nextInt();
            int beatenBy = (next+1)%3;
            arr[i] = beatenBy;
            for(int j = 0; j < 3; j++) {
                wins[i][j] = (i > 0 ? wins[i-1][j] : 0) + (j == beatenBy ? 1 : 0);
            }
        }

        return Math.max(Math.max(getDp(n,k,0), getDp(n,k,1)), getDp(n,k,2));
    }

    static int getDp(int i, int j, int l) {
        if(dp[i][j][l] != null) return dp[i][j][l];
        else if(i == 0) return 0;
        else if(j == 0) {
            return wins[i-1][l];
        }

        //Either continue by doing dp[i-1][j][l] or make a transition with dp[i-1][j-1][?] + (arr[i] == ?)
        int add = (arr[i-1] == l) ? 1 : 0;
        int continued = getDp(i-1, j, l)+add;
        for(int r = 0; r < 3; r++) {
            continued = Math.max(continued, getDp(i-1,j-1,r)+add);
        }

        dp[i][j][l] = continued;

        return continued;
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
            String next = next();
            switch(next) {
                case "H":
                    return 0;
                case "P":
                    return 1;
                case "S":
                    return 2;
            }
            return Integer.parseInt(next);
        }
    }
}
