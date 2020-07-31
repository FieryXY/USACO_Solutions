package Coursera_Problems;
import java.util.*;
import java.io.*;

public class CarFueling {
	static int[] stops;
	static int dist;
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	//0: Beginning, 1-n: Stops, n+1: End
    	CarFueling.stops = stops;
    	CarFueling.dist = dist;
    	
    	int totalStops = 0;
    
    	int n = stops.length;
    	int currentStop = 0;
    	
    	
    	while(currentStop <= n) {
    		int lastStop = currentStop;
    		while(currentStop <= n && getStop(currentStop+1)-getStop(lastStop) <= tank) {
    			currentStop++;
    		}
    		
    		if(currentStop == lastStop) {
    			return -1;
    		}
    		if(currentStop <= n) {
    			totalStops++;
    		}
    	}
    	
    	return totalStops;
    	
    }
    
    private static int getStop(int index) {
    	if(index == 0) return 0;
    	if(index == stops.length+1) return dist;
    	return stops[index-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    	
    


    }
}
