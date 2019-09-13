/**
 * 
 */
package ww.sophiemiron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Sophie Miron
 *
 */
public class Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		if (args.length < 1 ) {
			System.out.println("\nusage: C:\\> java Q3 <integer>"); 
			System.exit(0);
		}
		
		int argN = Integer.parseInt(args[0]);
		Random rand = new Random();
		ArrayList<Integer> randomNumbers = new ArrayList<>(); 
		
		// Generate 500 random numbers and 
		for (int i = 0; i< 500; i++) {
			int newnum = rand.nextInt(Integer.MAX_VALUE);  // keep them positivie
			randomNumbers.add(newnum);					// assuming we want to keep the 500 numbers
		}
	    printNthSmallest(randomNumbers, argN);
		
	}
	// create a method to print the nth smallest number in a programming language of your choice. 
    public static void printNthSmallest(ArrayList<Integer> toSort, int n ) {
    	Collections.sort(toSort);
    	System.out.println(toSort.get(n-1));
    }	
}
