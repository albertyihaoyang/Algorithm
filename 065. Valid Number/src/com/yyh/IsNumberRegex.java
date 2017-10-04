package com.yyh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumberRegex {

	public static void main(String[] args) {
		IsNumberRegex my = new IsNumberRegex();
		System.out.println(my.isNumber("-1.1E10"));
	}

	public boolean isNumber(String s) {
        String pattern = "[+-]?(([0-9]+(\\.[0-9]*)?)|\\.[0-9]+)([eE][+-]?[0-9]+)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m  = r.matcher(s);
        return m.find();
    }
}
