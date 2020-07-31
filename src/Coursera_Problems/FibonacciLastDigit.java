package Coursera_Problems;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
    	 if(n <= 0) {
   		  return 0;
   	  }
   	  else if(n <= 1) {
   		  return 1;
   	  }
       long[] fibList = new long[n];
       fibList[0] = 1;
       fibList[1] = 1;
       
       for(int i = 2; i < fibList.length; i++) {
       	fibList[i] = fibList[i-1]+fibList[i-2];
       }
       return (int) (fibList[n-1]%10);
    }
    
    private static int getFibonacciLastDigit(int n) {
    	return getFibonacciLastDigitNaive(n%60);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

