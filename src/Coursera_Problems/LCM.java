package Coursera_Problems;
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
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
 
 private static long lcm_efficient(int a, int b) {
	 int gcd = euclidean_gcd(a,b);
	 return (long) gcd*(a/gcd)*(b/gcd);
 }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_efficient(a, b));
//	  Random r = new Random();
//	  while(true) {
//		  int someRandom1 = r.nextInt();
//		  int someRandom2 = r.nextInt();
//		  
//		  long effAns = lcm_efficient(someRandom1, someRandom2);
//		  long naivAns = lcm_naive(someRandom1, someRandom2);
//		  if(effAns == naivAns) {
//			  System.out.println("lcm("+someRandom1+","+someRandom2+")"+" works answer of "+naivAns);
//		  }
//		  else {
//			  System.out.println("lcm("+someRandom1+","+someRandom2+")"+"does not work");
//			  System.out.println("Naive: "+naivAns);
//			  System.out.println("Efficient: "+effAns);
//			  break;
//		  }
//	  }
  }
}
