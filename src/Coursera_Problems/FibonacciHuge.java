package Coursera_Problems;
import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n%m;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous+previous)%m;
        }

        
        return current;
        
        
        //return 0_0;
    }
    
    private static long getFibonacciHuge(long n, long m) {
    	
    	long period = findPisanoPeriod(m);
    	
    	long newN = n%period;
    	
    	return getFibonacciHugeNaive(newN, m);
    }
    
    private static long findPisanoPeriod(long m) {
    	// long[] fibList = new long[5];
 	    //fibList[0] = 1;
 	    //fibList[1] = 1;
 	    
    	long previousValue2 = 0;
 	    long previousValue = 1;
 	    
 	    
 	    for(int i = 2; i <= m*m; i++) {
 	    	//fibList[i] = fibList[i-1]+fibList[i-2];
 	    	long newValue = (previousValue+previousValue2)%m;
 	    	previousValue2 = previousValue;
 	    	previousValue = newValue;
 	    	
 	    	
 	    	if(previousValue2%m == 0 && previousValue%m == 1) {
 	    		//if((previousValue2+previousValue)%m == 1) {
 	    			return i-1;
 	    		//}
 	    		
 	    	}
 	    	
 	    }
    	return -1;
    }
    
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //long n = scanner.nextLong();
        //long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(100, 10));
    }
}

