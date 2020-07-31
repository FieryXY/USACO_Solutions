     package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;

public class LCS2 {

	
	
	private static int[] a;
	private static int[] b;
	
	private static Integer[][] dynamicMatrix;

	
    private static int lcs2(int x, int y) {
        //Write your code here
    	
    	if(dynamicMatrix[x][y] != null) {
    		return dynamicMatrix[x][y];
    	}
    	else if(x == 0 || y == 0) {
    		dynamicMatrix[x][y] = 0;
    		return 0;
    	}
    
    	
    	int left, top;
    	
    	left = lcs2(x-1,y);
    	top = lcs2(x,y-1);
    	
    	
    	
    	
    	
    	int answer = Math.max(left, top);
    	
    	
    	
    	
    	
    	
    	if(a[x-1] == b[y-1] && lcs2(x-1,y-1) == answer) {
    		answer++;

    	}
    	
    	dynamicMatrix[x][y] = answer;
    	
    	
        return answer;
    }
    
//    private static int lcs2Naive(int[] a, int[] b) {
//    	
//    	
//    	
//    	
//    	return -1;
//    }

    public static void main(String[] args) {
//	  	String toPutIn = "5\n2 3 1 2 3\n3\n1 2 3";
//	  	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        
        dynamicMatrix = new Integer[n+1][m+1];
      
        
        
        System.out.println(lcs2(n, m));
        
    	
    	
    	
        
        
    }
}

