package Coursera_Problems;
import java.util.*;

public class FibonacciSumLastDigit {
	
	
	private static final int ITER_LENGTH = 60;
	private static final int ITER_SUM = 280;
	
    private static long getFibonacciSumNaive(long n) {
    	if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciSum(long n) {
    	int sum = 0;
    	sum += ((n/ITER_LENGTH)*ITER_SUM)%10;
    	sum += getFibonacciSumNaive(n % ITER_LENGTH);
    	
    	return sum%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long n = 2;
        long s = getFibonacciSum(n);
        System.out.println(s);
    	
//    	Random r = new Random();
//    	while(true) {
//    		long newN = r.nextInt(300);
//    		newN = (newN > 0) ? newN : newN*-1;
//    		long sumEff = getFibonacciSum(newN);
//    		long sumNaive = getFibonacciSumNaive(newN);
//    		if(sumEff == sumNaive) {
//    			System.out.println(newN+" works with an answer of "+sumEff);
//    		}
//    		else {
//    			System.out.println(newN+" does NOT work: \nNaive:"+sumNaive+"\nEfficient:"+sumEff);
//    			break;
//    		}
//    	}
    	
    }
}

