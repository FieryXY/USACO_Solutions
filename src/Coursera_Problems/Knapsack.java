package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;

public class Knapsack {
	
	
	static Integer[][] M;
	static int[] weights;
	
    static int optimalWeight(int W, int[] w) {
        //write you code here
        return getM(W, w.length);
    }
    
    
    static int getM(int maxWeight, int itemsToUse) {
    	
    	
    	if(M[maxWeight][itemsToUse] != null) {
    		return M[maxWeight][itemsToUse];
    	}
    	else if(maxWeight == 0 || itemsToUse == 0) {
    		M[maxWeight][itemsToUse] = 0;
    		return 0;
    	}
    	
    	int a = getM(maxWeight, itemsToUse-1);
    	int b;
    	
    	if(maxWeight - weights[itemsToUse-1] >= 0) {
    		b = getM(maxWeight - weights[itemsToUse-1], itemsToUse-1)+weights[itemsToUse-1];
    	}
    	else {
    		b = -1;
    	}
    	
    	int answer = Math.max(a, b);
    	
    	M[maxWeight][itemsToUse] = answer;
    	
    	
    	return answer;
    }

    public static void main(String[] args) {
//   	String toPutIn = "10 5\n3 5 3 3 5";
//	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int W, n;          
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        M = new Integer[W+1][n+1];
        Knapsack.weights = w;
        System.out.println(optimalWeight(W, w));
      
    }
}

