import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.*;

public class triangles {

    static FastScanner scanner;
    static HashMap<Integer, List<Integer>> xy = new HashMap<Integer, List<Integer>>();
    static HashMap<Integer, List<Integer>> yx = new HashMap<Integer, List<Integer>>();
    static int[][] coords;
    static {
        try {
            scanner = new FastScanner(new FileInputStream("triangles.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));
        String toReturn = String.valueOf((2*solve())%(Math.pow(10,9)+7));
        pw.print(removeTrailingZeroes(toReturn));
        pw.close();
    }

    private static String removeTrailingZeroes(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }

        if(sb.charAt(sb.length()-1) == '.') {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

    public static double calculateArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return ((double) Math.abs(x2-x1) * Math.abs(y3-y1))/2;
    }

    public static double solve() {
        int n = scanner.nextInt();
        coords = new int[n][2];
        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(!xy.containsKey(x)) {
                xy.put(x, new ArrayList<Integer>());
            }
            if(!yx.containsKey(y)) {
                yx.put(y, new ArrayList<Integer>());
            }

            xy.get(x).add(y);
            yx.get(y).add(x);
            coords[i] = new int[]{x,y};
        }

        double sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < xy.get(coords[i][0]).size(); j++) {
                for(int k = 0; k < yx.get(coords[i][1]).size(); k++) {
                    if(xy.get(coords[i][0]).get(j) == coords[i][1] || yx.get(coords[i][1]).get(k) == coords[i][0]) continue;
                    sum += calculateArea(coords[i][0], coords[i][1],
                            yx.get(coords[i][1]).get(k), coords[i][1],
                            coords[i][0], xy.get(coords[i][0]).get(j));
                }
            }
        }

        return sum;

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
