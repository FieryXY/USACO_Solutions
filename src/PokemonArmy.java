import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PokemonArmy {
    static FastScanner fs;
    static int last = Integer.MIN_VALUE;
    static int index = 1;
    static int n;
    public static void main(String[] args) {
        fs = new FastScanner(System.in);
        int cases = fs.nextInt();
        for(int i = 0; i < cases; i++) {
            solve();
        }
    }

    private static void solve() {
        last = Integer.MIN_VALUE;
        index = 1;

         n = fs.nextInt();
        //Strat: Find Crests and Troughs
        int sum = 0;
        int lastMin = -1;
        while(true) {
            int max = getMax();
            if(max == -1) {
                sum += lastMin;
                break;
            }
            int min = getMin();
            sum += max;
            if(min == -1) {
                break;
            }
            sum -= min;
            lastMin = min;
        }

        System.out.println(sum);
    }

    private static int getMax() {
        return getVal(Comparator.naturalOrder());
    }
    private static int getMin() {
        return getVal(Comparator.reverseOrder());
    }

    private static int getVal(Comparator<Integer> comp) {
        int toReturn = last;

        if(index > n) {
            return -1;
        }

        while(index <= n) {
            int next = fs.nextInt();
            if(comp.compare(next, last) > 0) {
                last = next;
                index++;
                toReturn = next;
            }
            else {
                last = next;
                index++;
                break;
            }
        }

        return toReturn;
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
