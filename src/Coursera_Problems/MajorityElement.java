package Coursera_Problems;
import java.util.*;
import java.io.*;

public class MajorityElement {
	
	
	private static int[] a;
	
    private static int getMajorityElement() {
        int returnVal = quickSort(0, a.length);
        return returnVal;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
         a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement() > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    	
    }
    
    
    
    
    //MINING AWAY EATING ALL THE HAY EATING ALL THE CHOCOLATE
    
    private static int quickSort(int l, int r) {
    	int index;
    	
    	while(l < r) {
    		index = new Random().nextInt(r-l)+l;
        	swap(r-1, index);
    		int[] someIndex = partition3(l,r);
    		if(someIndex[0] < 0) {
    			return 1;
    		}
    		if((someIndex[0]-l) > (r-someIndex[1])) {
    			int result = quickSort(l,someIndex[0]);
    			if(result == 1) {
    				return 1;
    			}
    			l = someIndex[1];
    		}
    		else {
    			int result = quickSort(someIndex[1],r);
    			if(result == 1) {
    				return 1;
    			}
    			r = someIndex[0];
    		}
    	}
    	
    	return 0;
    	
    }
    
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
		
		if(k-j > (a.length/2)) {
			return new int[] {-1,-1};
		}
		
		return new int[] {j,k};
	 }
    
    private static void swap(int i1, int i2) {
    	int holder = a[i1];
    	a[i1] = a[i2];
    	a[i2] = holder;
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

