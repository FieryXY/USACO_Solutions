import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Someone pls help. It is literally the same concept as the solution by chance
//(Local Maxima and Local Minima in Maxima-Minima pairs beside the last Maxima)

public class PokemonArmy {
    static FastScanner fs;
    static int last = Integer.MIN_VALUE;
    static int index = 0;
    static int[] a;


    public static void main(String[] args) {
        fs = new FastScanner(System.in);
        int cases = fs.nextInt();
        for(int i = 0; i < cases; i++) {
            solve();
        }
    }

    private static void readValues() {
        int n = fs.nextInt();
        int q = fs.nextInt();
        a = new int[n];
        for(int i = 0; i < a.length; i++) {
            a[i] = fs.nextInt();
        }
    }

    private static void testSolve() {
        while(true) {
            Random r = new Random();
            int length = r.nextInt(15)+1;
            List<Integer> list = IntStream.range(1, length+1).boxed().collect(Collectors.toList());
            Collections.shuffle(list);
            a = list.stream().mapToInt(i -> i).toArray();
            int bruteAnswer = bruteForce();
            int elegantAnswer = solve();
            System.out.println(Arrays.toString(a));
            if(bruteAnswer != elegantAnswer) {
                System.out.println("Incorrect Answer Found");
                break;
            }
        }
    }

    private static int bruteForce() {
        int combinations = (int) Math.pow(2, a.length);
        int currentComb  = 0;
        int greatestSum = -1;
        for(int i = 0; i < combinations; i++) {
          int thisSum = 0;
          boolean plus = true;
          for(int j = 0; j < a.length; j++) {
              int nextNumber = ((currentComb & (int) Math.pow(2, j)) > 0) ? a[j] : 0;
              if(nextNumber == 0) continue;
              if(plus) {
                  thisSum += nextNumber;
              }
              else {
                  thisSum -= nextNumber;
              }
              plus = !plus;
          }
          if(thisSum > greatestSum) greatestSum = thisSum;
          currentComb++;
        }

        System.out.println(greatestSum);
        return greatestSum;
    }

    private static int solve() {
        last = Integer.MIN_VALUE;
        index = 0;
       //readValues();


        //Strat: Find Crests and Troughs
        int sum = 0;
        int lastMin = -1;

        while(true) {
            int max = getMax();
            if(max == -1) {
                sum += lastMin;
                break;
            }
            sum += max;
            int min = getMin();
            if(min == -1) {
                break;
            }
            sum -= min;
            lastMin = min;
        }

        System.out.println(sum);
        return sum;

    }

    private static int getMax() {
        return getVal(Comparator.naturalOrder());
    }
    private static int getMin() {
        return getVal(Comparator.reverseOrder());
    }

    private static int getVal(Comparator<Integer> comp) {
        int toReturn = -1;

        if(index >= a.length) {
            return -1;
        }

        while(index < a.length) {
            int next = a[index];
            if(comp.compare(next, last) > 0) {
                last = next;
                index++;
                toReturn = next;
            }
            else {
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
