package src.wordCount.driver;

import src.wordCount.treesForStrings.Node;
import src.wordCount.util.Logger;
import src.wordCount.visitors.PopulateTreeVisitor;
import src.wordCount.visitors.VisitorInterface;
import src.wordCount.visitors.WordCountVisitor;
import src.wordCount.visitors.grepVisitor;


public class Driver {
	private static Node rootOfBst;

	/**
	 * Main method that invokes the methods for various visitors
	 * @param command line arguments that are passed by user
	 * @return void
	 */
	public static void main(String[] args) {

		if (args.length !=4){
			Logger.writeMessage("Incorrect command line arguments");
			System.exit(0);
		}
		else{
			try{
				String inputFileName = args[0];
				String outputFileName = args[1];
				int noOfIterations = Integer.parseInt(args[2]);
				String searchString = args[3];
				long startTime = System.currentTimeMillis();
				for (int i = 0; i < noOfIterations; i++) {
					VisitorInterface readingVisitor = new PopulateTreeVisitor();
					VisitorInterface grepVisitor = new grepVisitor();
					VisitorInterface wordCountVisitor = new WordCountVisitor();
						rootOfBst = readingVisitor.visit(inputFileName,
								rootOfBst, searchString, outputFileName);
					if (rootOfBst!=null){
						rootOfBst = grepVisitor.visit(inputFileName, rootOfBst, searchString, outputFileName);
						wordCountVisitor.visit(inputFileName, rootOfBst, searchString, outputFileName);
					}
					else{
						Logger.writeMessage("Error: The given input file is empty.");
						System.exit(0);
					}
				}
				long finishTime = System.currentTimeMillis();
				long totalTime = (finishTime - startTime) / noOfIterations;
				Logger.writeMessage("Average Performance time for one iteration "
						+ "is " + totalTime+"ms");
			}
			catch (NumberFormatException e){
				Logger.writeMessage("Error: No of iterations cannot be a string. Please give an integer value");
				System.exit(0);
			}
			catch (ArithmeticException e){
				Logger.writeMessage("Error: No of iterations cannot be 0. Please give an integer value greater than 0");
				System.exit(0);
			}
		}
	}
}
