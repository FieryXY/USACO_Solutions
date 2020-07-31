package Coursera_Problems;
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
    	
    	Arrays.sort(a, (s1,s2) -> {
    		String one = (String) s1, two = (String) s2;
    		if(one.length() > two.length()) {
    			two = two + new String(new char[one.length()-two.length()]).replace("\0", "9");
    		}
    		else if (two.length() > one.length()) {
    			one = one + new String(new char[two.length()-one.length()]).replace("\0", "9");
    		}
    		
    		return Collections.reverseOrder().compare(Integer.valueOf(one), Integer.valueOf(two));
    	});
    	
    	
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

