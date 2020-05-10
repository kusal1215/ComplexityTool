import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.ControlStructures;

/**
 * 
 */

/**
 * @author rashmika
 *
 */
public class CodeControlStructure {
	
	public static ArrayList<ControlStructures> Nc(ArrayList<String> lines, int WCondition, int WLoop, int WSwitch,
			int Case) {

		// variable-1
		String[] var;
		// variable-2
		String line = "";
		// variable-3
		int NC = 0;
		// variable-4
		ArrayList<ControlStructures> ControlList = new ArrayList<ControlStructures>();
		// variable-5
		Map<Integer, Integer> HashNC = new HashMap<Integer, Integer>();
		// variable-6
		Map<Integer, Integer> WtcsList = new HashMap<Integer, Integer>();
		// varialbe-18
		Map<Integer, Integer> CcsppsList = new HashMap<Integer, Integer>();
		// variable-7
		int Wtcs = 0;

		// variable-8
		int Wif = WCondition;
		// variable-9
		int Wloop = WLoop;
		// variable-10
		int Wswitch = WSwitch;
		// variable-11
		int Wcase = Case;

		// variable-12
		int Ccs = 0;
		// variable-13
		int NCtot = 0;
		// variable-14
		int Wtcstot = 0;
		// variable-15
		int Ccsppstot = 0;

		// variable-16
		int bracketnumber = 0;
		// variable-17
		int CcsppCount = 0;

		for (int i = 0; i < lines.size(); i++) {

			// ControlStructures controlStructure = new ControlStructures();

			if (lines.get(i).contains("System.out.println") || lines.get(i).contains("\\")
					|| lines.get(i).startsWith("//") || (lines.get(i).startsWith("/*"))
					|| lines.get(i).startsWith("*/")) {

			} else if (lines.get(i).contains("cout <<") || lines.get(i).startsWith("(\\s+)\\(.*)")
					|| lines.get(i).startsWith("(\\s+)//(.*)") || (lines.get(i).startsWith("(\\s+)/*(.*)"))
					|| lines.get(i).startsWith("(\\s+)*/(.*)")) {

			} else {

				if ((lines.get(i).contains("if") && lines.get(i).contains("("))
						|| (lines.get(i).contains("else if") && lines.get(i).contains("("))) {

					Wtcs = Wtcs + Wif;
					WtcsList.put(i, Wtcs);

					if (lines.get(i).contains("&&") || lines.get(i).contains("||") || lines.get(i).contains("&")
							|| lines.get(i).contains("|")) {
						System.out.println("lines" + lines.get(i));
						line = lines.get(i).replace("&&", "##").replace("||", "##").replace("&&", "##").replace("|",
								"##");

						var = line.split("##");

						NC = var.length;
						HashNC.put(i, NC);
						for (int j3 = 0; j3 < var.length; j3++) {
							System.out.println(var[j3]);

						}
					} else {

						NC = 1;
						HashNC.put(i, NC);

					}

				}
				if (lines.get(i).contains("for")
						|| (lines.get(i).contains("while") && (lines.get(i).contains("("))
								&& lines.get(i).replaceAll("\\s", "").contains("){"))
						|| lines.get(i).replaceAll("\\s", "").contains("do{")) {

					Wtcs = Wtcs + Wloop;
					WtcsList.put(i, Wtcs);

					if (lines.get(i).contains("for")) {
						var = lines.get(i).split("for");
						NC = var.length;
						HashNC.put(i, NC);
					}
					if (lines.get(i).contains("while")) {
						var = lines.get(i).split("while");
						NC = var.length;
						HashNC.put(i, NC);
					}
					if (lines.get(i).contains("do")) {
						var = lines.get(i).split("do");
						NC = var.length;
						HashNC.put(i, NC);
					}
				}

				if (lines.get(i).contains("switch") && lines.get(i).contains("(")) {

					Wtcs = Wtcs + Wswitch;
					WtcsList.put(i, Wtcs);

					var = lines.get(i).split("switch");
					NC = var.length;
					HashNC.put(i, NC);

				}

				if (lines.get(i).contains("case") && lines.get(i).contains(":")) {

					Wtcs = Wtcs + Wcase;
					WtcsList.put(i, Wtcs);

					var = lines.get(i).split("case");
					NC = var.length;
					HashNC.put(i, NC);

				}

				Wtcs = 0;
			}
		}

		/*
		 * 
		 * Ccspps list
		 * 
		 */
		//if nested block
		for (int j = 0; j < lines.size(); j++) {
			if (lines.get(j).contains("System.out.println") || lines.get(j).contains("\\")
					|| lines.get(j).startsWith("//") || (lines.get(j).startsWith("/*"))
					|| lines.get(j).startsWith("*/")) {

			} else if (lines.get(j).contains("cout <<") || lines.get(j).startsWith("(\\s+)\\(.*)")
					|| lines.get(j).startsWith("(\\s+)//(.*)") || (lines.get(j).startsWith("(\\s+)/*(.*)"))
					|| lines.get(j).startsWith("(\\s+)*/(.*)")) {

			} else {

				if (lines.get(j).contains("if")) {
					// loop the function
					for (int j2 = j; j2 < lines.size(); j2++) {
						// check for brackets
						if (lines.get(j2).contains("{") && lines.get(j2).contains("}")) {
							bracketnumber = bracketnumber + 0;
						} else if (lines.get(j2).contains("{")) {
							bracketnumber = bracketnumber + 1;
						} else if (lines.get(j2).contains("}")) {
							bracketnumber = bracketnumber - 1;
						}
						System.out.println(bracketnumber + ";;;;" + lines.get(j2));
						if (bracketnumber == 0) {

							j = j2;// Assign j2 value for outer loop variable

							System.out.println(lines.get(j2 + 1) + "nothing is impossible");
							CcsppCount = 0;
							break;
						}
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
						// get Total for immediate line
						/* if (WtcsList.containsKey(j2) == true) { */
						/*
						 * System.out.println(WtcsList.get(j2 - 1) + " " + HashNC.get(j2 + 1));
						 * System.out.println(lines.get(j2 - 1) + lines.get(j2) + lines.get(j2 + 1));
						 */
						/*
						 * } if (HashNC.containsKey(j) == true) {}
						 */
						if (WtcsList.get(j2) == null && HashNC.get(j2) == null) {

						} else {

							CcsppCount = CcsppCount + WtcsList.get(j2) * HashNC.get(j2);

						}
						if (lines.get(j2 + 1).contains("if")) {

							CcsppsList.put(j2 + 1, CcsppCount);

							for (int k = j2; k < lines.size(); k++) {
								// check for brackets
								if (lines.get(k).contains("{") && lines.get(k).contains("}")) {
									bracketnumber = bracketnumber + 0;
								} else if (lines.get(k).contains("{")) {
									bracketnumber = bracketnumber + 1;
								} else if (lines.get(k).contains("}")) {
									bracketnumber = bracketnumber - 1;
								}
								System.out.println(bracketnumber + ";;;;" + lines.get(k));
								if (bracketnumber == 0) {

									j = k;// Assign j2 value for outer loop variable

									System.out.println(lines.get(j2 + 1) + "nothing is impossible" + CcsppCount);
									CcsppCount = 0;
									break;
								}

								/*
								 * System.out.println(
								 * "9999999999999999999999999999999999999999999999999999999999");
								 * System.out.println(WtcsList.get(k)+HashNC.get(k)); CcsppCount = CcsppCount +
								 * WtcsList.get(k) + HashNC.get(k); if (lines.get(k + 1).contains("if")) {
								 * 
								 * CcsppsList.put(k + 1, CcsppCount);
								 * 
								 * }
								 */
							}

						}

					}

				}
			}
		}

		/*
		 * 
		 * 
		 * Set values to controlStrucutre object
		 * 
		 * 
		 */
		for (int i = 0; i < lines.size(); i++) {

			ControlStructures controlStrucutre = new ControlStructures();

			/* Set lineSet to the controlStrucutre object */
			controlStrucutre.setLine(lines.get(i));

			/* Set lineNoSet to the controlStrucutre object */
			controlStrucutre.setLineNo(i + 1);

			// NC~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (HashNC.containsKey(i) == true) {

				controlStrucutre.setNC(HashNC.get(i));
				System.out.println(HashNC.get(i));
				NCtot = HashNC.get(i);
			} else {
				controlStrucutre.setNC(0);
				NCtot = 0;

			} // NC end..............................

			// Wtcs~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (WtcsList.containsKey(i) == true) {

				controlStrucutre.setWtcs(WtcsList.get(i));
				System.out.println(WtcsList.get(i));
				Wtcstot = WtcsList.get(i);
			} else {
				controlStrucutre.setWtcs(0);
				Wtcstot = 0;

			} // Wtcs end..............................

			// Ccspps~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (CcsppsList.containsKey(i) == true) {

				controlStrucutre.setCcspps(CcsppsList.get(i));
				System.out.println(CcsppsList.get(i));
				Ccsppstot = CcsppsList.get(i);
			} else {
				controlStrucutre.setCcspps(0);
				Ccsppstot = 0;

			} // Ccspps end..............................

			// Ccs~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			Ccs = NCtot * Wtcstot + Ccsppstot;
			controlStrucutre.setCcs(Ccs);
			System.out.println("Ccs value..............................................:::::" + Ccs);

			// Ccs end..............................

			/* set coupling object to the ControlStructureList Object */
			ControlList.add(controlStrucutre);

			Ccs = 0;

		}

		return ControlList;

	}


}
