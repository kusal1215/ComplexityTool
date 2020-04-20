import java.util.ArrayList;

//import model.MethodsComplexity;
import model.VariableComplexity;

public class Cv {

	public static ArrayList<VariableComplexity> variable(ArrayList<String> line) {

//		ArrayList<Integer> Cm = new ArrayList<Integer>();
//		ArrayList<Integer> premitiveList = new ArrayList<Integer>();
//		ArrayList<Integer> compositeList = new ArrayList<Integer>();
//		ArrayList<Integer> WmrtList = new ArrayList<Integer>();
		int[] hdbv;

		ArrayList<VariableComplexity> list = new ArrayList<VariableComplexity>();

		int complexity = 0;
		int wvs = 0;
		int primitive_variable = 0;
		int composite_variable = 0;
		int complexityofprimetive = 0;
		int complexityofcom = 0;

		// String fileInput = uploadedContent.toString(); //read the txt document
		String visibility[] = { "public", "private", "protected" };
		String Prireturntype[] = { "int", "long", "double", "float", "boolean", "char" };
		String Comreturntype[] = { "arrays", "objects", "records", "interfaces", "lists" };

		String ExceptionsSelection[] = { "ArithmeticException", "ArrayIndexOutOfBoundsException",
				"ClassNotFoundException", "FileNotFoundException", "IOException", "InterruptedException",
				"NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException",
				"RuntimeException", "StringIndexOutOfBoundsException" };

		for (int i = 0; i < line.size(); i++) {

			VariableComplexity variableComplexity = new VariableComplexity();

			// setting the line to the model class object
			variableComplexity.setLine(line.get(i));
			String newString = line.get(i).trim(); // remove white spaces first occured
			if (newString.startsWith("/") || newString.startsWith("*") || newString.startsWith("import")
					|| newString.startsWith("System")) {// set lines with comments to 0 Cs
				complexity = 0;
			} else {

				String[] wordsForVariables = line.get(i).split(" ");
				for (int r = 0; r < wordsForVariables.length; r++) {
					if (line.size() > 1) {
						// check public ,private,protected in variable method
						if (wordsForVariables[r].contains("public") || wordsForVariables[r].contains("protected")
								|| wordsForVariables[r].contains("private")) {
							if (wordsForVariables[r + 1].contains("int") || wordsForVariables[r + 1].contains("float")
									|| wordsForVariables[r + 1].contains("long")
									|| wordsForVariables[r + 1].contains("double")
									|| wordsForVariables[r + 1].contains("boolean")
									|| wordsForVariables[r + 1].contains("char")) {

								if (!wordsForVariables[r + 2].contains("(")) {// not a method
									primitive_variable = primitive_variable + 1;
									complexityofprimetive = (primitive_variable * 1);
									wvs =  2;

								}else {
									complexity = 0;
								}

							} else if (wordsForVariables[r + 1].contains("interface")) {// check interface

								composite_variable = composite_variable + 1;
								complexityofcom = (composite_variable * 2);
								wvs =  2;
							}else {
								complexity = 0;
							}

						} else {// in variable with out private public protected

							if (wordsForVariables[r].contains("int") || wordsForVariables[r].contains("float")
									|| wordsForVariables[r].contains("long") || wordsForVariables[r].contains("double")
									|| wordsForVariables[r].contains("boolean")
									|| wordsForVariables[r].contains("char")) {

								if (!wordsForVariables[r + 1].contains("(")) {// not a method
									primitive_variable = primitive_variable + 1;
									complexityofprimetive = (primitive_variable * 1);
									wvs =  2;
								}else {
									complexity = 0;
								}

							} else if (wordsForVariables[r].contains("ArrayList<") // List
									|| wordsForVariables[r].contains("ArrayList ")// List
									// || wordsForVariables[r+3].contains("new")//object
									|| wordsForVariables[r].contains("interface")// interface
									|| wordsForVariables[r].contains("String[") || wordsForVariables[r].contains("int[")
									|| wordsForVariables[r].contains("float[") || wordsForVariables[r].contains("long[")
									|| wordsForVariables[r].contains("double[")
									|| wordsForVariables[r].contains("boolean[")
									|| wordsForVariables[r].contains("char[")) {
								
								
									composite_variable = composite_variable + 1;
									complexityofcom = (composite_variable * 2);
									wvs =  2;
							} else {
								complexity = 0;
							}
						}
					} else {
						complexity =  0;
					}

				}
			}

			complexity =  wvs * (complexityofcom + complexityofprimetive);
			variableComplexity.setComplexity(complexity);
			variableComplexity.setComposite_variable(composite_variable);
			variableComplexity.setPrimitive_variable(primitive_variable);
			variableComplexity.setWvs(wvs);

			complexity = 0;
			composite_variable = 0;
			primitive_variable = 0;
			wvs = 0;
			complexityofcom = 0;
			complexityofprimetive = 0 ;

			list.add(variableComplexity);
		}
		return list;
	}

}
