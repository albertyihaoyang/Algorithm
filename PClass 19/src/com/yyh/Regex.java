package com.yyh;

import java.util.regex.*;

public class Regex {

	public static void main(String[] args) {
//		ex1();
		ex3();
	}

	public static void ex1(){
		// Lets use a regular expression to match a date string.
		Pattern ptrn = Pattern.compile("([a-zA-Z]+) (\\d+)");
		Matcher matcher = ptrn.matcher("June 24");
		if (matcher.matches()) {
		    // Indeed, the expression "([a-zA-Z]+) (\d+)" matches the date string

		    // To get the indices of the match, you can read the Matcher object's
		    // start and end values.
		    // This will print [0, 7], since it matches at the beginning and end of the 
		    // string
		    System.out.println("Match at index [" + matcher.start() + 
		        ", " + matcher.end() + ")");

		    // To get the fully matched text, you can read the Matcher object's group
		    // This will print "June 24"
		    System.out.println("Match: " + matcher.group());
		}
	}
	
	public static void ex2(){
		// Lets use a regular expression to capture data from a few date strings.
		String pattern = "([a-zA-Z]+) (\\d+)";
		Pattern ptrn = Pattern.compile(pattern);
		Matcher matcher = ptrn.matcher("June 24, August 9, Dec 12");

		// This will print each of the matches and the index in the input string
		// where the match was found:
		//   June 24 at index [0, 7)
		//   August 9 at index [9, 17)
		//   Dec 12 at index [19, 25)
		while (matcher.find()) {
		    System.out.println(String.format("Match: %s at index [%d, %d]",
		        matcher.group(), matcher.start(), matcher.end()));
		}

		// If we are iterating over the groups in the match again, first reset the
		// matcher to start at the beginning of the input string.
		matcher.reset();

		// For each match, we can extract the captured information by reading the 
		// captured groups.
		while (matcher.find()) {
		    // This will print the number of captured groups in this match
		    System.out.println(String.format("%d groups captured", 
		        matcher.groupCount()));

		    // This will print the month and day of each match.  Remember that the
		    // first group is always the whole matched text, so the month starts at
		    // index 1 instead.
		    System.out.println("Month: " + matcher.group(1) + ", Day: " + 
		        matcher.group(2));

		    // Each group in the match also has a start and end index, which is the
		    // index in the input string that the group was found.
		    System.out.println(String.format("Month found at[%d, %d)", 
		        matcher.start(1), matcher.end(1)));
		}
	}
	
	public static void ex3(){
		// Lets try and reverse the order of the day and month in a few date 
		// strings. Notice how the replacement string also contains metacharacters
		// (the back references to the captured groups) so we use a verbatim 
		// string for that as well.
		Pattern ptrn = Pattern.compile("([a-zA-Z]+) (\\d+)");
		Matcher matcher = ptrn.matcher("June 24, August 9, Dec 12");

		// This will reorder the string inline and print:
		//   24 of June, 9 of August, 12 of Dec
		// Remember that the first group is always the full matched text, so the 
		// month and day indices start from 1 instead of zero.
		String replacedString = matcher.replaceAll("$2 of $1");
		System.out.println(replacedString);
	}
}
