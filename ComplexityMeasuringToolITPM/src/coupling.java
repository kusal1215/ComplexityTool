/**
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author oshadi
 *
 */
public class coupling {

	/*
	 * 
	 * Line Numers
	 * 
	 * 
	 */
	public static ArrayList<Integer> LineNumber(ArrayList<String> list) {

		int lineNumber = 0;
		ArrayList<Integer> lineNum = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {

			lineNumber = lineNumber + 1;
			lineNum.add(lineNumber);
		}
		System.out.println(lineNum.size());

		return lineNum;
	}

	/*
	 * 
	 * 
	 * Nr List
	 * 
	 * 
	 * 
	 */
	public static ArrayList<Integer> Nr(ArrayList<String> method) {

		ArrayList<String> methodSet = new ArrayList<String>();
		ArrayList<String> recursivelist = new ArrayList<String>();
		ArrayList<Integer> NrList = new ArrayList<Integer>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		/*-----testing variable for bracket in methods-------*/
		int bracketnumber = 0;

		int lineNumber = 0;
		String[] var;
		int Nr = 0;
		int TemporyNrBucket = 0;
		int TemporyLineBucket = 0;

		/* -----------------get method list------------------------- */
		for (int i = 0; i < method.size(); i++) {

			String lines = method.get(i);

			lineNumber = lineNumber + 1;

			// Check for class
			if (lines.contains("class")) {
				if (lines.contains("public") || lines.contains("abstract") || lines.contains("final")) {

				} else {

				}

			}
			// check for methods
			else if (lines.contains("if") || lines.contains("switch") || lines.contains("catch")
					|| lines.contains("return") || lines.contains(";")) {

			} else if (lines.contains("main") && lines.contains("(String[] args)")) {

			} else if (lines.contains("(")
					&& (lines.contains("public") || lines.contains("private") || lines.contains("protected"))) {

				String[] sub = lines.split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();

				if (x.split(" ").length > 1) {
					methodSet.add(x.split(" ")[1]);
				} else {
					methodSet.add(x);
				}

				// recursive check
				bracketnumber = 1;
				int line = 0;
				System.out.println(method.size() + "    " + x);
				for (int b = lineNumber; b < method.size(); b++) {

					line = line + 1;

					String linesCHECK = method.get(b);

					// Check for brackets
					if (linesCHECK.contains("{")) {
						bracketnumber = bracketnumber + 1;
					} else if (linesCHECK.contains("}")) {
						bracketnumber = bracketnumber - 1;
					}

					// check whether this includes recursive call
					if (linesCHECK.contains(x) || linesCHECK.contains(x.split(" ")[1])) {
						System.out.println("THIS IS A RECURSIVE CALL" + x + " :RECURSIVE FUNCTION NAME\t" + linesCHECK);

						if (x.split(" ").length > 1) {
							recursivelist.add(x.split(" ")[1]);
							System.out.println("For testing purpose, get the x value wich adds to the recursivelist:\t"
									+ x.split(" ")[1]);
						} else {
							recursivelist.add(x);
							System.out.println(
									"For testing purpose, get the x value wich adds to the recursivelist:\t" + x);
						}

						var = linesCHECK.split(" ");
						for (int j = 0; j < var.length; j++) {
							System.out.println(var[j]);

							if (var[j].contains(x) || var[j].contains(x.split(" ")[1])) {
								Nr = Nr + 1;

							}

						}
						TemporyNrBucket = Nr;
						System.out.println("Tempory Nr Bucket value:\t" + TemporyNrBucket);

					}

					if (bracketnumber == 0) {

						Nr = 0;
						TemporyLineBucket = b;
						hash.put(TemporyLineBucket, TemporyNrBucket);
						break;
					}

				}

			} else {
				//is it need for the implementation?
				if (lineNumber == TemporyLineBucket) {
					NrList.add(TemporyLineBucket);
				} else {
					NrList.add(0);
				}
			}

		}
		/* for methods */
		for (int i = 0; i < methodSet.size(); i++) {

			for (int j = 0; j < recursivelist.size(); j++) {
				if (methodSet.get(i).contains(recursivelist.get(j))) {
					System.out.println("method to remove:" + methodSet.get(i));
					methodSet.remove(i);
				}
			}
		}

		for (int i = 0; i < methodSet.size(); i++) {
			System.out.println(methodSet.get(i));
		}

		for (int i = 0; i < recursivelist.size(); i++) {
			System.out.println(recursivelist.get(i) + ": Recursive");
		}
		/* for methods ends here */

		int NUMBER = 0;
		ArrayList<Integer> testingNrList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBER = NUMBER + 1;

			if (hash.containsKey(NUMBER) == true) {
				testingNrList.add(hash.get(NUMBER));
				System.out.println(hash.get(NUMBER));
			} else {
				testingNrList.add(0);
			}

		}
		for (int i = 0; i < method.size(); i++) {
			System.out.println(testingNrList.get(i) + ": NrTesting" + method.get(i));
		}

		System.out.println(method.size() + "\t" + testingNrList + " ");

		return testingNrList;
	}

	/*
	 * 
	 * Wr list
	 * 
	 */
	public static ArrayList<Integer> Wr(ArrayList<Integer> testingNrArrayList) {
		ArrayList<Integer> Wr = new ArrayList<Integer>();
		for (int i = 0; i < testingNrArrayList.size(); i++) {

			Wr.add(testingNrArrayList.get(i) * 2);

		}
		return Wr;
	}
	
	
	public static ArrayList<Integer> Ccp(ArrayList<String> method, ArrayList<Integer> testingNrList, 
			ArrayList<Integer> testingWrList, ArrayList<Integer> testingNmcmsList, 
			ArrayList<Integer> testingWmcmsList,  ArrayList<Integer> testingNrmcmsList, 
			ArrayList<Integer> testingWrmcmsList, ArrayList<Integer> testingNrmcrmsList, 
			ArrayList<Integer> testingWrmcrmsList,ArrayList<Integer> testingNmcrmsList,
			ArrayList<Integer> testingWmcrmsList) {

		int Ccp = 0;
		ArrayList<Integer> TestingCcpList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			Ccp = (testingNrList.get(i) * testingWrList.get(i)) + (testingNmcmsList.get(i) * 
					testingWmcmsList.get(i)) + (testingNrmcmsList.get(i) * testingWrmcmsList.get(i))
					+ (testingNrmcrmsList.get(i) * testingWrmcrmsList.get(i)) + (testingNmcrmsList.get(i) * 
					testingWmcrmsList.get(i));
			TestingCcpList.add(Ccp);
		}

		return TestingCcpList;
	}
	
	
}
