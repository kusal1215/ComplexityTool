/**
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author oshadi
 *
 */
public class RecursiveMethods {

	public static ArrayList<Integer> Nrmcms(ArrayList<String> method) {

		ArrayList<String> methodSet = new ArrayList<String>();
		ArrayList<String> recursivelist = new ArrayList<String>();
		HashMap<Integer, Integer> hashNmrms = new HashMap<Integer, Integer>();

		int TemporyNrmcmsBucket = 0;
		int Nrmcms = 0;
		int TemporyNrmcmsLineBucket = 0;

		int bracketnumber = 0;

		int lineNumber = 0;
		String[] var;
		int methodLineNumber = 0;

		/* -----------------get method list------------------------- */
		for (int i = 0; i < method.size(); i++) {

			String lines = method.get(i);

			lineNumber = lineNumber + 1;

			// Check for class
			if (lines.contains("class")) {

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

					// no need
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

					}

					if (bracketnumber == 0) {
						break;
					}

				}

			}

		}

		/* for methods - remove recursive method names in regular method list */
		for (int i = 0; i < methodSet.size(); i++) {

			for (int j = 0; j < recursivelist.size(); j++) {
				if (methodSet.get(i).contains(recursivelist.get(j))) {
					System.out.println("method to remove:" + methodSet.get(i));
					methodSet.remove(i);
				}
			}
		}

		/*
		 * for (int i = 0; i < methodSet.size(); i++) {
		 * System.out.println(methodSet.get(i)); }
		 * 
		 * for (int i = 0; i < recursivelist.size(); i++) {
		 * System.out.println(recursivelist.get(i) + ": Recursive"); }
		 */
		/* for methods ends here */

		/*-----------------check for recursive method to regular method----------------------------*/
		for (int i = 0; i < method.size(); i++) {

			String lines = method.get(i);

			methodLineNumber = methodLineNumber + 1;

			// Check for class
			if (lines.contains("class")) {

			}
			// check for non methods
			else if (lines.contains("if") || lines.contains("switch") || lines.contains("catch")
					|| lines.contains("return") || lines.contains(";")) {

			}
			// check for main method
			else if (lines.contains("main") && lines.contains("(String[] args)")) {
				// do code in main regular method to check regular method call regular method

			}
			// check for methods
			else if (lines.contains("(")
					&& (lines.contains("public") || lines.contains("private") || lines.contains("protected"))) {
				// do code regular method to check regular method call regular method

				bracketnumber = 1;
				int line = 0;
				// System.out.println(method.size() + " " + x);

				for (int j = 0; j < recursivelist.size(); j++) {

					if (lines.contains(recursivelist.get(j))) {

						for (int b = i + 1; b < method.size(); b++) {

							String linesCHECK = method.get(b);
							System.out.println("TESTING METHODS" + linesCHECK);

							if (linesCHECK.contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (linesCHECK.contains("}")) {
								bracketnumber = bracketnumber - 1;
							}

							for (int j2 = 0; j2 < methodSet.size(); j2++) {

								if (linesCHECK.contains(methodSet.get(j2))) {
									// testing2.add(linesCHECK);
									System.out.println(b
											+ "PISSI MU PISSI MU PISSU PUSI MUUUUUUU.................HAAAAAAAAAAAAAAHAAAAAAAAAAAAAAAAAHAAAAAAA");

									var = linesCHECK.split(" ");
									for (int j3 = 0; j3 < var.length; j3++) {
										System.out.println(var[j3]);

										if (var[j3].contains(methodSet.get(j2))
												|| var[j3].contains(methodSet.get(j2).split(" ")[1])) {
											Nrmcms = Nrmcms + 1;

										}

									}
									TemporyNrmcmsBucket = Nrmcms;
									System.out.println("Tempory Nr Bucket value:\t" + TemporyNrmcmsBucket);

									Nrmcms = 0;
									TemporyNrmcmsLineBucket = b;
									hashNmrms.put(TemporyNrmcmsLineBucket, TemporyNrmcmsBucket);

									break;
								}
							}

							i = b;

							if (bracketnumber == 0) {

								System.out.println("break");
								break;
							}

						}
					} // if for check method type ends here
				} // for ends here

			} // method identification ends here
			System.out.println(i);
		} // check for regular method ends here

		for (int i = 0; i < methodSet.size(); i++) {
			System.out.println(methodSet.get(i));
		}

		for (int i = 0; i < recursivelist.size(); i++) {
			System.out.println(recursivelist.get(i) + ": Recursive");
		}
		/* for methods ends here */

		int NUMBER = 0;
		ArrayList<Integer> testingNrmcmsList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBER = NUMBER + 1;

			if (hashNmrms.containsKey(NUMBER) == true) {
				testingNrmcmsList.add(hashNmrms.get(NUMBER));
				System.out.println(hashNmrms.get(NUMBER));
			} else {
				testingNrmcmsList.add(0);
			}

		}

		for (int i = 0; i < method.size(); i++) {
			System.out.println(testingNrmcmsList.get(i) + ": NrTesting" + method.get(i));
		}

		System.out.println(method.size() + "\t" + testingNrmcmsList + " ");

		return testingNrmcmsList;

	}

	public static ArrayList<Integer> Wrmcms(ArrayList<Integer> testingNrArrayList) {
		ArrayList<Integer> Wr = new ArrayList<Integer>();
		for (int i = 0; i < testingNrArrayList.size(); i++) {

			Wr.add(testingNrArrayList.get(i) * 2);

		}
		return Wr;
	}

	public static ArrayList<Integer> Nrmcrms(ArrayList<String> method) {

		ArrayList<String> methodSet = new ArrayList<String>();
		ArrayList<String> recursivelist = new ArrayList<String>();
		HashMap<Integer, Integer> hashNrmcrms = new HashMap<Integer, Integer>();

		int TemporyNrmcrmsBucket = 0;
		int Nrmcrms = 0;
		int TemporyNrmcrmsLineBucket = 0;

		int bracketnumber = 0;

		int lineNumber = 0;
		String[] var;
		int methodLineNumber = 0;

		/* -----------------get method list------------------------- */
		for (int i = 0; i < method.size(); i++) {

			String lines = method.get(i);

			lineNumber = lineNumber + 1;

			// Check for class
			if (lines.contains("class")) {

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

					// no need
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

					}

					if (bracketnumber == 0) {
						break;
					}

				}

			}

		}

		/* for methods - remove recursive method names in regular method list */
		for (int i = 0; i < methodSet.size(); i++) {

			for (int j = 0; j < recursivelist.size(); j++) {
				if (methodSet.get(i).contains(recursivelist.get(j))) {
					System.out.println("method to remove:" + methodSet.get(i));
					methodSet.remove(i);
				}
			}
		}

		/*
		 * for (int i = 0; i < methodSet.size(); i++) {
		 * System.out.println(methodSet.get(i)); }
		 * 
		 * for (int i = 0; i < recursivelist.size(); i++) {
		 * System.out.println(recursivelist.get(i) + ": Recursive"); }
		 */
		/* for methods ends here */

		/*-----------------check for recursive method to regular method----------------------------*/
		for (int i = 0; i < method.size(); i++) {

			String lines = method.get(i);

			methodLineNumber = methodLineNumber + 1;

			// Check for class
			if (lines.contains("class")) {

			}
			// check for non methods
			else if (lines.contains("if") || lines.contains("switch") || lines.contains("catch")
					|| lines.contains("return") || lines.contains(";")) {

			}
			// check for main method
			else if (lines.contains("main") && lines.contains("(String[] args)")) {
				// do code in main regular method to check regular method call regular method

			}
			// check for methods
			else if (lines.contains("(")
					&& (lines.contains("public") || lines.contains("private") || lines.contains("protected"))) {
				// do code regular method to check regular method call regular method

				String[] sub = lines.split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();

				bracketnumber = 1;
				int line = 0;
				// System.out.println(method.size() + " " + x);

				for (int j = 0; j < recursivelist.size(); j++) {

					if (lines.contains(recursivelist.get(j))) {

						for (int b = i + 1; b < method.size(); b++) {

							String linesCHECK = method.get(b);
							System.out.println("TESTING METHODS" + linesCHECK);

							if (linesCHECK.contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (linesCHECK.contains("}")) {
								bracketnumber = bracketnumber - 1;
							}

							for (int j2 = 0; j2 < recursivelist.size(); j2++) {

								if (linesCHECK.contains(recursivelist.get(j2))) {
									// testing2.add(linesCHECK);
									System.out.println(b
											+ "PISSI MU PISSI MU PISSU PUSI MUUUUUUU.................HAAAAAAAAAAAAAAHAAAAAAAAAAAAAAAAAHAAAAAAA");

									var = linesCHECK.split(" ");
									for (int j3 = 0; j3 < var.length; j3++) {
										System.out.println(var[j3]);

										if (var[j3].contains(recursivelist.get(j2))) {

											if (var[j3].contains(x) || var[j3].contains(x.split(" ")[1])) {
											} else {

												Nrmcrms = Nrmcrms + 1;
											}

										}

									}
									TemporyNrmcrmsBucket = Nrmcrms;
									System.out.println("Tempory Nr Bucket value:\t" + TemporyNrmcrmsBucket);

									Nrmcrms = 0;
									TemporyNrmcrmsLineBucket = b+1;
									hashNrmcrms.put(TemporyNrmcrmsLineBucket, TemporyNrmcrmsBucket);

									break;
								}
								
							}

							i = b;

							if (bracketnumber == 0) {

								System.out.println("break");
								break;
							}

						}
					} // if for check method type ends here
				} // for ends here

			} // method identification ends here
			System.out.println(i);
		} // check for regular method ends here

		for (int i = 0; i < methodSet.size(); i++) {
			System.out.println(methodSet.get(i));
		}

		for (int i = 0; i < recursivelist.size(); i++) {
			System.out.println(recursivelist.get(i) + ": Recursive");
		}
		/* for methods ends here */

		int NUMBER = 0;
		ArrayList<Integer> testingNrmcrmsList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBER = NUMBER + 1;

			if (hashNrmcrms.containsKey(NUMBER) == true) {
				testingNrmcrmsList.add(hashNrmcrms.get(NUMBER));
				System.out.println(hashNrmcrms.get(NUMBER));
			} else {
				testingNrmcrmsList.add(0);
			}

		}

		for (int i = 0; i < method.size(); i++) {
			System.out.println(testingNrmcrmsList.get(i) + ": NrTesting" + method.get(i));
		}

		System.out.println(method.size() + "\t" + testingNrmcrmsList + " ");

		return testingNrmcrmsList;

	}

	public static ArrayList<Integer> Wrmcrms(ArrayList<Integer> testingNrmcrmsArrayList) {
		ArrayList<Integer> Wr = new ArrayList<Integer>();
		for (int i = 0; i < testingNrmcrmsArrayList.size(); i++) {

			Wr.add(testingNrmcrmsArrayList.get(i) * 2);

		}
		return Wr;
	}


public static ArrayList<String> Nrmcmd(ArrayList<String> list) {
	
	ArrayList<String> Nrmcmd = new ArrayList<String>();
	for (int i = 0; i < list.size(); i++) {
	
		Nrmcmd.add("");
		
	}
	
	return Nrmcmd;
}

}
