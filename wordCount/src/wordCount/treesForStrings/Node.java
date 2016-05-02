package src.wordCount.treesForStrings;


/**
 * @author Hari
 *
 * Node class that has the details of Node viz. Right Node, Left Node, Max Value.
 * And also this class is both Observer and Subject
 */
public class Node{

	private WordInfo wordInfo;
	private Node left;
	private Node right;
	public WordInfo getWordInfo() {
		return wordInfo;
	}
	public void setWordInfo(WordInfo wordInfo) {
		this.wordInfo = wordInfo;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
