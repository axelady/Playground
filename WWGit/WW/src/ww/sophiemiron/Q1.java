/**
 * 
 */
package ww.sophiemiron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sophie Miron
 *
 */
public class Q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		if (args.length < 1 ) {
			System.out.println("\nusage: C:\\> java Q1 <path to file>"); 
			System.exit(0);
		}
		
		String pathToFile = args[0];

		doesFileExist(pathToFile);

		printDict(makeDictionary(pathToFile));
		
	}
	
	static void doesFileExist(String path) {
		File testFile = new File(path);
		if (testFile.exists()) 
			System.out.println("File " + path + " exists.");
		else 
			System.out.println("File " + path + " does not exist."); 
	}
	
	static Map<String, List<String>> makeDictionary(String path) {
		
        Map<String, List<String>> dict = new HashMap<String, List<String>>();
        BufferedReader dictFile = null;
		try {
			dictFile = new BufferedReader( new FileReader(path) );
		} 
		catch (FileNotFoundException e1) {
			System.out.println("Exiting the program"); 
			e1.printStackTrace();
			System.exit(1);
		}
        
        try {
			while (dictFile.ready()) {
				String dictEntry = dictFile.readLine();
				String[] temp = dictEntry.split(" –");
				String word = temp[0];
				String meanings = temp[1];
				temp = meanings.split(",");
				List<String> meaningList  = Arrays.asList(temp);
				dict.put(word, meaningList);
			}
			dictFile.close();
		} 
        catch (IOException e) {
			System.out.println("An error occurred.  Check if your file is formatted correctly. Exiting the program"); 
			e.printStackTrace();
			System.exit(1);
		}
		return dict;
	}
	
	static void printDict(Map<String, List<String>> dictionary) {
		if (dictionary.isEmpty()) {
			System.out.println("There are no words defined in this file.");
		}
		else {
	        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
	            String word = entry.getKey();
	            System.out.println(word + ":");
	            List<String> meaningList = entry.getValue();
	            for (String meaning : meaningList) {
	            	System.out.println("     " + meaning);
	            }
	        }
		}
	} 
	
}
