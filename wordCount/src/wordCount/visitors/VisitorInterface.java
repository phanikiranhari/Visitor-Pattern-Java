package src.wordCount.visitors;

import src.wordCount.treesForStrings.Node;

/**
 * @author Hari
 *
 */
public interface VisitorInterface {

	/**
	 * Interface for all the 3 visitors and the method visit to traverse the tree
	 * @param inputFileName
	 * @param rootOfBst
	 * @param searchKey
	 * @param outputFileName
	 * @return Root Node
	 */
	public Node visit(String inputFileName, Node rootOfBst, String searchKey,
			String outputFileName);
	

}
