package src.wordCount.treesForStrings;

/**
 * @author Hari 
 * This is the class which has all methods for a tree. Insertion
 * into a tree, Traversing a tree
 */
public class BST {

	private Node node;

	/**
	 * This method inserts all the words from the file into the tree
	 * @param Root of the bst for which nodes have to be created and attached
	 * @param WordInfo pojo that has information related to word
	 * @return Root node of the updated tree
	 */
	public Node insertIntoTree(Node rootBST, WordInfo wordInfo) {

		if (rootBST == null) {
			// Tree is empty. Create root node first
			rootBST = createNode(rootBST, wordInfo);
		} else {
			if (wordInfo.getName().compareTo(
					rootBST.getWordInfo().getName()) < 0) {
				Node lnode = insertIntoTree(rootBST.getLeft(), wordInfo);
				rootBST.setLeft(lnode);

			} else if (wordInfo.getName().compareTo(
					rootBST.getWordInfo().getName()) > 0) {

				Node rnode = insertIntoTree(rootBST.getRight(), wordInfo);
				rootBST.setRight(rnode);
			} else {
				// No update here. Just we need to update the values
				WordInfo updatedWordInfo = new WordInfo();
				updatedWordInfo.setName(rootBST.getWordInfo().getName());
				updatedWordInfo.setFrequency(rootBST.getWordInfo()
						.getFrequency() + wordInfo.getFrequency());
				updatedWordInfo.setNoOfCharacters(wordInfo.getNoOfCharacters());
				rootBST.setWordInfo(updatedWordInfo);
			}
		}
		return rootBST;
	}
	/**
	 * This method accepts an empty node and creates a node with necessary info and returns it
	 * @param Instance of node class or simply call it as a node object
	 * @param wordInfo information related to word
	 * @return Node created
	 */
	private Node createNode(Node node, WordInfo wordInfo) {
		node = new Node();
		node.setWordInfo(wordInfo);
		node.setLeft(null);
		node.setRight(null);
		return node;
	}
	/**
	 * @return get the required node
	 */
	public Node getNode() {
		return node;
	}
	/**
	 * Accepts the node and updates the present node with incoming node
	 * @param node
	 * 
	 */
	public void setNode(Node node) {
		this.node = node;
	}
}
