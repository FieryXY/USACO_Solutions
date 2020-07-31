package Coursera_Problems;
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int[][] valueToWeight, int capacity) {
        double value = 0;
        int capacityLeft = capacity;
        //write your code here
        int[][] sortedVW = sortItems(valueToWeight);
        
        for(int i = 0; i < sortedVW.length && capacityLeft > 0; i++) {
        	int[] currentItem = sortedVW[i];
        	if(capacityLeft >= currentItem[1]) {
        		value += currentItem[0];
        		capacityLeft -= currentItem[1];
        		continue;
        	}
        	else {
        		double unitValue = ((double) currentItem[0])/currentItem[1];
        		double valueToPut = unitValue * capacityLeft;
        		value += valueToPut;
        		capacityLeft = 0;
        	}
        }
        
        return value;
    }
    
    //Custom Merge Sort for Fractional Knapsack Problem
    private static int[][] sortItems(int[][] valueToWeight) {
    	
    	if(valueToWeight.length == 1) {
    		return valueToWeight;
    	}
    	else {
    		
    		int[][] left = sortItems(Arrays.copyOfRange(valueToWeight, 0, (valueToWeight.length/2)));
    		int[][] right = sortItems(Arrays.copyOfRange(valueToWeight, (valueToWeight.length/2), valueToWeight.length));
    		
    		//Merge Sort
    		int leftPtr = 0, rightPtr = 0, newPtr = 0;
    		int[][] mergedArray = new int[valueToWeight.length][2];
    		
    		while(newPtr < valueToWeight.length) {
    			double ratioL = (leftPtr >= left.length) ? -1 : ((double)left[leftPtr][0])/left[leftPtr][1];
    			double ratioR = (rightPtr >= right.length) ? -1 :((double)right[rightPtr][0])/right[rightPtr][1];
    			if(ratioL == -1 && ratioR == -1) {
    				break;
    			}
    			if(ratioL > ratioR) {
    				mergedArray[newPtr] = left[leftPtr];
    				newPtr++;
    				leftPtr++;
    			}
    			else if(ratioR >= ratioL) {
    				mergedArray[newPtr] = right[rightPtr];
    				newPtr++;
    				rightPtr++;
    			}
    		}
    		
    		return mergedArray;
    		
    	}
    	
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[][] valueToWeight = new int[n][n];
        for (int i = 0; i < n; i++) {
            int nextValue = scanner.nextInt();
            int nextWeight = scanner.nextInt();
            valueToWeight[i] = new int[] {nextValue, nextWeight};
        }
        System.out.println(getOptimalValue(valueToWeight, capacity));
    }
} 
