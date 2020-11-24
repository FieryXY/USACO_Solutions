package USACO_Training;

import java.io.*;
import java.util.*;

public class CowEvolution {

    static FastScanner scanner;
    static String[][] attr;
    static List<String> all_attr = new ArrayList<String>();
    static {
        try {
            scanner = new FastScanner(new FileInputStream("evolution.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("evolution.out"));
        pw.print(solve() ? "yes" : "no");
        pw.close();
    }


    private static boolean crossing(String a, String b) {
        boolean hasA = false, hasB = false, hasAB = false;
        for(int i = 0; i < attr.length; i++) {
            boolean localA = false, localB = false;
            for(int j = 0; j < attr[i].length; j++) {
                if(attr[i][j].equals(a)) {
                    localA = true;
                }
                else if(attr[i][j].equals(b)) {
                    localB = true;
                }
            }
            if(localA && localB) hasAB = true;
            else if(localA) hasA = true;
            else if(localB) hasB = true;
        }

        return hasA&hasB&hasAB;
    }


    public static boolean solve() {
        attr = new String[scanner.nextInt()][];
        for(int i = 0; i < attr.length; i++) {
            attr[i] = new String[scanner.nextInt()];
            for(int j = 0; j < attr[i].length; j++) {
                attr[i][j] = scanner.next();

                if (!all_attr.contains(attr[i][j])) {
                    all_attr.add(attr[i][j]);
                }
            }
        }

        for(int i = 0; i < all_attr.size(); i++) {
            for(int j = 0; j < all_attr.size(); j++) {
                if(i == j) continue;
                if(crossing(all_attr.get(i), all_attr.get(j))) {
                    return false;
                }
            }
        }

        return true;
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

    static class Attribute {
        Attribute parent;
        List<Attribute> children;
        List<String> attributes;
        Attribute() {
            children = new ArrayList<Attribute>();
            attributes = new ArrayList<String>();
        }
    }
}


