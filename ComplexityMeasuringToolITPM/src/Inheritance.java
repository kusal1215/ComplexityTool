import java.util.ArrayList;

import model.InheritanceComplexity;

public class Inheritance {

	public static ArrayList<InheritanceComplexity> inheritanceCi(ArrayList<String> line) {
		
		
		ArrayList<InheritanceComplexity> list = new ArrayList<InheritanceComplexity>();

		//ArrayList<Integer> Ci = new ArrayList<Integer>();
		ArrayList<String> DirectInheritanceList = new ArrayList<String>();
		ArrayList<String> InirectInheritanceList = new ArrayList<String>();
		// ArrayList<Integer> TotalInheritanceList = new ArrayList<Integer>();

		int complexity = 0;
		int derectCi = 0;
		int InderectCi = 0;
		int totalCi = 0;
		String child = "";
		String parent= "";

		String ExceptionsSelection[] = { "ArithmeticException", "ArrayIndexOutOfBoundsException",
				"ClassNotFoundException", "FileNotFoundException", "IOException", "InterruptedException",
				"NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException",
				"RuntimeException", "StringIndexOutOfBoundsException" };

		for (int i = 0; i < line.size(); i++) {

			InheritanceComplexity inheritanceComplexity = new InheritanceComplexity();
			
			String[] wordsForVariables = line.get(i).split(" ");
			for (int r = 0; r < wordsForVariables.length; r++) {
				

				if (wordsForVariables.length == 5) {
					System.out.println("5iiiiii");
					

					if (wordsForVariables[r].contains("public") && wordsForVariables[r + 1].contains("class")
							&& wordsForVariables[r + 3].contains("extends")) {
						
						
						
						String indexOfBrack = wordsForVariables[r + 4].replaceAll("\\{","");// catch the index after the barcketss byindexOf rami
						System.out.println(indexOfBrack);
						System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
						
						child = wordsForVariables[r + 2];
						//InirectInheritanceList.add(child);
						System.out.println(wordsForVariables[r + 2]);
						//derectCi = derectCi + 1;
						//inheritanceComplexity.setDirect(derectCi);
												
						//complexity = complexity + derectCi;
					
						System.out.println(InirectInheritanceList);
						System.out.println("child xxxxxxxxxxxxxxxx");

						parent = indexOfBrack;
						//DirectInheritanceList.add(parent);
						System.out.println(indexOfBrack);
						
						System.out.println(DirectInheritanceList);
						System.out.println("parent xxxxxxxxxxxxxxxx");
						
						inheritanceComplexity.setLine(parent);
						for (int j = 0; j < line.size(); j++) {
							
							//setting the line to the model class object
						//	inheritanceComplexity.setLine(line.get(i));
									
							String[] words = line.get(j).split(" ");
							for (int p = 0; p < words.length; p++) {
									
									if (words.length == 5) {
										
										if (words[p].contains("public") && words[p + 1].contains("class")
												&& words[p + 3].contains("extends")) {
											
										
													String SecondindexOfBrackTwo = words[p + 4].replaceAll("\\{","");// catch the index after the barcketss byindexOf rami
													System.out.println(SecondindexOfBrackTwo);
													System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
													
														
														
														if(SecondindexOfBrackTwo.contains(parent) ) {
															derectCi = derectCi + 1;
															inheritanceComplexity.setDirect(derectCi);
															//complexity =  complexity + derectCi;
															System.out.println("direct parent second loop in........");
														}
														
														else if( SecondindexOfBrackTwo.contains(child)) {
															InderectCi = InderectCi + 1;
															inheritanceComplexity.setInditect(InderectCi);
															//complexity =  complexity + InderectCi ;
															System.out.println("indirect parent second loop in else if........");
							
																
														}else {
															totalCi =  totalCi + 0;
														}
														
												
										}
									}else {
										totalCi = totalCi + 0;
									}
											
								}
							
						}
						
						
					}else {
						
						totalCi = totalCi + 0;
						System.out.println("else......public class.........");
					}
													
				
				}else {
					totalCi = totalCi;
				}
			

			}
			
			totalCi =  totalCi + InderectCi + derectCi ;
			
			if(totalCi > 3 ) {
				complexity = 4;
			}
			else {
				complexity = totalCi;
			}
			inheritanceComplexity.setTotal(totalCi);
			inheritanceComplexity.setCi(complexity);		
			list.add(inheritanceComplexity);
			derectCi = 0;
			InderectCi = 0;
			totalCi = 0;	
		
					
		}		

		return list;
	}
}
