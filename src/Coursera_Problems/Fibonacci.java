package Coursera_Problems;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
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
    return fibList[n-1];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
