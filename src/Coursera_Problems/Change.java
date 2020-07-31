package Coursera_Problems;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	
    	int tenCoins = m / 10;
    	m = m % 10;
    	int fiveCoins = m / 5;
    	m = m % 5;
    	
    	
    	
        return tenCoins + fiveCoins + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

