package Coursera_Problems;
import java.util.*;

public class FibonacciPartialSum {
	
	private static final int ITER_LENGTH = 60;
	private static final int ITER_SUM = 280;
	
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciPartialSum(long from, long to) {
    	
    	int sum = 0;
    	
    	sum += getFibonacciPartialSumNaive(from%ITER_LENGTH,ITER_LENGTH-1);
    	sum += getFibonacciPartialSumNaive(0,to%ITER_LENGTH);
    	
    	long remainingSpace = (to-from)-((ITER_LENGTH-from%ITER_LENGTH)+(to%ITER_LENGTH+1));
    	sum += (remainingSpace%ITER_LENGTH)*ITER_SUM;
    	
    	
    	return sum%10;
    }
    
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long from = scanner.nextLong();
//        long to = scanner.nextLong();
//        System.out.println(getFibonacciPartialSumNaive(from, to));
    	
    	Random r = new Random();
    	while(true) {
    		long newN = r.nextInt(300);
    		
    		newN = (newN > 0) ? newN : newN*-1;
    		long lowerN = r.nextInt((int) newN);
    		lowerN = (lowerN > 0) ? lowerN : lowerN*-1;
    		long sumEff = getFibonacciPartialSum(lowerN, newN);
    		long sumNaive = getFibonacciPartialSumNaive(lowerN, newN);
    		if(sumEff == sumNaive) {
    			System.out.println(lowerN+","+newN+" works with an answer of "+sumEff);
    		}
    		else {
    			System.out.println(lowerN+","+newN+" does NOT work: \nNaive:"+sumNaive+"\nEfficient:"+sumEff);
    			break;
    		}
    	}
    }
}

