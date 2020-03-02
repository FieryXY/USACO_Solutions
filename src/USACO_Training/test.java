package USACO_Training;
/*
 ID: SohanA
 LANG: JAVA
 TASK: test
*/

import java.io.*;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) {
    	 // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f;
		try {
			f = new BufferedReader(new FileReader("test.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	        // Use StringTokenizer vs. readLine/split -- lots faster
	        StringTokenizer st = new StringTokenizer(f.readLine());
	    						  // Get line, break into tokens
	        int i1 = Integer.parseInt(st.nextToken());    // first integer
	        int i2 = Integer.parseInt(st.nextToken());    // second integer
	        out.println(i1+i2);                           // output result
	        out.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                                                      // input file name goes above
		catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
