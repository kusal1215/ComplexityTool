import java.util.ArrayList;

import javax.lang.model.SourceVersion;

//import model.MethodsComplexity;
import model.SizeComplexity;

public class Size {public static ArrayList<SizeComplexity> calcSize(ArrayList<String>line,int Keyword,int Identifer,int Operator ,int Number,int Stringliteral) {

//	System.out.println(Keyword);
//	System.out.println(Identifer);
//	System.out.println(Operator);
//	System.out.println(Number);
//	System.out.println(Stringliteral);
	
	ArrayList<SizeComplexity> list = new ArrayList<SizeComplexity>();
    ArrayList<String> variableList = new ArrayList<String>();

    
    int countComplexity = 0;
    int numofkeywords = 0;
    int numofop = 0;
    int numofNumaric = 0;
    int numofstring = 0;
    int numofidenty = 0;
   
    String operatorsCs1[] = {
        "+", "-", "*", "/", "%", "++", "--",
        "==", "!=", ">", "<", ">=", "<=",
        "&&", "||", "!",
        "|", "^", "~", "<<", ">>", ">>>", "<<<",
        ",", "->", ".", "::",
        "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^="
    };
    String cPlusPlusKeywords[] = {
        "printf", "cout", "cin", "include",
        "alignas", "alignof", "and_eq", "asm", "atomic_cancel", "atomic_commit",
        "atomic_noexcept", "bitand", "bitor", "compl", "concept", "consteval",
        "constexpr", "const_cast", "co_await", "co_return", "co_yield", "decltype",
        "dynamic_cast", "explicit", "export", "extern", "friend", "inline", "mutable",
        "noexcept", "not_eq", "nullptr", "operator", "or_eq", "reinterpret_cast",
        "requires", "signed", "sizeof", "static_assert", "static_cast", "struct",
        "template", "thread_local", "typedef", "typeid", "typename", "union",
        "unsigned", "using", "virtual", "wchar_t", "xor", "xor_eq"
    };
    String manipulators[] = {"endl", "\n"};

    String dataTypesToFindVariables[] = {
        "int", "Integer", "long", "float", "String", "void"
    };

    String allExceptions[] = {
        "ArithmeticException", "ArrayIndexOutOfBoundsException", "ClassNotFoundException", "FileNotFoundException", "IOException",
        "InterruptedException", "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException",
        "RuntimeException", "StringIndexOutOfBoundsException"
    };

   

    //find variables
    for (int v = 0; v < line.size(); v++) {
    	
    	

        String[] wordsForVariables = line.get(v).split(" ");
        for (int r = 0; r < wordsForVariables.length; r++) {
            for (int dataType = 0; dataType < dataTypesToFindVariables.length; dataType++) {//if variable is after data type
            	
            	
            	
                if (wordsForVariables[r].equals(dataTypesToFindVariables[dataType])) {
                    String idVariable = wordsForVariables[r + 1];
                    if (!idVariable.contains("(")) {//variable but not a method name
                    	//local variable  define rami
                        variableList.add(idVariable);//add to variable list
                    }
                }
            }
            if (wordsForVariables[r].contains("(")) {//if variable is after data type which belongs to word with brackets

                int indexOfBrack = wordsForVariables[r].indexOf("(");// catch the index after the barcketss byindexOf rami
                int fistIndexAfterBrack = indexOfBrack + 1;
                String variableName = wordsForVariables[r].substring(fistIndexAfterBrack); // substring by spit the string from ford or number by rami

                for (int dataType = 0; dataType < dataTypesToFindVariables.length; dataType++) {
                    if (variableName.equals(dataTypesToFindVariables[dataType])) {//check if the word is data type
                        String variable = wordsForVariables[r + 1];
                        if (!variable.contains("[")) {//if variable is not an array
                            //variableList.add(variable);
                            if (variable.endsWith(")")) {
                                int index1 = variable.lastIndexOf(')');//get last occured index of )
                                String variableWithoutBracketAtEnd = variable.substring(0, index1);
                                variableList.add(variableWithoutBracketAtEnd);
                            } else {
                                variableList.add(variable);
                                
                            }
                        }
                    }
                }
            }
        }
    }

    for (int i = 0; i < line.size(); i++) {
    	
    	SizeComplexity sizeComplexity = new SizeComplexity();
    	
    	sizeComplexity.setLine(line.get(i));
    	
        String newString = line.get(i).trim(); //remove white spaces first occured
        if (newString.startsWith("/") || newString.startsWith("*") || newString.startsWith("import")) {//set lines with comments to 0 Cs
            countComplexity = 0;
        } else {
            String[] words =line.get(i).split(" ");
            for (int r = 0; r < words.length; r++) {

                if (SourceVersion.isKeyword(words[r])) {//java keywords
                    
                    System.out.println(SourceVersion.isKeyword(words[r])); 
                    numofkeywords = numofkeywords+ 1;
                   
                }
               if (words[r].contains("static")) {
                	numofkeywords = numofkeywords+ 1;               	 
                }//java keywords
                if (words[r].contains("new") || words[r].contains("delete") || words[r].contains("throw") || words[r].contains("throws") || words[r].contains("break") || words[r].contains("continue")) {
                   
                	 numofkeywords = numofkeywords+ 1;
                	 
                }//java keywords
                if (words[r].contains("System") || words[r].contains("out")) {// System and out
                   
                	 numofkeywords = numofkeywords+ 1;
                	 
                }
                if (words[r].contains(".")) {//if . contains in a word like sout
                    char[] chWords = words[r].toCharArray();
                    for (int m = 0; m < chWords.length; m++) {
                        if (chWords[m] == '.') {
                        	 numofkeywords = numofkeywords+ 1;
                        	 
                        }
                    }
                }

                if (words[r].matches(".*\\d.*")) {//check if the value is a number // check numaric
                	numofNumaric = numofNumaric + 1;
                	
                }
                
                if (words[r].contains("(")) {//if method/object or word within double quotes //idqenty
                    //Cs for method
                    int indexOfBrack = words[r].indexOf("(");
                    String mn = words[r].substring(0, indexOfBrack);
                    if (!mn.equals(null) && !mn.isEmpty()) {//if method name exists //idqenty
                    	numofidenty = numofidenty+1;
                    	
                    }
                   

                    int indexOfBracket = words[r].indexOf("(");

                    //Cs for data types with brackets -- ex: (long)
                    int fistIndexAfterBracket = indexOfBracket + 1;
                    String dataTypeName = words[r].substring(fistIndexAfterBracket);
                    for (int dataType = 0; dataType < dataTypesToFindVariables.length; dataType++) {
                        if (dataTypeName.contains(dataTypesToFindVariables[dataType])) {//check if the word is data type 
                            countComplexity = countComplexity ;
                        }
                    }
                }
                
                //check if a control structure 
                if(words[r].startsWith("for") || words[r].startsWith("while") || words[r].startsWith("do") || words[r].startsWith("if") || words[r].startsWith("switch") || words[r].startsWith("case") ) {
                	countComplexity = countComplexity;
                }
             
                //string
                if (words[r].startsWith("\"")) {//words within double quotes seperately
                    if (!words[r + 1].equals("+")) {
                    	numofstring = numofstring + 1;
                    }
                }
                if(words[r].startsWith("(\\\".+\\\")")){
                	numofstring = numofstring + 1;
                	
                }
                if (words[r].contains("[")) {//if array //idqenty
                	numofidenty = numofidenty+1;
                	
                }
                //******************************************c++*******************************************************************

                for (int cp = 0; cp < cPlusPlusKeywords.length; cp++) {//check if c++ keywords
                    if (words[r].equals(cPlusPlusKeywords[cp])) {
                      
                    }
                }
                for (int opCs1 = 0; opCs1 < operatorsCs1.length; opCs1++) {//according to operators with Cs 1// operates
                    if (words[r].equals(operatorsCs1[opCs1])) {
                        numofop = numofop + 1;
                      
                    }
                }

                for (int ex = 0; ex < allExceptions.length; ex++) { //exceptions occurs
                    if (words[r].contains(allExceptions[ex])) {
                        countComplexity = countComplexity + 1;
                        if (words[r].startsWith("catch") || words[r - 1].equals("catch")) {// check for e --ex: catch(FileNotFoundException e) or catch 
                        	numofkeywords = numofkeywords+ 1;
                       	 	
                        	 
                        }
                    }
                }
                if (words[r].contains("throw")) {//if throw e
                    if (words[r + 1].startsWith("e") && words[r + 1].endsWith("e;")) {
                        countComplexity = countComplexity + 1;
                    }
                }
                if (words[r].contains("e.")) {//if contains e.--ex:e.getM()--here 2 because of method attach to it
                    countComplexity = countComplexity + 1;
                }
                if (words[r].startsWith("catch") && words[r].endsWith(")")) {//if catch within a word -- ex: catch(FileNotFoundException e) 
                   
                }
                for (int manip = 0; manip < manipulators.length; manip++) {//check if the value is a manipulator
                    if (words[r].equals(manipulators[manip])) {
                        countComplexity = countComplexity + 1;
                    }
                }
                for (int vl = 0; vl < variableList.size(); vl++) {//check if variable //idqenty
                    String var = variableList.get(vl);
                    if (words[r].contains(var)) {
                       
                    }
                }
                if (words[r].equals("new")) {//for class names -- ex: FileReader f = new ....//object idqenty
                	numofidenty = numofidenty+1;
              
                }

            }
        }
        countComplexity = (numofkeywords * Keyword) + (numofNumaric * Number) + (numofidenty * Identifer) + (numofstring * Stringliteral) + (numofop * Operator);
        sizeComplexity.setNumofNumaric(numofNumaric);
        sizeComplexity.setNumofkeywords(numofkeywords);
        sizeComplexity.setNumofidenty(numofidenty);
        sizeComplexity.setNumofstring(numofstring);
        sizeComplexity.setNumofop(numofop);
        sizeComplexity.setCountComplexity(countComplexity);
        
        countComplexity = 0;
        numofkeywords = 0;
        numofop = 0;
        numofNumaric = 0;
        numofstring = 0;
        numofidenty = 0;
        
        list.add(sizeComplexity);
       
    }


 
 
   return list;
   

}

}
