package src.wordCount.visitors;

import src.wordCount.treesForStrings.Node;

public class grepVisitor implements VisitorInterface {
	
	private Integer searchCounter = 0;
	/**
	 * Grep Visitor visit method that searches for the given string
	 * @param input fileName
	 * @param Root of the tree
	 * @param Search Key
	 * @param Output file name
	 * @return Root of BST with result updated in the node
	 */
	public Node visit(String inputFileName, Node rootOfBst, String searchKey,
			String outputFileName) {
		findCountOfSearchString(rootOfBst, searchKey);
		rootOfBst.getWordInfo().setResult("The word \"" + searchKey + "\" occurs the following times: "
				+ searchCounter);
		return rootOfBst;
	}


	/**
	 * @param rootOfBst
	 * @param searchKey
	 * @return Void but updates the search counter with the required value
	 */
	private void findCountOfSearchString(Node rootOfBst, String searchKey) {
		if (rootOfBst!=null){
			findCountOfSearchString(rootOfBst.getLeft(), searchKey);
			if (rootOfBst.getWordInfo().getName().equals(searchKey)){
				searchCounter = rootOfBst.getWordInfo().getFrequency();
			}
			findCountOfSearchString(rootOfBst.getRight(), searchKey);
		}
		
	}



}
