package Codewars_4kyu;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;



class CustomSet {
	BigInteger s;
	BigInteger sqr;
	
	CustomSet(BigInteger s, BigInteger sqr) {
		this.s = s;
		this.sqr = sqr;
	}
}


public class GreenNumbers {
  
	
	
	private static Queue<CustomSet> dyn = new LinkedList<CustomSet>();
	
	
	static {
		dyn.add(new CustomSet(new BigInteger("1"), new BigInteger("1")));
		dyn.add(new CustomSet(new BigInteger("5"), new BigInteger("25")));
		dyn.add(new CustomSet(new BigInteger("6"), new BigInteger("36")));
		
		

	}
	
	public static void main(String[] args) {
		System.out.println(get(12));
	}
	
    public static BigInteger get(int n) {
    	
    	
    	
    	int count = 3;
    	if(count <= 3) {
    		switch(n) {
    		case 1:
    			return new BigInteger("1");
    		case 2:
    			return new BigInteger("5");
    		case 3:
    			return new BigInteger("6");
    		}
    	}
    	
    	
    	
    	while(count < n) {
    		CustomSet newValue = nextNumber(dyn.remove());
    		if(newValue == null) {
    			continue;
    		}
    		dyn.add(newValue);
    		count++;
    		if(count == n) {
    			return newValue.s;
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
        // Your code here!
        return null;
    }
    
    private static CustomSet nextNumber(CustomSet t) {
    	
    	String base = t.s.toString();
    	
    	for(int j = 1; j < 10; j++) {
    		BigInteger based = new BigInteger(j+base);
    		BigInteger possibility = square(based, t.sqr);
    		String str = possibility.toString();
    		if(str.substring(str.length()-(base.length()+1)).equals(j+base)) {
    			return new CustomSet(based, possibility);
    		}
    	}
    	
    	
    	
    	return null;
    }
    
    private static BigInteger square(BigInteger s, BigInteger c) {
    	
    	
    	int newPower = s.toString().length()-1;
    	int newDigit =  Integer.valueOf(s.toString().substring(0,1));
    	BigInteger leftover = new BigInteger(s.toString().substring(1));
    	
    	
    	long a = (newDigit*newDigit);
    	BigInteger b = leftover.multiply(BigInteger.valueOf(newDigit*2));

    	
    	String newA = String.valueOf(a) + String.join("", Collections.nCopies(newPower*2, "0"));
    	String newB = b.toString() + String.join("", Collections.nCopies(newPower, "0"));
    	
    
    	
    	return new BigInteger(newA).add(new BigInteger(newB)).add(c);
    }
    
  
    
    
}