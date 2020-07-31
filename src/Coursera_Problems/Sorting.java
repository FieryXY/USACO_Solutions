package Coursera_Problems;
import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();
    static int[] a;
    
    


    private static int[] partition3(int l , int r) {
 		int i = l, j = l, k = l, p = a[r-1];
 		while(i < r) {
 			if(a[i] > p) {
 				i++;
 				continue;
 			}
 			else {
 				swap(i,k);
 				if(a[k] == p) {
 					k++;
 				}
 				else {
 					swap(j,k);
 					j++;
 					k++;
 				}
 				i++;
 			}
 		}
 		

 		
 		return new int[] {j,k};
 	 }


    public static void main(String[] args) {
//    	String toPutIn = "10\n1 1 1 1 1 1 1 1 1 1";
//    	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
         a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        quickSort(0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        
    }
    
    private static void swap(int i1, int i2) {
    	int holder = a[i1];
    	a[i1] = a[i2];
    	a[i2] = holder;
    }
    
    private static void quickSort(int l, int r) {
    	int index;
    	
    	while(l < r) {
    		index = new Random().nextInt(r-l)+l;
        	swap(r-1, index);
    		int[] someIndex = partition3(l,r);
    		
    		if((someIndex[0]-l) > (r-someIndex[1])) {
    			quickSort(l,someIndex[0]);
    			
    			l = someIndex[1];
    		}
    		else {
    			quickSort(someIndex[1],r);
    			
    			r = someIndex[0];
    		}
    	}
    	
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
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

