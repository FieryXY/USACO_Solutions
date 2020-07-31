package Coursera_Problems;
import java.util.HashMap;
import java.util.Scanner;

public class ChangeDP {
	
	
	private static HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
	
    private static int getChange(int m) {
        //write your code here
    	
    	if(dict.containsKey(m)) {
    		return dict.get(m);
    	}
    	
    
    	
    	int newValue = m;
    	newValue = Math.min(newValue, getChange(m-1)+1);
    	newValue = Math.min(newValue, getChange(m-3)+1);
    	newValue = Math.min(newValue, getChange(m-4)+1);
    	
    	dict.put(m, newValue);
    	
        return newValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        dict.put(1, 1);
        dict.put(2, 2);
        dict.put(3, 1);
        dict.put(4, 1);
        System.out.println(getChange(m));

    }
}

