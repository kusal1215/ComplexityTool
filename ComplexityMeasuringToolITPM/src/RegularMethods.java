/**
 * 
 */


import java.util.ArrayList;
/*import java.util.HashMap;*/
import java.util.HashMap;

/**
 * @author oshadi
 *
 */
public class RegularMethods {

	public static ArrayList<Integer> Nmcms(ArrayList<String> method) {

		ArrayList<String> methodSet = new ArrayList<String>();
		ArrayList<String> recursivelist = new ArrayList<String>();
		HashMap<Integer, Integer> hashNmcms = new HashMap<Integer, Integer>();
		
		
		
		
		int TemporyNmcmsBucket = 0;
		int Nmcms = 0;
		int TemporyNmcmsLineBucket = 0;
		
		
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

		/*-----------------check for regular method to regular method----------------------------*/
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

				
				bracketnumber = 1;
				int line = 0;
				
				

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

								if (var[j3].contains(methodSet.get(j2))) {
									Nmcms = Nmcms + 1;

								}

							}
							TemporyNmcmsBucket = Nmcms;
							System.out.println("Tempory Nr Bucket value:\t" + TemporyNmcmsBucket);

							Nmcms = 0;
							TemporyNmcmsLineBucket = b;
							hashNmcms.put(TemporyNmcmsLineBucket, TemporyNmcmsBucket);

							break;
						}
					}

					i = b;

					if (bracketnumber == 0) {

						System.out.println("break");
						break;
					}

				}
			
				
				
				
			}
			// check for methods
			else if (lines.contains("(")
					&& (lines.contains("public") || lines.contains("private") || lines.contains("protected"))) {
				// do code regular method to check regular method call regular method

				bracketnumber = 1;
				int line = 0;
				// System.out.println(method.size() + " " + x);

				for (int j = 0; j < methodSet.size(); j++) {

					if (lines.contains(methodSet.get(j))) {

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

										if (var[j3].contains(methodSet.get(j2)) || var[j3].contains(methodSet.get(j2).split(" ")[1])) {
											Nmcms = Nmcms + 1;

										}

									}
									TemporyNmcmsBucket = Nmcms;
									System.out.println("Tempory Nr Bucket value:\t" + TemporyNmcmsBucket);
									
									
									
									
									Nmcms = 0;
									TemporyNmcmsLineBucket = b;
									hashNmcms.put(TemporyNmcmsLineBucket, TemporyNmcmsBucket);
									
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
		ArrayList<Integer> testingNmcmsList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBER = NUMBER + 1;

			if (hashNmcms.containsKey(NUMBER) == true) {
				testingNmcmsList.add(hashNmcms.get(NUMBER));
				System.out.println(hashNmcms.get(NUMBER));
			} else {
				testingNmcmsList.add(0);
			}

		}
		
		for (int i = 0; i < method.size(); i++) {
			System.out.println(testingNmcmsList.get(i) + ": NrTesting" + method.get(i));
		}

		System.out.println(method.size() + "\t" + testingNmcmsList + " ");

		

		return testingNmcmsList;

	}
	
	public static ArrayList<Integer> Wmcms(ArrayList<Integer> testingNrArrayList) {
		ArrayList<Integer> Wr = new ArrayList<Integer>();
		for (int i = 0; i < testingNrArrayList.size(); i++) {

			Wr.add(testingNrArrayList.get(i) * 2);

		}
		return Wr;
	}



	public static ArrayList<Integer> Nmcrms(ArrayList<String> method) {

		ArrayList<String> methodSet = new ArrayList<String>();
		ArrayList<String> recursivelist = new ArrayList<String>();
		HashMap<Integer, Integer> hashNmcrms = new HashMap<Integer, Integer>();
		
		
		
		
		int TemporyNmcrmsBucket = 0;
		int Nmcrms = 0;
		int TemporyNmcrmsLineBucket = 0;
		
		
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

		/*-----------------check for regular method to recursive method----------------------------*/
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

				
				bracketnumber = 1;
				int line = 0;

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
									Nmcrms = Nmcrms + 1;

								}

							}
							TemporyNmcrmsBucket = Nmcrms;
							System.out.println("Tempory Nr Bucket value:\t" + TemporyNmcrmsBucket);

							Nmcrms = 0;
							TemporyNmcrmsLineBucket = b + 1;
							hashNmcrms.put(TemporyNmcrmsLineBucket, TemporyNmcrmsBucket);
							System.out.println(Nmcrms);
							break;
						}
					}

					i = b;

					if (bracketnumber == 0) {

						System.out.println("break");
						break;
					}

				}

				
				
				
			}
			// check for methods
			else if (lines.contains("(")
					&& (lines.contains("public") || lines.contains("private") || lines.contains("protected"))) {
				// do code regular method to check regular method call regular method

				bracketnumber = 1;
				int line = 0;
				// System.out.println(method.size() + " " + x);

				for (int j = 0; j < methodSet.size(); j++) {

					if (lines.contains(methodSet.get(j))) {

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

										if (var[j3].contains(recursivelist.get(j2))){
										System.out.println(Nmcrms+"\t:before");
										Nmcrms = Nmcrms + 1;
										System.out.println(Nmcrms+"\t:after");
									 }

									}
									TemporyNmcrmsBucket = Nmcrms;
									System.out.println("Tempory Nr Bucket value:\t" + TemporyNmcrmsBucket);

									Nmcrms = 0;
									TemporyNmcrmsLineBucket = b + 1;
									hashNmcrms.put(TemporyNmcrmsLineBucket, TemporyNmcrmsBucket);
									System.out.println("BREAK ++++++++++++++++++++");
									break;
								}
							}
							System.out.println("i value:" + i);
							i = b;
							System.out.println("b value:" + b);
							if (bracketnumber == 0) {

								System.out.println("break" + i);
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
		ArrayList<Integer> testingNmcrmsList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBER = NUMBER + 1;

			if (hashNmcrms.containsKey(NUMBER) == true) {
				testingNmcrmsList.add(hashNmcrms.get(NUMBER));
				System.out.println(hashNmcrms.get(NUMBER));
			} else {
				testingNmcrmsList.add(0);
			}

		}
		
		for (int i = 0; i < method.size(); i++) {
			System.out.println(testingNmcrmsList.get(i) + ": NrTesting" + method.get(i));
		}

		System.out.println(method.size() + "\t" + testingNmcrmsList + " ");

		

		return testingNmcrmsList;

	}
	
	public static ArrayList<Integer> Wmcrms(ArrayList<Integer> testingNrArrayList) {
		ArrayList<Integer> Wr = new ArrayList<Integer>();
		for (int i = 0; i < testingNrArrayList.size(); i++) {

			Wr.add(testingNrArrayList.get(i) * 2);

		}
		return Wr;
	}



}
