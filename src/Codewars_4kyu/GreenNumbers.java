package Codewars_4kyu;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;



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
		//dyn.add(new CustomSet(new BigInteger("1"), new BigInteger("1")));
		dyn.add(new CustomSet(new BigInteger("5"), new BigInteger("25")));
		dyn.add(new CustomSet(new BigInteger("6"), new BigInteger("36")));
		
		

	}
	
	public static void main(String[] args) {
//		while(true) {
//			String[] randomMaze = new String[4];
//			Random rand = new Random();
//			for(int i = 0; i < randomMaze.length; i++)
//				for(int j = 0; j < randomMaze.length; j++) {
//					if(randomMaze[i] == null) randomMaze[i] = "";
//					if(i == 0 && j == 0) {
//						randomMaze[0] = ".";
//						continue;
//					}
//					randomMaze[i] += (rand.nextInt(2) == 0) ? "." : "W";
//				}
//					
//			String a = String.join("\n", randomMaze);
//			boolean tru = Finder.pathFinder(a);
//			if(tru) {
//				System.out.println(tru);
//				System.out.println(a);
//				break;
//			}
//		}
		String a ="....\n"
				+ "W..W\n"
				+ "..W.\n"
				+ "W.W.";
		System.out.println(Finder.pathFinder(a));
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
    	
    	boolean continuing = true;
    	
    	
    	while(count < n) {
    		CustomSet newValue = nextNumber(dyn.remove());
    		if(newValue == null) {
    			continue;
    		}
    		if(continuing) {
    			dyn.add(newValue);
    		}
    		if(dyn.isEmpty()) {
    			return newValue.s;
    		}
    		count++;
    		if(count == n) {
    			continuing = false;
    		}
    		
    	}
    	
    	
    	
    	
    	
    	
    	
        // Your code here!
        return null;
    }
    
    private static CustomSet nextNumber(CustomSet t) {
    	
    	String base = t.s.toString();
    	String delimeter = "";
    	
    	while(true) {
    		for(int j = 1; j < 10; j++) {
        		BigInteger based = new BigInteger(j+delimeter+base);
        		BigInteger possibility = square(based, t.sqr);
        		String str = possibility.toString();
        		if(str.substring(str.length()-(base.length()+delimeter.length()+1)).equals(j+delimeter+base)) {
        			return new CustomSet(based, possibility);
        		}
        	}
    		delimeter += "0";
    	}
    	
    	
    	
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