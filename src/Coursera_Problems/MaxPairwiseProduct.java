package Coursera_Problems;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
//    static int getMaxPairwiseProduct(int[] numbers) {
//        int max_product = 0;
//        int n = numbers.length;
//
//        for (int first = 0; first < n; ++first) {
//            for (int second = first + 1; second < n; ++second) {
//                max_product = Math.max(max_product,
//                    numbers[first] * numbers[second]);
//            }
//        }
//
//        return max_product;
//    }
    
    static long getMaxPairwiseProductFast(int[] numbers) {
    	
    	long maxValue = 0;
    	int trueI = 0;
    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i] > maxValue) {
    			maxValue = numbers[i];
    			trueI = i;
    		}
    	}
    	
    	long maxValue2 = 0;
    	for(int i = 0; i < numbers.length; i++) {
    		if(i == trueI) continue;
    		if(numbers[i] > maxValue2) {maxValue2 = numbers[i];}
    	}
    	
    	return maxValue*maxValue2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
