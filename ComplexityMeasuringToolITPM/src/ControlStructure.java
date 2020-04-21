/**
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;  
/**
 * @author Rashmika
 *
 */
public class ControlStructure {

	public static ArrayList<Integer> LineNum(ArrayList<String> list) {
		int lineNumber = 0;
		ArrayList<Integer> lineNum = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {

			lineNumber = lineNumber + 1;
			lineNum.add(lineNumber);
		}

		return lineNum;
	}

	public static ArrayList<Integer> Wtcs(ArrayList<String> method) {

		HashMap<Integer, Integer> hashWtcs = new HashMap<Integer, Integer>();

		int WtcsCounter = 0;
		int lineNumber = 0;
		int TemporyLineBycket = 0;
		int TemporyWtcsBycket = 0;
		// int totCtcCounter = 0;

		for (int i = 0; i < method.size(); i++) {

			lineNumber = lineNumber + 1;
			String scannedline = method.get(i);

			System.out.println(scannedline + lineNumber);

			if (scannedline.startsWith("System.out.println") || scannedline.contains("System.out.print")) {
				WtcsCounter = 0;
			}

			/* else { */

			if (scannedline.contains("for")  || scannedline.replaceAll("\\s", "").contains("do{")
					|| (scannedline.contains("while") && (scannedline.contains("(")) && 
							scannedline.replaceAll("\\s", "").contains("){"))) {
				System.out.println("for" + lineNumber);
				WtcsCounter = WtcsCounter + 3;

				TemporyLineBycket = lineNumber;
				TemporyWtcsBycket = WtcsCounter;
				WtcsCounter = 0;
				hashWtcs.put(TemporyLineBycket, TemporyWtcsBycket);

			}

			if ((scannedline.contains("if") || scannedline.contains("else if")) && (scannedline.contains("("))) {
				System.out.println("if" + lineNumber);
				WtcsCounter = WtcsCounter + 2;

				TemporyLineBycket = lineNumber;
				TemporyWtcsBycket = WtcsCounter;
				WtcsCounter = 0;
				hashWtcs.put(TemporyLineBycket, TemporyWtcsBycket);

			}

			if (scannedline.contains("switch") && (scannedline.contains("("))) {
				System.out.println("switch" + lineNumber);
				WtcsCounter = WtcsCounter + 2;

				TemporyLineBycket = lineNumber;
				TemporyWtcsBycket = WtcsCounter;
				WtcsCounter = 0;
				hashWtcs.put(TemporyLineBycket, TemporyWtcsBycket);

			}

			if (scannedline.contains("case") && (scannedline.contains(":"))) {
				System.out.println("case" + lineNumber);
				WtcsCounter = WtcsCounter + 1;

				TemporyLineBycket = lineNumber;
				TemporyWtcsBycket = WtcsCounter;
				WtcsCounter = 0;
				hashWtcs.put(TemporyLineBycket, TemporyWtcsBycket);

			}
			/* } */
		}
		/*------List of Wtcs------------*/
		int NUMBER = 0;

		ArrayList<Integer> testingWtcsList = new ArrayList<Integer>();
		for (int i1 = 0; i1 < method.size(); i1++) {

			NUMBER = NUMBER + 1;

			if (hashWtcs.containsKey(NUMBER) == true) {
				testingWtcsList.add(hashWtcs.get(NUMBER));
				System.out.println(hashWtcs.get(NUMBER));
			} else {
				testingWtcsList.add(0);
			}

		}

		// print all ljines with Wtcs value
		for (int i = 0; i < method.size(); i++) {
			System.out.println(
					"line number: " + i + "Line value:" + method.get(i) + "--------" + testingWtcsList.get(i) + "");
		}

		return testingWtcsList;

	}

	public static ArrayList<Integer> Nc(ArrayList<String> method) {
		HashMap<Integer, Integer> hashNc = new HashMap<Integer, Integer>();
		int NcCounter = 0;
		int lineNumber = 0;
		int TemporyLineBycket = 0;
		int TemporyNcBycket = 0;
		String[] var;

		boolean b3 = false;  
		
		
		for (int i = 0; i < method.size(); i++) {

			lineNumber = lineNumber + 1;
			String scannedline = method.get(i);

			if (scannedline.contains("for") || (scannedline.contains("while") && (scannedline.contains("(")) && 
					scannedline.replaceAll("\\s", "").contains("){")) 
					|| scannedline.replaceAll("\\s", "").contains("do{")) {

				
				
				
				
				
				
				var = scannedline.split(" ");
				for (int j3 = 0; j3 < var.length; j3++) {
					System.out.println(var[j3]);

					if (var[j3].contains("for") || var[j3].contains("while")  || scannedline.replaceAll("\\s", "").contains("do{")) {
						System.out.println(NcCounter + "\t:before");
						NcCounter = NcCounter + 1;
						System.out.println(NcCounter + "\t:after");
					}

				}

				TemporyLineBycket = lineNumber;
				TemporyNcBycket = NcCounter;
				NcCounter = 0;
				hashNc.put(TemporyLineBycket, TemporyNcBycket);

			}

			if (scannedline.contains("if") || scannedline.contains("else if")) {

				var = scannedline.split(" ");
				for (int j3 = 0; j3 < var.length; j3++) {
					System.out.println(var[j3]);

					if (var[j3].contains("if") || var[j3].contains("else if")) {
						System.out.println(NcCounter + "\t:before");
						NcCounter = NcCounter + 1;
						System.out.println(NcCounter + "\t:after");
					}

				}

				TemporyLineBycket = lineNumber;
				TemporyNcBycket = NcCounter;
				NcCounter = 0;
				hashNc.put(TemporyLineBycket, TemporyNcBycket);

			}

			if (scannedline.contains("switch")) {

				var = scannedline.split(" ");
				for (int j3 = 0; j3 < var.length; j3++) {
					System.out.println(var[j3]);

					if (var[j3].contains("switch")) {
						System.out.println(NcCounter + "\t:before");
						NcCounter = NcCounter + 1;
						System.out.println(NcCounter + "\t:after");
					}

				}

				TemporyLineBycket = lineNumber;
				TemporyNcBycket = NcCounter;
				NcCounter = 0;
				hashNc.put(TemporyLineBycket, TemporyNcBycket);

			}

			if (scannedline.contains("case")) {

				var = scannedline.split(" ");
				for (int j3 = 0; j3 < var.length; j3++) {
					System.out.println(var[j3]);

					if (var[j3].contains("case")) {
						System.out.println(NcCounter + "\t:before");
						NcCounter = NcCounter + 1;
						System.out.println(NcCounter + "\t:after");
					}

				}

				TemporyLineBycket = lineNumber;
				TemporyNcBycket = NcCounter;
				NcCounter = 0;
				hashNc.put(TemporyLineBycket, TemporyNcBycket);

			}

		}

		/*------List of Wtcs------------*/
		int NUMBER = 0;

		ArrayList<Integer> testingNcList = new ArrayList<Integer>();
		for (int i1 = 0; i1 < method.size(); i1++) {

			NUMBER = NUMBER + 1;

			if (hashNc.containsKey(NUMBER) == true) {
				testingNcList.add(hashNc.get(NUMBER));
				System.out.println(hashNc.get(NUMBER));
			} else {
				testingNcList.add(0);
			}

		}

		// print all lines with Nc value
		for (int i = 0; i < method.size(); i++) {
			System.out.println(
					"line number: " + i + "Line value:" + method.get(i) + "--------" + testingNcList.get(i) + "");
		}

		return testingNcList;

	}

	public static ArrayList<Integer> Ccspps(ArrayList<String> method, ArrayList<Integer> testingNcList,
			ArrayList<Integer> testingWtcsList) {

		/*------------nested loop------------------*/
		int CcsppLineNumber = 0;
		int lineNum = 0;
		int bracketnumberLevel1 = 0;
		int CcsppCount = 0;
		int CcsppCountNested = 0;

		int ignorelineLevel1 = 0;
		int ignorelineLevel2 = 0;

		int temBucket1 = 0;
		int temBucket2 = 0;

		HashMap<Integer, Integer> HashCcspp = new HashMap<Integer, Integer>();

		for (int i = 0; i < method.size(); i++) {

			lineNum = lineNum + 1;
			String line = method.get(i);

			/*
			 * if(line.contains("//") || line.contains("/*")) { System.out.println("avoid" +
			 * line); }
			 */

			// check nested loop
			if (line.contains("for")) {
				ignorelineLevel1 = i;
				CcsppCount = CcsppCount + (testingNcList.get(i) * testingWtcsList.get(i));
				for (int b = i; b < method.size(); b++) {

					if (method.get(b).contains("{") && method.get(b).contains("}")) {
						bracketnumberLevel1 = bracketnumberLevel1 + 0;
					}

					else if (method.get(b).contains("{")) {
						bracketnumberLevel1 = bracketnumberLevel1 + 1;
					} else if (method.get(b).contains("}")) {
						bracketnumberLevel1 = bracketnumberLevel1 - 1;
					}

					// for testing line
					System.out.println(bracketnumberLevel1 + "\t" + "line value: " + method.get(b));

					if (method.get(b).contains("for")) {
						if (b != ignorelineLevel1) {
							HashCcspp.put(b + 1, CcsppCount);
							System.out.println("inside");

							int bracketnumberLevel2 = 0;
							CcsppCountNested = CcsppCount;
							CcsppCountNested = CcsppCountNested + (testingNcList.get(b) * testingWtcsList.get(b));
							for (int j = b; j < method.size(); j++) {

								if (method.get(j).contains("{") && method.get(j).contains("}")) {
									bracketnumberLevel1 = bracketnumberLevel1 + 0;
								} else if (method.get(j).contains("{")) {
									bracketnumberLevel2 = bracketnumberLevel2 + 1;
								} else if (method.get(j).contains("}")) {
									bracketnumberLevel2 = bracketnumberLevel2 - 1;
								}

								ignorelineLevel2 = b;
								if (method.get(j).contains("for")) {
									if (j != ignorelineLevel2) {
										HashCcspp.put(j + 1, CcsppCountNested);
										System.out.println("inside2" + CcsppCountNested);

									}
								}

								if (bracketnumberLevel2 == 0) {
									System.out.println("line:\t" + method.get(j) + "lineNumber(level2):\t" + j + "Nc:\t"
											+ testingNcList.get(j) + "Wtcs:\t" + testingWtcsList.get(j));
									System.out.println("break(level2)");

									b = j - 1;
									CcsppCountNested = 0;
									break;
								}

							}
							// second nested checking
						}

					}

					// line breaker for end of the block
					if (bracketnumberLevel1 == 0) {
						System.out.println("line:\t" + method.get(b) + "lineNumber:\t" + b + "Nc:\t"
								+ testingNcList.get(b) + "Wtcs:\t" + testingWtcsList.get(b));
						System.out.println("break");
						CcsppCount = 0;
						i = b;
						break;
					}
				} // loop after outer most checking ends here
			} // outer most loop ends here

			// ckeck conditional nested loop

		} // loop ends here

		System.out.println("CcsppLineNumber:\t" + CcsppLineNumber + "lineNum:\t" + lineNum + "bracketnumberLevel1:\t"
				+ bracketnumberLevel1 + "CcsppCount:\t" + CcsppCount + "CcsppCountNested:\t" + CcsppCountNested
				+ "ignorelineLevel1:\t" + ignorelineLevel1 + "ignorelineLevel2:\t" + ignorelineLevel2);

		lineNum = 0;
		ignorelineLevel1 = 0;
		ignorelineLevel2 = 0;

		System.out.println("CcsppLineNumber:\t" + CcsppLineNumber + "lineNum:\t" + lineNum + "bracketnumberLevel1:\t"
				+ bracketnumberLevel1 + "CcsppCount:\t" + CcsppCount + "CcsppCountNested:\t" + CcsppCountNested
				+ "ignorelineLevel1:\t" + ignorelineLevel1 + "ignorelineLevel2:\t" + ignorelineLevel2 + temBucket1
				+ temBucket2);

		lineNum = 0;
		for (int i = 0; i < method.size(); i++) {

			lineNum = lineNum + 1;
			String line = method.get(i);

			if (line.contains("if") && line.contains("(")) {
				if (line.contains("else")) {
					System.out.println("else if part");
				} else {
					ignorelineLevel1 = i;
					CcsppCount = CcsppCount + (testingNcList.get(i) * testingWtcsList.get(i));

					temBucket1 = bracketnumberLevel1;

					for (int b = i; b < method.size(); b++) {

						if (method.get(b).contains("{") && method.get(b).contains("}")) {
							bracketnumberLevel1 = bracketnumberLevel1 + 0;
						}

						else if (method.get(b).contains("{")) {
							bracketnumberLevel1 = bracketnumberLevel1 + 1;
						} else if (method.get(b).contains("}")) {
							bracketnumberLevel1 = bracketnumberLevel1 - 1;
						}

						// if testing line
						System.out.println(bracketnumberLevel1 + "\t" + "line value: " + method.get(b));

						if (method.get(b).contains("if") && method.get(b).contains("(")) {
							if (method.get(b).contains("else")) {
								System.out.println("else if part2");
							} else {
								if (b != ignorelineLevel1) {
									HashCcspp.put(b + 1, CcsppCount);
									System.out.println("inside");

									ignorelineLevel2 = b;

									int bracketnumberLevel2 = 0;
									CcsppCountNested = CcsppCount;
									CcsppCountNested = CcsppCountNested
											+ (testingNcList.get(b) * testingWtcsList.get(b));
									for (int j = b; j < method.size(); j++) {

										if (method.get(j).contains("{") && method.get(j).contains("}")) {
											bracketnumberLevel2 = bracketnumberLevel2 + 0;
										} else if (method.get(j).contains("{")) {
											bracketnumberLevel2 = bracketnumberLevel2 + 1;
										} else if (method.get(j).contains("}")) {
											bracketnumberLevel2 = bracketnumberLevel2 - 1;
										}

										if (method.get(j).contains("if") && method.get(j).contains("(")) {
											if (method.get(j).contains("else")) {
												System.out.println("else if part2");
											} else {
												if (j != ignorelineLevel2) {
													HashCcspp.put(j + 1, CcsppCountNested);
													System.out.println("inside2" + CcsppCountNested);

												}
											}
										}

										if (bracketnumberLevel2 == temBucket2) {
											System.out.println("line:\t" + method.get(j) + "lineNumber(level2):\t" + j
													+ "Nc:\t" + testingNcList.get(j) + "Wtcs:\t"
													+ testingWtcsList.get(j));
											System.out.println("break(level2)");

											b = j;
											CcsppCountNested = 0;
											break;
										}

									}
									// second nested checking
								}
							}

						}

						// line breaker for end of the block
						if (bracketnumberLevel1 == temBucket1) {
							/*
							 * System.out.println("line:\t" + method.get(b) + "lineNumber:\t" + b + "Nc:\t"
							 * + testingNcList.get(b) + "Wtcs:\t" + testingWtcsList.get(b));
							 */
							System.out.println("break");
							CcsppCount = 0;
							i = b;
							break;
						}
					} // loop after outer most checking ends here
				} // outer most loop ends here

			}

		}

		lineNum = 0;
		for (int i = 0; i < method.size(); i++) {

			lineNum = lineNum + 1;
			String line = method.get(i);

			if (line.contains("switch")) {

				ignorelineLevel1 = i;
				CcsppCount = CcsppCount + (testingNcList.get(i) * testingWtcsList.get(i));

				temBucket1 = bracketnumberLevel1;

				for (int b = i; b < method.size(); b++) {

					if (method.get(b).contains("{") && method.get(b).contains("}")) {
						bracketnumberLevel1 = bracketnumberLevel1 + 0;
					}

					else if (method.get(b).contains("{")) {
						bracketnumberLevel1 = bracketnumberLevel1 + 1;
					} else if (method.get(b).contains("}")) {
						bracketnumberLevel1 = bracketnumberLevel1 - 1;
					}

					// if testing line
					System.out.println(bracketnumberLevel1 + "\t" + "line value: " + method.get(b));

					if (method.get(b).contains("switch")) {

						if (b != ignorelineLevel1) {
							HashCcspp.put(b + 1, CcsppCount);
							System.out.println("inside");

							ignorelineLevel2 = b;

							int bracketnumberLevel2 = 0;
							CcsppCountNested = CcsppCount;
							CcsppCountNested = CcsppCountNested + (testingNcList.get(b) * testingWtcsList.get(b));
							for (int j = b; j < method.size(); j++) {

								if (method.get(j).contains("{") && method.get(j).contains("}")) {
									bracketnumberLevel2 = bracketnumberLevel2 + 0;
								} else if (method.get(j).contains("{")) {
									bracketnumberLevel2 = bracketnumberLevel2 + 1;
								} else if (method.get(j).contains("}")) {
									bracketnumberLevel2 = bracketnumberLevel2 - 1;
								}

								if (method.get(j).contains("switch")) {

									if (j != ignorelineLevel2) {
										HashCcspp.put(j + 1, CcsppCountNested);
										System.out.println("inside2" + CcsppCountNested);

									}

								}

								if (bracketnumberLevel2 == temBucket2) {
									System.out.println("line:\t" + method.get(j) + "lineNumber(level2):\t" + j + "Nc:\t"
											+ testingNcList.get(j) + "Wtcs:\t" + testingWtcsList.get(j));
									System.out.println("break(level2)");

									b = j;
									CcsppCountNested = 0;
									break;
								}

							}
							// second nested checking
						}
					}

					// line breaker for end of the block
					if (bracketnumberLevel1 == temBucket1) {
						System.out.println("line:\t" + method.get(b) + "lineNumber:\t" + b + "Nc:\t"
								+ testingNcList.get(b) + "Wtcs:\t" + testingWtcsList.get(b));
						System.out.println("break");
						CcsppCount = 0;
						i = b;
						break;
					}
				} // loop after outer most checking ends here
			}

		}

		/*----------Ccspp list--------------*/
		int NUMBERCcspp = 0;
		ArrayList<Integer> testingCcsppList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			NUMBERCcspp = NUMBERCcspp + 1;

			if (HashCcspp.containsKey(NUMBERCcspp) == true) {
				testingCcsppList.add(HashCcspp.get(NUMBERCcspp));
				System.out.println(HashCcspp.get(NUMBERCcspp));
			} else {
				testingCcsppList.add(0);
			}

		}

		/*
		 * for (int i = 0; i < method.size(); i++) { System.out.println(
		 * testingCcsppList.get(i) + ": CcsppTesting" + method.get(i) + ":\t" +
		 * testingCcsppList.get(i)); }
		 * 
		 * System.out.println(method.size() + "\t" + testingCcsppList + " ");
		 */

		return testingCcsppList;

	}

	public static ArrayList<Integer> Ccs(ArrayList<String> method, ArrayList<Integer> testingNcList,
			ArrayList<Integer> testingWtcsList, ArrayList<Integer> testingCcsppList) {

		int Ccs = 0;
		ArrayList<Integer> TestingCcsList = new ArrayList<Integer>();
		for (int i = 0; i < method.size(); i++) {

			Ccs = testingCcsppList.get(i) + testingNcList.get(i) + testingWtcsList.get(i);
			TestingCcsList.add(Ccs);
		}

		return TestingCcsList;
	}

}
