package infantino_p2;

import java.io.*;
import java.util.*;

public class DuplicateCounter {
	 
	Scanner scnr; 
	HashMap<Integer, String> duplicateWords = new HashMap<Integer,String>(); 
	HashMap<String, Integer> uniqueWords = new HashMap<String, Integer>(); 

	
	public void count(String dataFile) {			
		try{
			scnr = new Scanner(new File(dataFile));
			System.out.println("Opened " + dataFile);
		}
		catch(IOException e) {
			System.out.println("Invalid file.");
			System.out.println("Terminating.");
			System.exit(0);
		}
		
		System.out.println("Reading " + dataFile);

		int i = 0;
		while(scnr.hasNext()) {
			String word = scnr.next();
			duplicateWords.put(i,word);
			i++;
		}
		
		int j; int value = 0;
		
		for(j = 0; j<i; j++) {
			if(!uniqueWords.containsKey(duplicateWords.get(j))) {
				uniqueWords.put(duplicateWords.get(j), 1);
			}
			else if(uniqueWords.containsKey(duplicateWords.get(j))) {
				uniqueWords.put(duplicateWords.get(j), uniqueWords.get(duplicateWords.get(j))+1 );
			}
		}
		
		//close file
		System.out.println("Closing "+ dataFile );
		scnr.close();
	}
	
	public void write(String outputFile) {
		
		FileWriter x = null;		
		try {
			x = new FileWriter(outputFile);
			System.out.println("Opened " +outputFile);

		}
		catch(IOException e) {
			System.out.println("Invalid file.");
			System.out.println("Terminating.");
			System.exit(0);
		}
		
		
		Iterator iter = uniqueWords.entrySet().iterator(); 

	    while(iter.hasNext()){
        Map.Entry mapElement = (Map.Entry)iter.next(); 
	       try {
		      x.write((String)mapElement.getKey());
		      x.write(" ");
		      int value = (int)mapElement.getValue();
		      String realValue = Integer.toString(value);
		      x.write(realValue);
		      x.write(System.lineSeparator());
	       }
			catch(IOException e) {
				System.out.println("Error writing to file.");
				System.out.println("Terminating.");
				System.exit(0);
			}		
	    }
	    
	    try {
	    	System.out.println("Finished writing to " + outputFile);
	    	x.flush();
	    	x.close();
	    	System.out.println("Closed " + outputFile);

	    }
		catch(IOException e) {
			System.out.println("Error Closing File");
			System.out.println("Terminating.");
			System.exit(0);
		}
	}
}
