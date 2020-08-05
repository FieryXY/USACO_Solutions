package Coursera_Problems;
import java.util.*;
import java.io.*;

public class Partition3 {
	
	
	public static int[] values;
	public static boolean[] bean;
	
    private static int partition3(int sum) {
        //write your code here
    	
    	if(sum % 3 != 0) {
    		return 0;
    	}
    	
    	
    	boolean one = summation(values.length, sum/3);
    	if(!one) return 0;
    	boolean two = summation(values.length, sum/3);
    	if(!two) return 0;
    	boolean three = summation(values.length, sum/3);
    	if(!three) return 0;
    	
    	
        return 1;
    }
    
    private static boolean summation(int cap, int goal) {
    	
    	
    	if(goal == 0 && cap == 0) {
    		return true;
    	}
    	else if(goal == 0) {
    		return true;
    	}
    	else if(cap == 0) {
    		return false;
    	}
    	
    	
    	
    	
    	if(!bean[cap-1] && summation(cap-1,goal-values[cap-1])) {
    		int removed = values[cap-1];
    		//System.out.println(removed);
    		bean[cap-1] = true;
    		return true;
    	}
    	else if(summation(cap-1, goal)) {
    		return true;
    	}
    	
    	
    	return false;
    }

    public static void main(String[] args) {
//    	String toPutIn = "6\n1 1 2 3 4 4";
//    	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            sum += A[i];
        }
        values = A;
        bean = new boolean[values.length];
       Arrays.sort(values);
       System.out.println(partition3(sum));
        
        
    }
}



