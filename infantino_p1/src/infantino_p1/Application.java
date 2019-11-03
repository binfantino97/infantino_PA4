package infantino_p1;
public class Application {

	public static void main(String[] args) {
		String dataFile = "problem1.txt";
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove(dataFile);
		String outputFile = "unique_words.txt";
		duplicateRemover.write(outputFile);
	}

}
