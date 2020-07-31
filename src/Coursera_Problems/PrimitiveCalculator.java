package Coursera_Problems;
import java.io.ByteArrayInputStream;
import java.util.*;

public class PrimitiveCalculator {
	
	
	
    private static ReturnThingCuzWhyNot optimal_sequence(int n) {
       
    
    	int[] T = new int[n+1];
    	String[] prevs = new String[n+1];
    	prevs[0] = "";
    	
    	for(int i = 1; i <= n; i++) {
    		int one = i, two = i, three = i;
    		if(i - 1 >= 0) {
    			one = T[i-1]+1;
    		}
    		if(i%2 == 0) {
    			two = T[i/2]+1;
    		}
    		if(i%3 == 0) {
    			three = T[i/3]+1;
    		}
    		T[i] = Math.min(one, two);
    		T[i] = Math.min(T[i], three);
    		prevs[i] = "";
    		prevs[i] += (T[i] == one) ? (prevs[i-1]) : ((T[i] == three) ? (prevs[i/3]) : (prevs[i/2]));
    		prevs[i] += String.valueOf(i)+" ";
    	}
    	
    	
    	
        return new ReturnThingCuzWhyNot(prevs[n].trim(), T[n]-1);
    }

    
    
//    private static int getOptimalSequence(int n) {
//    	if(len.containsKey(n)) {
//    		return len.get(n);
//    	}
//    	
//    	int newValue = n;
//    	int lastNumber = n-1;
//    	int packetLeague;
//    	
//    	
//    	
//    	
//    	packetLeague = (n % 2 == 0) ? getOptimalSequence(n/2)+1 : newValue;
//    	if(packetLeague < newValue) {
//    		newValue = packetLeague;
//    		lastNumber = n/2;
//    	}
//    	packetLeague = (n % 3 == 0) ? getOptimalSequence(n/3)+1 : newValue;
//    	if(packetLeague < newValue) {
//    		newValue = packetLeague;
//    		lastNumber = n/3;
//    	}
//    	
//    	
//    	packetLeague = getOptimalSequence(n-1)+1;
//    	if(packetLeague < newValue) {
//    		newValue = packetLeague;
//    		lastNumber = n-1;
//    	}
//    	
//    	
//    	len.put(n, newValue);
//    	prev.put(n, lastNumber);
//    	
//    	return newValue;
//    	
//    }
    
    public static void main(String[] args) {
//    	String toPutIn = "96234";
//    	System.setIn(new ByteArrayInputStream(toPutIn.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ReturnThingCuzWhyNot sequence = optimal_sequence(n);
        System.out.println(sequence.i);
        System.out.print(sequence.s);
    }
}

class ReturnThingCuzWhyNot {
	String s;
	int i;
	ReturnThingCuzWhyNot(String s, int i) {
		this.s = s;
		this.i = i;
	}
}

