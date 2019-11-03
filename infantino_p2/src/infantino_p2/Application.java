package infantino_p2;

public class Application {

	public static void main(String[] args) {
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		String dataFile= "problem2.txt";
		duplicateCounter.count(dataFile);
		String outputFile = "unique_word_counts.txt";
		duplicateCounter.write(outputFile);
	}

}
