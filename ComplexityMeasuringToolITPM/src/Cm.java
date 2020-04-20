import java.util.ArrayList;

import model.MethodsComplexity;

public class Cm {

	public static ArrayList<MethodsComplexity> MethodsCm(ArrayList<String> line) {

//		ArrayList<Integer> Cm = new ArrayList<Integer>();
//		ArrayList<Integer> premitiveList = new ArrayList<Integer>();
//		ArrayList<Integer> compositeList = new ArrayList<Integer>();
//		ArrayList<Integer> WmrtList = new ArrayList<Integer>();
		
		ArrayList<MethodsComplexity> list = new ArrayList<MethodsComplexity>();
		

		int complexity = 0;
		int primitive_data = 0;
		int composite_data = 0;
		int	com_wmrt = 0;
		int pri_wmrt = 0;
		int void_wmrt = 0;

		// String fileInput = uploadedContent.toString(); //read the txt document
		String visibility[] = { "public", "private", "protected" };
		String Prireturntype[] = { "int", "long", "double", "float", "boolean", "char" };
		String Comreturntype[] = { "arrays", "objects", "records", "interfaces", "lists" };

		String ExceptionsSelection[] = { "ArithmeticException", "ArrayIndexOutOfBoundsException",
				"ClassNotFoundException", "FileNotFoundException", "IOException", "InterruptedException",
				"NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException",
				"RuntimeException", "StringIndexOutOfBoundsException" };

		for (int i = 0; i < line.size(); i++) {
			
			MethodsComplexity methodsComplexity = new MethodsComplexity();
			
			//setting the line to the model class object
			methodsComplexity.setLine(line.get(i));
					
				String[] wordsForVariables = line.get(i).split(" ");
				for (int r = 0; r < wordsForVariables.length; r++) {
					
						//check public ,private,protected in method 
						if(wordsForVariables[r].contains("public") || wordsForVariables[r].contains("protected") ||wordsForVariables[r].contains("private")) {
					
							//System.out.println("IN first if " + wordsForVariables[r + 1]);
							//check if the second word is static
							if (wordsForVariables[r + 1].contains("static")) {
								
								//System.out.println("IN static if ");
								//if satic check 3 word premitive
								if (wordsForVariables[r + 2].contains("int")
										|| wordsForVariables[r + 2].contains("float")
										|| wordsForVariables[r + 2].contains("long")
										|| wordsForVariables[r + 2].contains("double")
										|| wordsForVariables[r + 2].contains("boolean")
										|| wordsForVariables[r + 2].contains("char")) {
									
									//System.out.println("IN 3rd id " + wordsForVariables[r+2]);
									// check if contain (
									if (wordsForVariables[r + 3].contains("(")) {  //method primitive
										primitive_data = primitive_data + 1;
										pri_wmrt = pri_wmrt + 1;
										complexity = (primitive_data * 1)+ pri_wmrt ;
										//premitiveList.add(primitive_data);
										//setting the primitive data value to the model class object
										methodsComplexity.setNpdtp(primitive_data);
										//WmrtList.add(pri_wmrt);
										//setting the pri_wmrt value to the methodsComplexity object
										methodsComplexity.setWmrt(pri_wmrt);
										
										//System.out.println("IN 4 if " + wordsForVariables[r+3]);
									}
									
								}
								//if satic check 3 word composite
								else if(wordsForVariables[r + 2].contains("arrays")
										|| wordsForVariables[r + 2].contains("objects")
										|| wordsForVariables[r + 2].contains("interfaces")
										|| wordsForVariables[r + 2].contains("double")
										|| wordsForVariables[r + 2].contains("lists")) {
									// check if contain (
										if (wordsForVariables[r + 3].contains("(")) {// composite method
											composite_data = composite_data + 1;
											com_wmrt = com_wmrt + 2;
											complexity = (composite_data * 2)+ com_wmrt;
											//compositeList.add(composite_data);
											//setting the composite value to the model class object
											methodsComplexity.setNedtp(composite_data);
											//WmrtList.add(com_wmrt);
											//setting the pri_wmrt value to the methodsComplexity object
											methodsComplexity.setWmrt(com_wmrt);
										}		
								}
								// check if got void after static
								else if(wordsForVariables[r + 2].contains("void")) {
									if (wordsForVariables[r + 3].contains("(")) {
										composite_data = composite_data + 1;
										void_wmrt = void_wmrt + 0;
										complexity = (composite_data * 2)+ void_wmrt;
										//compositeList.add(composite_data);
										//setting the composite value to the model class object
										methodsComplexity.setNedtp(composite_data);
										//WmrtList.add(void_wmrt);
										//setting the pri_wmrt value to the methodsComplexity object
										methodsComplexity.setWmrt(void_wmrt);
									}		
									
								}
								

							} else {// if not static in 2nd word 
								
								if (wordsForVariables[r + 1].contains("int")//check if primitive
										|| wordsForVariables[r + 1].contains("float")
										|| wordsForVariables[r + 1].contains("long")
										|| wordsForVariables[r + 1].contains("double")
										|| wordsForVariables[r + 1].contains("boolean")
										|| wordsForVariables[r + 1].contains("char")) {
										
									
									//System.out.println("IN else " + wordsForVariables[r + 1]);
									
		
										if (wordsForVariables[r + 2].contains("(")) {// check if method 
											
											//System.out.println("IN else 2nd " + wordsForVariables[r + 2]);
											primitive_data = primitive_data + 1;
											pri_wmrt = pri_wmrt + 1;
											//System.out.println("IN else 2nd " + primitive_data);
											complexity = (primitive_data * 1)+ pri_wmrt;
											//premitiveList.add(primitive_data);
											//setting the primitive data value to the model class object
											methodsComplexity.setNpdtp(primitive_data);
											//WmrtList.add(pri_wmrt);
											//setting the pri_wmrt value to the methodsComplexity object
											methodsComplexity.setWmrt(pri_wmrt);
											
										}
								}
								else if(wordsForVariables[r + 1].contains("arrays")//check if composite
										|| wordsForVariables[r + 1].contains("objects")
										|| wordsForVariables[r + 1].contains("interfaces")
										|| wordsForVariables[r + 1].contains("double")
										|| wordsForVariables[r + 1].contains("lists")) {
										
										if (wordsForVariables[r + 2].contains("(")) {
											composite_data = composite_data + 1;
											com_wmrt = com_wmrt + 2;
											complexity = (composite_data * 2)+ com_wmrt;
											//compositeList.add(composite_data);
											//setting the composite value to the model class object
											methodsComplexity.setNedtp(composite_data);
											//WmrtList.add(com_wmrt);
											//setting the com_wmrt value to the methodsComplexity object
											methodsComplexity.setWmrt(com_wmrt);
										}		
								}		
								
							}
						}
				
					}
					
				//Cm.add(complexity);
				//setting the cm value to the methodsComplexity object
				methodsComplexity.setCm(complexity);
				complexity = 0;
				
				list.add(methodsComplexity);
				}
		return list;
	}

}
