package Coursera_Problems;
import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    if(a == 0 || b == 0) return (a == 0) ? b : a;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  
  private static int euclidean_gcd(int a, int b) {
	  
	  int currentOne, currentTwo;
	  currentOne = (a > b) ? a : b;
	  currentTwo = (a <= b) ? a : b;
	  
	  while(currentTwo != 0) {
		  int newTwo = currentOne % currentTwo;
		  int newOne = currentTwo;
		  currentOne = newOne;
		  currentTwo = newTwo;
	  }
	  
	  
	  
	  return currentOne;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    

    System.out.println(euclidean_gcd(a, b));
//	  Random r = new Random();
//	  while(true) {
//		  int someRandom1 = r.nextInt(5000);
//		  int someRandom2 = r.nextInt(5000);
//		  
//		  int eucAns = euclidean_gcd(someRandom1, someRandom2);
//		  int naivAns = gcd_naive(someRandom1, someRandom2);
//		  if(eucAns == naivAns) {
//			  System.out.println("gcd("+someRandom1+","+someRandom2+")"+" works answer of "+naivAns);
//		  }
//		  else {
//			  System.out.println("gcd("+someRandom1+","+someRandom2+")"+"does not work");
//			  System.out.println("Naive: "+naivAns);
//			  System.out.println("Euclidean GCD: "+eucAns);
//			  break;
//		  }
//	  }
  }
}
