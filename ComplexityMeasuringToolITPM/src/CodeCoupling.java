import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Coupling;
import model.GlobalSet;
import model.Recursive;
import model.Regular;

/**
 * 
 */

/**
 * @author oshadi
 *
 */
public class CodeCoupling {
	
	public static ArrayList<Recursive> Recursive(ArrayList<String> lines) {

		// variable-1(first loop)
		ArrayList<Recursive> RecursiveModelList = new ArrayList<Recursive>();
		// variable-2(first loop)
		String method = "";
		// variable-3 (second loop)
		int bracketnumber = 0;

		for (int i = 0; i < lines.size(); i++) {

			Recursive recursive = new Recursive();

			/* -----------------get Recursive method list------------------------- */
			// Check for class
			if (lines.get(i).contains("class")) {

			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				String[] sub = lines.get(i).split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();

				// Assign method name to method variable
				if (x.split(" ").length > 1) {
					method = x.split(" ")[1];
				} else {
					method = x;
				}

				// loop the function only
				for (int j = i; j <= lines.size(); j++) {
					/* System.out.println(lines.get(j)); */
					// Check for brackets
					if (lines.get(j).contains("{") && lines.get(j).contains("}")) {
						bracketnumber = bracketnumber + 0;
					} else if (lines.get(j).contains("{")) {
						bracketnumber = bracketnumber + 1;
					} else if (lines.get(j).contains("}")) {
						bracketnumber = bracketnumber - 1;
					}

					if (bracketnumber == 0) {
						break;
					}

					// check whether line includes recursive call

					if (j == i) {

					} else {

						if (lines.get(j).contains(method)) {

							recursive.setRecursiveName(method);

							RecursiveModelList.add(recursive);

						}

					}
				}

			}

		}

		return RecursiveModelList;
	}

	public static ArrayList<Regular> Regular(ArrayList<String> lines) {

		// variable-1(first loop)
		ArrayList<Regular> RegularModelList = new ArrayList<Regular>();
		// variable-2(first loop)
		String method = "";

		// variable-4
		ArrayList<Recursive> RecursiveModelList = new ArrayList<Recursive>();
		RecursiveModelList = Recursive(lines);
		// variable-5
		ArrayList<String> recursive = new ArrayList<String>();

		for (int i = 0; i < RecursiveModelList.size(); i++) {

			System.out.println(RecursiveModelList.get(i).getRecursiveName());
			recursive.add(RecursiveModelList.get(i).getRecursiveName());

		}

		for (int i = 0; i < lines.size(); i++) {

			Regular regular = new Regular();

			/* -----------------get Recursive method list------------------------- */
			// Check for class
			if (lines.get(i).contains("class")) {

			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				String[] sub = lines.get(i).split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();

				// Assign method name to method variable
				if (x.split(" ").length > 1) {
					regular.setRegularName(x.split(" ")[1]);
					RegularModelList.add(regular);
				} else {
					regular.setRegularName(x);
					RegularModelList.add(regular);
				}
				System.out.println("method:" + method);

			}

		}

		/* Remove recursive methods in the regularSet */
		for (int i = 0; i < RegularModelList.size(); i++) {

			for (int j = 0; j < RecursiveModelList.size(); j++) {
				if (RegularModelList.get(i).getRegularName().contains(RecursiveModelList.get(j).getRecursiveName())) {
					System.out.println("method to remove:" + RegularModelList.get(i));
					RegularModelList.remove(i);
				}
			}
		}

		return RegularModelList;
	}

	public static ArrayList<GlobalSet> GlobalVariable(ArrayList<String> lines) {

		// variable-2
		int bracketnumber = 0;
		// variable-3
		ArrayList<GlobalSet> GlobalSetList = new ArrayList<GlobalSet>();

		GlobalSet GlobalSet = new GlobalSet();

		for (int i = 0; i < lines.size(); i++) {

			if (lines.get(i).contains("class")) {

				for (int j = i; j < lines.size(); j++) {

					if (lines.get(j).contains("{") && lines.get(j).contains("}")) {
						bracketnumber = bracketnumber + 0;
					} else if (lines.get(j).contains("{")) {
						bracketnumber = bracketnumber + 1;
					} else if (lines.get(j).contains("}")) {
						bracketnumber = bracketnumber - 1;
					}
					System.out.println("bracket: " + bracketnumber + lines.get(j));

					if (bracketnumber == 1) {

						if (lines.get(j).contains("=") && lines.get(j).contains(";")) {
							if (lines.get(j).contains("main ") || lines.get(j).contains("class ")
									|| lines.get(j).contains("if ") || lines.get(j).contains("switch ")
									|| lines.get(j).contains("catch ") || lines.get(j).contains("return ")
									|| lines.get(j).contains("private") || lines.get(j).contains("protected")) {

								System.out.println(lines.get(j) + "..........................lines");

							} else if (lines.get(j).contains("byte") || lines.get(j).contains("short")
									|| lines.get(j).contains("int") || lines.get(j).contains("long")
									|| lines.get(j).contains("float") || lines.get(j).contains("double")
									|| lines.get(j).contains("char") || lines.get(j).contains("boolean")) {

								String[] sub = lines.get(j).split(" ");

								if (lines.get(j).contains("public ") && lines.get(j).contains("static ")) {
									GlobalSet.setGlobalVariable(sub[3]);
								} else if (lines.get(j).contains("public ")) {
									GlobalSet.setGlobalVariable(sub[2]);
								} else {
									GlobalSet.setGlobalVariable(sub[1]);
								}
								System.out.println(lines.get(j));
								GlobalSetList.add(GlobalSet);
							}

						}

					}

				}

			}
		}

		return GlobalSetList;

	}

	public static ArrayList<Coupling> Coupling(ArrayList<String> lines) {

		// variable-1
		int bracketnumber = 0;
		// variable-4
		int lineNum = 0;
		// variable-5
		int bucket = 0;
		// variable - 6
		Map<Integer, Integer> mapNr = new HashMap<Integer, Integer>();
		// variable - 8
		Map<Integer, Integer> mapNmcms = new HashMap<Integer, Integer>();
		// variable - 9
		Map<Integer, Integer> mapNmcrms = new HashMap<Integer, Integer>();
		// variable - 14
		Map<Integer, Integer> mapNrmrgvs = new HashMap<Integer, Integer>();
		// variable - 10
		String method = "";
		// variable - 11
		Map<Integer, Integer> mapNrmcrms = new HashMap<Integer, Integer>();
		// variable - 12
		Map<Integer, Integer> mapNrmcms = new HashMap<Integer, Integer>();

		// variable-7
		ArrayList<Coupling> couplingList = new ArrayList<Coupling>();

		/*
		 * 
		 * calling methods
		 * 
		 */
		// variable-2
		ArrayList<Recursive> RecursiveModelList = new ArrayList<Recursive>();
		RecursiveModelList = Recursive(lines);

		// variable-3
		ArrayList<Regular> RegularModelList = new ArrayList<Regular>();
		RegularModelList = Regular(lines);

		// variable-13
		ArrayList<GlobalSet> globalList = new ArrayList<GlobalSet>();

		/*
		 * 
		 * 
		 * -----------------get Nr list-------------------------
		 *
		 *
		 **/
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {

			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				/*
				 * String[] sub = lines.get(i).split("\\("); String x = sub[0].replace("public",
				 * "").replace("private", "").replace("protected", "") .replace("static",
				 * "").replace("final", "").trim();
				 */
				for (int j = 0; j < RecursiveModelList.size(); j++) {

					if (lines.get(i).contains(RecursiveModelList.get(j).getRecursiveName())) {
						// loop the function only
						for (int j2 = i; j2 <= lines.size(); j2++) {

							/* System.out.println(lines.get(j2)); */

							// Check for brackets
							if (lines.get(j2).contains("{") && lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(j2).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}

							// break the loop if bracket = 0
							if (bracketnumber == 0) {

								i = j2;// Assign j2 value for outer loop variable

								break;
							}

							// Check Nr
							if (lines.get(j2 + 1).contains(RecursiveModelList.get(j).getRecursiveName())) {

								/* String name = RecursiveModelList.get(j).getRecursiveName(); */

								String[] var = lines.get(j2 + 1).split(" ");
								/* System.out.println(var.length); */

								for (int k = 0; k < var.length; k++) {
									/* System.out.println(var[k]); */

									if (var[k].contains(RecursiveModelList.get(j).getRecursiveName())) {
										/*
										 * System.out.println(
										 * "..............................................................................."
										 * );
										 */
										bucket = bucket + 1;
									}
								}

								mapNr.put((j2 + 1), bucket);
								/* System.out.println("inside: " + lines.get(j2 + 1)); */
								bucket = 0;
							} // Check Nr Ends here........

						}
						break;
					}

				}

			}

		}

		/*
		 * 
		 * -----------------get Nmcms list-------------------------
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {

			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if ((lines.get(i).contains("main") && lines.get(i).contains("(String[] args)"))
					|| lines.get(i).contains("(") && (lines.get(i).contains("public")
							|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				for (int k = 0; k < RegularModelList.size(); k++) {

					if (lines.get(i).contains(RegularModelList.get(k).getRegularName())
							|| lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

						/* System.out.println("nothing is impossible" + lines.get(i)); */

						// loop the function
						for (int k2 = i; k2 < lines.size(); k2++) {

							// check for brackets
							if (lines.get(k2).contains("{") && lines.get(k2).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(k2).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(k2).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}
							// System.out.println(lines.get(k2) + "nothing is impossible" + bracketnumber);
							// break the loop if bracket = 0
							if (bracketnumber == 0) {

								i = k2;// Assign j2 value for outer loop variable

								/* System.out.println(lines.get(k2 + 1) + "nothing is impossible"); */
								break;
							}

							for (int l = 0; l < RegularModelList.size(); l++) {

								/* System.out.println(RegularModelList.get(l).getRegularName()); */

								// ......................................

								// checkNmcms
								if (lines.get(k2 + 1).contains(RegularModelList.get(l).getRegularName())) {

									String[] var = lines.get(k2 + 1).split(" ");
									/* System.out.println(var.length); */

									for (int j = 0; j < var.length; j++) {

										/* System.out.println(var[j] + "var[j] value............................"); */

										if (var[j].contains(RegularModelList.get(l).getRegularName())) {
											/*
											 * System.out.println(
											 * "..............................................................................."
											 * );
											 */
											bucket = bucket + 1;
										}

									}
									/* System.out.println(bucket + "?????" + lines.get(k2 + 1)); */
									mapNmcms.put((k2 + 1), bucket);
									/* System.out.println("inside: " + lines.get(j2 + 1)); */
									bucket = 0;

								} // check Nmcms ends here............

								// .............................................

							}

						}

						break;

					}

				}
			}
		}

		/*
		 * 
		 * -----------------get Nmcrms list-------------------------
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {

			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if ((lines.get(i).contains("main") && lines.get(i).contains("(String[] args)"))
					|| lines.get(i).contains("(") && (lines.get(i).contains("public")
							|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				for (int j = 0; j < RegularModelList.size(); j++) {

					if (lines.get(i).contains(RegularModelList.get(j).getRegularName())
							|| lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

						// loop the function
						for (int j2 = i; j2 < lines.size(); j2++) {

							// check for brackets
							if (lines.get(j2).contains("{") && lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(j2).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}
							/* System.out.println(bracketnumber + ";;;;" + lines.get(j2)); */
							if (bracketnumber == 0) {

								i = j2;// Assign j2 value for outer loop variable

								/* System.out.println(lines.get(k2 + 1) + "nothing is impossible"); */
								break;
							}

							for (int k = 0; k < RecursiveModelList.size(); k++) {

								/*
								 * System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
								 * RecursiveModelList.get(k).getRecursiveName());
								 */

								// checkNmcrms
								if (lines.get(j2 + 1).contains(RecursiveModelList.get(k).getRecursiveName())) {

									/*
									 * System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
									 * RecursiveModelList.get(k).getRecursiveName());
									 */

									String[] var = lines.get(j2 + 1).split(" ");
									/* System.out.println(var.length); */

									for (int l = 0; l < var.length; l++) {
										/*
										 * System.out.println( var[l] +
										 * "var[l] values@@@@@@@@@@@@@@@@@@............................");
										 */

										if (var[l].contains(RecursiveModelList.get(k).getRecursiveName())) {
											/*
											 * System.out.println(
											 * "..............................................................................."
											 * );
											 */
											bucket = bucket + 1;

										}
									}

									mapNmcrms.put((j2 + 1), bucket);
									/* System.out.println("inside: " + lines.get(j2 + 1)); */
									bucket = 0;

								} // check Nmcrms ends here............

							}

						}
						break;

					}

				}
			}

		}
		/*
		 * 
		 * -----------------get Nrmcrms list-------------------------
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {
			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				String[] sub = lines.get(i).split("\\(");
				String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
						.replace("static", "").replace("final", "").trim();

				// Assign method name to method variable
				if (x.split(" ").length > 1) {
					method = x.split(" ")[1];
				} else {
					method = x;
				}
				/* System.out.println(method); */

				for (int j = 0; j < RecursiveModelList.size(); j++) {

					if (lines.get(i).contains(RecursiveModelList.get(j).getRecursiveName())) {

						// loop the function
						for (int j2 = i; j2 < lines.size(); j2++) {

							// check for brackets
							if (lines.get(j2).contains("{") && lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(j2).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(j2).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}
							/* System.out.println(bracketnumber + ";;;;" + lines.get(j2)); */
							if (bracketnumber == 0) {

								i = j2;// Assign j2 value for outer loop variable

								/* System.out.println(lines.get(j2 + 1) + "nothing is impossible"); */
								break;
							}

							for (int k = 0; k < RecursiveModelList.size(); k++) {

								if (lines.get(j2 + 1).contains(RecursiveModelList.get(k).getRecursiveName())) {

									if (RecursiveModelList.get(k).getRecursiveName().contains(method)) {

									} else {

										/*
										 * System.out.println("line recursive :::" + lines.get(j2+1)+ " //// "+method );
										 */

										String[] var = lines.get(j2 + 1).split(" ");
										/* System.out.println(var.length); */

										for (int l = 0; l < var.length; l++) {
											/*
											 * System.out.println( var[l] +
											 * "var[l] values@@@@@@@@@@@@@@@@@@............................");
											 */

											if (var[l].contains(RecursiveModelList.get(k).getRecursiveName())) {
												/*
												 * System.out.println(
												 * "..............................................................................."
												 * );
												 */
												bucket = bucket + 1;

											}
										}

										mapNrmcrms.put((j2 + 1), bucket);
										/*
										 * System.out.println("inside/inside/inside/inside/inside/: " + lines.get(j2 +
										 * 1));
										 */
										bucket = 0;

									}

								} // Nrmcrms ends here........
							}

						}
						break;

					}

				}

			}
		}

		/*
		 * 
		 * -----------------get Nrmcms list-------------------------
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {
			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				for (int j = 0; j < RecursiveModelList.size(); j++) {

					if (lines.get(i).contains(RecursiveModelList.get(j).getRecursiveName())) {

						// loop the function
						for (int j3 = i; j3 < lines.size(); j3++) {

							// check for brackets
							if (lines.get(j3).contains("{") && lines.get(j3).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(j3).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(j3).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}
							/* System.out.println(bracketnumber + ";;;;" + lines.get(j2)); */
							if (bracketnumber == 0) {

								i = j3;// Assign j2 value for outer loop variable

								/* System.out.println(lines.get(j2 + 1) + "nothing is impossible"); */
								break;
							}

							for (int k = 0; k < RegularModelList.size(); k++) {

								if (lines.get(j3 + 1).contains(RegularModelList.get(k).getRegularName())) {

									// -------------------------------

									String[] var = lines.get(j3 + 1).split(" ");
									/* System.out.println(var.length); */

									for (int l = 0; l < var.length; l++) {
										/*
										 * System.out.println( var[l] +
										 * "var[l] values@@@@@@@@@@@@@@@@@@............................");
										 */

										if (var[l].contains(RegularModelList.get(k).getRegularName())) {
											/*
											 * System.out.println(
											 * "..............................................................................."
											 * );
											 */
											bucket = bucket + 1;

										}
									}

									mapNrmcms.put((j3 + 1), bucket);
									/*
									 * System.out.println("inside/inside/inside/inside/inside/: " + lines.get(j2 +
									 * 1));
									 */
									bucket = 0;

									// ---------------------------------
								}
							}

						}

					}
				}

			}
		}

		/*
		 * System.out.println("\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nn\\n\n\n\n");
		 * System.out.println(
		 * "Nrmrgvs..................................................................................."
		 * );
		 */

		/*
		 * 
		 * -----------------get Nrmrgvs list-------------------------
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			// Check for class
			if (lines.get(i).contains("class")) {
			}

			// check for methods
			else if (lines.get(i).contains("if") || lines.get(i).contains("switch") || lines.get(i).contains("catch")
					|| lines.get(i).contains("return") || lines.get(i).contains(";")) {

			} else if (lines.get(i).contains("main") && lines.get(i).contains("(String[] args)")) {

			} else if (lines.get(i).contains("(") && (lines.get(i).contains("public")
					|| lines.get(i).contains("private") || lines.get(i).contains("protected"))) {

				for (int j = 0; j < RecursiveModelList.size(); j++) {

					if (lines.get(i).contains(RecursiveModelList.get(j).getRecursiveName())) {

						// loop the function
						for (int j3 = i; j3 < lines.size(); j3++) {

							// check for brackets
							if (lines.get(j3).contains("{") && lines.get(j3).contains("}")) {
								bracketnumber = bracketnumber + 0;
							} else if (lines.get(j3).contains("{")) {
								bracketnumber = bracketnumber + 1;
							} else if (lines.get(j3).contains("}")) {
								bracketnumber = bracketnumber - 1;
							}
							/* System.out.println(bracketnumber + ";;;;" + lines.get(j2)); */
							if (bracketnumber == 0) {

								i = j3;// Assign j2 value for outer loop variable

								/* System.out.println(lines.get(j2 + 1) + "nothing is impossible"); */
								break;
							}

							for (int k = 0; k < globalList.size(); k++) {
								/*
								 * System.out.println("\n\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nn\\n\n\n\n");
								 * System.out.println(globalList.get(k));
								 */

								if (lines.get(j3 + 1).contains(globalList.get(k).getGlobalVariable())) {

									String[] var = lines.get(j3 + 1).split(" ");
									/* System.out.println(var.length); */

									for (int l = 0; l < var.length; l++) {
										/*
										 * System.out.println( var[l] +
										 * "var[l] values@@@@@@@@@@@@@@@@@@............................");
										 */

										if (var[l].contains(RegularModelList.get(k).getRegularName())) {
											/*
											 * System.out.println(
											 * "..............................................................................."
											 * );
											 */
											bucket = bucket + 1;

										}
									}

									mapNrmrgvs.put((j3 + 1), bucket);

									/*
									 * System.out.println("inside/inside/inside/inside/inside/: " + lines.get(j3 +
									 * 1));
									 */

									bucket = 0;

								}
							}
						}
					}
				}

			}
		}

		/*
		 * 
		 * 
		 * Set values to coupling object
		 * 
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			Coupling coupling = new Coupling();

			/* Set lineSet to the coupling object */
			coupling.setLine(lines.get(i));

			/* Set lineNoSet to the coupling object */
			coupling.setLineNo(i + 1);

			// Nr~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNr.containsKey(i) == true) {

				coupling.setNr(mapNr.get(i));
				/* System.out.println(mapNr.get(i)); */
			} else {
				coupling.setNr(0);

			} // Nr end..............................

			// Nmcms~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNmcms.containsKey(i) == true) {

				coupling.setNmcms(mapNmcms.get(i));
			} else {
				coupling.setNmcms(0);

			} // Nmcms end.........................

			// Nmcrms~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNmcrms.containsKey(i) == true) {

				coupling.setNmcrms(mapNmcrms.get(i));
			} else {
				coupling.setNmcrms(0);

			} // Nmcrms end.........................

			// Nrmcrms~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNrmcrms.containsKey(i) == true) {

				coupling.setNrmcrms(mapNrmcrms.get(i));
			} else {
				coupling.setNrmcrms(0);

			} // Nrmcrms end.........................

			// Nrmcms~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNrmcms.containsKey(i) == true) {

				coupling.setNrmcms(mapNrmcms.get(i));
			} else {
				coupling.setNrmcms(0);

			} // Nrmcms end.........................

			// Nrmrgvs~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (mapNrmrgvs.containsKey(i) == true) {

				coupling.setNrmrgvs(mapNrmrgvs.get(i));
			} else {
				coupling.setNrmrgvs(0);

			} // Nrmcms end.........................

			/* set coupling object to the couplingList Object */
			couplingList.add(coupling);

		}

		return couplingList;
	}
	
	public static ArrayList<Coupling> Ccp(ArrayList<String> lines, int WNr, int WNmcms, int WNmcmd, int WNmcrms,
			int WNmcrmd, int WNrmcrms, int WNrmcrmd, int WNrmcms, int WNrmcmd, int WNmrgvs, int WNmrgvd, int WNrmrgvs,
			int WNrmrgvd) {

		// Variable set
		int Wr = WNr;
		int Wmcms = WNmcms;
		int Wmcmd = WNmcmd;
		int Wmcrms = WNmcrms;

		int Wmcrmd = WNmcrmd;
		int Wrmcrms = WNrmcrms;
		int Wrmcrmd = WNrmcrmd;
		int Wrmcms = WNrmcms;

		int Wrmcmd = WNrmcmd;
		int Wmrgvs = WNmrgvs;
		int Wmrgvd = WNmrgvd;
		int Wrmrgvs = WNrmrgvs;
		int Wrmrgvd = WNrmrgvd;

		ArrayList<Coupling> CcpList = new ArrayList<Coupling>();
		ArrayList<Coupling> coupling = new ArrayList<Coupling>();
		coupling = Coupling(lines);

		for (int i = 0; i < lines.size(); i++) {

			Coupling couplingObj = new Coupling();
			
			int Ccp = coupling.get(i).getNr() * Wr + coupling.get(i).getNmcms() * Wmcms
					+ coupling.get(i).getNmcrms() * Wmcrms + coupling.get(i).getNrmcms() * Wrmcms
					+ coupling.get(i).getNrmcrms() * Wrmcrms;
			
			couplingObj.setCcp(Ccp);
			
			CcpList.add(couplingObj);
			
		}

		return CcpList;
	}



}
