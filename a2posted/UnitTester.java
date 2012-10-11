package a2posted;

import java.util.HashMap;

public class UnitTester {

	public static void main(String... args) {
		HashMap<String, Boolean> testCases = new HashMap<String, Boolean>();
		testCases.put("foo=23", true);
		testCases.put("foo= 23", false);
		testCases.put("foo =23", false);
		testCases.put("foo=bar", false);
		testCases.put("foo=if", false);
		testCases.put("if then else end", false);
		testCases.put("statement=23", true);
		testCases.put("statement==23", false);
		testCases.put("integer=23", true);
		testCases.put("digit=23", true);
		testCases.put("bool=23", true);
		testCases.put("if=23", true);
		testCases.put("then=23", true);
		testCases.put("else=23", true);
		testCases.put("end=23", true);
		testCases.put("if true then if false then a=2 else b=12 end else a=10 end", true);
		testCases.put("if true then if false then a=2 else b=12 end else if false then a=2 else b=12 end end", true);
		testCases.put("if true then if false then if true then if false then a=2 else b=12 end else if false then a=2 else b=12 end end else b=12 end else if false then a=2 else if true then if false then a=2 else b=12 end else if false then a=2 else b=12 end end end end", true);
		testCases.put("if true then a=2 else b=31 end", true);
		testCases.put("if false then if true then c=5 else d=5 end else b=31 end", true);
		testCases.put("if true then a=2 else b=31", false);
		testCases.put("if a=2 then a=2 else b=31 end", false);
		testCases.put("if then a=2 else b=31 end", false);
		testCases.put("if true else a=2 then b=31 end", false);
		testCases.put("if true a=2 else b=31 end", false);
		testCases.put("if true then a=2 end", false);
		testCases.put("if", false);
		testCases.put("true", false);
		testCases.put("false", false);
		testCases.put("123", false);
		testCases.put("if if", false);
		testCases.put("if true then a=1 else b=1 end end", false);
		
		StringSplitter splitter;
		
		int fails = 0;
		
		for (String testCase : testCases.keySet()) {
			splitter = new StringSplitter(testCase);
			if (LanguageParser.parse(splitter) != testCases.get(testCase)) {
				fails++;
				System.out.println("Test case \"" + testCase +"\" failed!\nExpected result: " + 
						testCases.get(testCase) + "\nObtained result: " + !testCases.get(testCase) + "\n");
			}
		}
		
		System.out.println((testCases.size() - fails) + "/" + testCases.size() + " test cases passed.");
	}
	
}
