package src.wordCount.treesForStrings;

/**
 * @author Hari
 * Class that has the information related to a word viz. frequency, noOfCharacters, name etc.
 * Various getters and setters to access the required info.
 */
public class WordInfo {
	
	private int frequency;
	private int noOfCharacters;
	private String name;
	private String result;
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getNoOfCharacters() {
		return noOfCharacters;
	}
	public void setNoOfCharacters(int noOfCharacters) {
		this.noOfCharacters = noOfCharacters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
