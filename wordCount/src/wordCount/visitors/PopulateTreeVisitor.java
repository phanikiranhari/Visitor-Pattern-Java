package src.wordCount.visitors;

import java.util.StringTokenizer;

import src.wordCount.treesForStrings.BST;
import src.wordCount.treesForStrings.Node;
import src.wordCount.treesForStrings.WordInfo;
import src.wordCount.util.FileProcessor;
import src.wordCount.util.Logger;

public class PopulateTreeVisitor implements VisitorInterface {

	private static Node rootOfBst;

	/**
	 * @param inputFileName
	 * @param The instance of tree i.e BST
	 * @return Updated tree after reading from the file
	 */
	public Node readFromFileAndPopulateTheTree(String inputFileName, BST bst) {
		FileProcessor fp = new FileProcessor(inputFileName);
		String currentLine;
		StringTokenizer st;
		String token;
		while ((currentLine = fp.readLineFromFile()) != null) {
			try {
				st = new StringTokenizer(currentLine); 
				//String[] split = currentLine.trim().split("\\s+");
				//if (!split[0].equals("")){
					while(st.hasMoreTokens()){
						WordInfo wordInfo = new WordInfo();
						token = st.nextToken();
						wordInfo.setFrequency(1);
						wordInfo.setName(token);
						wordInfo.setNoOfCharacters(token.length());
						// if (!token.equals(""))
						rootOfBst = bst.insertIntoTree(bst.getNode(), wordInfo);
						bst.setNode(rootOfBst);
					}
				//}
				
			} catch (NumberFormatException e) {
				Logger.writeMessage("Error: Please give only integers in the input file");
				System.exit(0);
			}

		}
		return rootOfBst;

	}

	/**
	 * Populate Tree Visitor visit method that populates the tree by reading from the input file
	 * @param input fileName
	 * @param Root of the tree
	 * @param Search Key
	 * @param Output file name
	 * @return Root of BST 
	 */
	public Node visit(String inputFileName, Node rootOfBst, String searchKey,
			String outputFileName) {
		BST bst = new BST();
		return readFromFileAndPopulateTheTree(inputFileName, bst);

	}

}
