package Coursera_Problems;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
//    	String toPutIn = "10\n10 9 8 7 6 5 4 3 2 1";
//    	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
       
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index2 + " " + swap.index1);
        }
    }

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      for(int i = data.length-1; i >= 0; i--) {
    	  SiftDown(i);
      }
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
    }
    
    private void SiftDown(int n) {
    	if(2*n+2 < data.length) {
    		int one = data[2*n+1];
    		int two = data[2*n+2];
    		if(one < data[n] || two < data[n]) {
    			swaps.add(new Swap((one < two) ? 2*n+1 : 2*n+2, n));
    			swap(swaps.get(swaps.size()-1).index1,swaps.get(swaps.size()-1).index2);
    			SiftDown(swaps.get(swaps.size()-1).index1);
    		}
    	}
    	else if(2*n+1 < data.length) {
    		int one = data[2*n+1];
    		if(one < data[n]) {
    			swaps.add(new Swap(2*n+1, n));
    			swap(2*n+1, n);
    			SiftDown(swaps.get(swaps.size()-1).index1);
    		}
    	}
    	
    }
    
    
    private void swap(int i, int j) {
    	int k = data[i];
    	data[i] = data[j];
    	data[j] = k;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
        
        public String toString() {
        	return index2 + ":" + index1;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
