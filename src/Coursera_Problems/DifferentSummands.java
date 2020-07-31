package Coursera_Problems;
import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        
        int nextNumber = 1;
        
        int sum = 0;
        
        while(sum < n) {
        	if(sum + nextNumber > n)  {
        		sum -= (nextNumber-1);
        		summands.remove(summands.size()-1);
        		summands.add(n-sum);
        		break;
        	}
        	
        	sum += nextNumber;
        	summands.add(nextNumber);
        	nextNumber++;
        }
        
        //write your code here
        return summands;
    }
    
    public static void main(String[] args) {
    	

    	
    	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

