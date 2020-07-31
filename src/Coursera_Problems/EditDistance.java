package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;

class EditDistance {
	
	
	private static Integer[][] dynamicMatrix;	
	
	private static String s, t;
	
  public static int EditDistance(int a, int b) {
	  
	  if(dynamicMatrix[a][b] != null) {
		  return dynamicMatrix[a][b];
	  }
	  else if(a == 0) {
		  dynamicMatrix[0][b] = b;
		  return b;
	  }
	  else if(b == 0) {
		  dynamicMatrix[a][0] = a;
		  return a;
	  }
	  
	  int left, top, diagonal;
	  
	  left = EditDistance(a-1,b)+1;
	  top = EditDistance(a, b-1)+1;
	  diagonal = EditDistance(a-1, b-1)+1;
	  
	  if(s.charAt(a-1) == t.charAt(b-1)) {
		  diagonal--;
	  }
	  
	  int answer = Math.min(left, top);
	  answer = Math.min(answer, diagonal);
	  
	  
	  dynamicMatrix[a][b] = answer;
	  
    //write your code here
    return answer;
  }
  public static void main(String args[]) {
//  	String toPutIn = "short\nports";
//  	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
    Scanner scan = new Scanner(System.in);

     s = scan.next();
     t = scan.next();

    dynamicMatrix = new Integer[s.length()+1][t.length()+1];
    
    System.out.println(EditDistance(s.length(), t.length()));
  }

}
