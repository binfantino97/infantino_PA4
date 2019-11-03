package infantino_p1;
import java.util.*;
import java.io.*;

public class DuplicateRemover {

	 Scanner scnr; 
    HashSet<String> uniqueWords = new HashSet<String>(); 
	
	public void remove(String dataFile) {
		
		try{
			scnr = new Scanner(new File(dataFile));
			System.out.println("Opened "+dataFile);
		}
		catch(IOException e) {
			System.out.println("Invalid file.");
			System.out.println("Terminating.");
			System.exit(0);
		}
		
		System.out.println("Collecting all unique words.");
		while(scnr.hasNext()) {
			String word = scnr.next();
			uniqueWords.add(word);
			}
		
		// close file
		System.out.println("Closing " +dataFile);
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
		
		
		Iterator<String> it = uniqueWords.iterator();
		String word = "";
		
	    while(it.hasNext()){
	       word = it.next();
	       try {
		      x.write(word);
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

