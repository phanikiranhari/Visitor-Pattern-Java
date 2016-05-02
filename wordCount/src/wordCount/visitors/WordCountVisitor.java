package src.wordCount.visitors;

import java.util.ArrayList;
import java.util.List;

import src.wordCount.treesForStrings.Node;
import src.wordCount.util.FileProcessor;

public class WordCountVisitor implements VisitorInterface{
	private int TOTAL_COUNT_OF_WORDS = 0;
	private int TOTAL_COUNT_OF_CHARACTERS = 0;
	private String MOST_FREQUENT_WORD = "";
	private int FREQUENCY_OF_MOST_FREQUENT_WORD = 0;
	private List<String> listOfMostFrequentWords = new ArrayList<String>();

	/**
	 * Word Count Visitor visit method that calculates all the information about word counts, frequency etc.
	 * @param input fileName
	 * @param Root of the tree
	 * @param Search Key
	 * @param Output file name
	 * @return Root of BST with result updated in the output file
	 */
	public Node visit(String inputFileName, Node rootOfBst, String searchKey,
			String outputFileName) {

		findCountOfTotalWords(rootOfBst);
		findTheMostFrequentWordAndFrequency(rootOfBst);
		findTotalNumberOfCharactersInTheTree(rootOfBst);
		storeTheTreeInfromation(outputFileName, rootOfBst);
		return rootOfBst;
	}

	/**
	 * @param outputFileName
	 * @param rootOfBst
	 */
	private void storeTheTreeInfromation(String outputFileName, Node rootOfBst) {
		FileProcessor fileProcessor = new FileProcessor(outputFileName, true);
		fileProcessor.writeLineToFile("The total number of words is: "+TOTAL_COUNT_OF_WORDS);
		fileProcessor.writeLineToFile("The most frequently used word is: " +listOfMostFrequentWords);
		fileProcessor.writeLineToFile("The frequency of most frequently used word is: " +FREQUENCY_OF_MOST_FREQUENT_WORD);
		fileProcessor.writeLineToFile("The number of characters (without whitespaces) is: "+TOTAL_COUNT_OF_CHARACTERS);
		fileProcessor.writeLineToFile(rootOfBst.getWordInfo().getResult());
		fileProcessor.writeLineToFile("");
		fileProcessor.closeBufferWriter();
	}

	/**
	 * @param rootOfBst
	 * @return void but calculates the total number of characters in the tree
	 */
	private void findTotalNumberOfCharactersInTheTree(Node rootOfBst) {
		if (rootOfBst != null) {
			findTotalNumberOfCharactersInTheTree(rootOfBst.getLeft());
			TOTAL_COUNT_OF_CHARACTERS +=(rootOfBst.getWordInfo().getFrequency() * rootOfBst
							.getWordInfo().getNoOfCharacters());
			findTotalNumberOfCharactersInTheTree(rootOfBst.getRight());
		}

	}

	/**
	 * @param rootOfBst
	 * @return void but calculates the most frequent word and its frequency
	 */
	private void findTheMostFrequentWordAndFrequency(Node rootOfBst) {
		if (rootOfBst!=null){
			findTheMostFrequentWordAndFrequency(rootOfBst.getLeft());
			if (rootOfBst.getWordInfo().getFrequency() > FREQUENCY_OF_MOST_FREQUENT_WORD){
				listOfMostFrequentWords = new ArrayList<String>();
				MOST_FREQUENT_WORD = rootOfBst.getWordInfo().getName();
				FREQUENCY_OF_MOST_FREQUENT_WORD = rootOfBst.getWordInfo().getFrequency();
				listOfMostFrequentWords.add(MOST_FREQUENT_WORD);
			}
			else if (rootOfBst.getWordInfo().getFrequency() == FREQUENCY_OF_MOST_FREQUENT_WORD){
				//Frequency of two words are equal
				listOfMostFrequentWords.add(rootOfBst.getWordInfo().getName());
			}
			findTheMostFrequentWordAndFrequency(rootOfBst.getRight());
		}
		
	}

	/**
	 * @param rootOfBst
	 * @return void but calculates the count of total number of words
	 */
	private void findCountOfTotalWords(Node rootOfBst) {
		if (rootOfBst!=null){
			findCountOfTotalWords(rootOfBst.getLeft());
			TOTAL_COUNT_OF_WORDS = TOTAL_COUNT_OF_WORDS + rootOfBst.getWordInfo().getFrequency();
			findCountOfTotalWords(rootOfBst.getRight());
		}
		
	}


}
