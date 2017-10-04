package com.yyh;

public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("913","0"));
	}

	public static String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num1 == "0"){
        	return num2;
        }
        if (num2.length() == 0 || num2 == "0"){
        	return num1;
        }
        if (num1.length() > num2.length()) {
        	for (int i = 0; i < num1.length() - num2.length(); i++){
        		num2 = "0" + num2;
        	}
        } else {
        	for (int i = 0; i < num2.length() - num1.length(); i++){
        		num1 = "0" + num1;
        	}
        }
        char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		return addChars(arr1, arr2);
    }
	
	public static String addChars(char[] arr1, char[] arr2){
		int addition = 0;
		for (int i = arr1.length -1; i >= 0; i--){
			int newsum = 
					Character.getNumericValue(arr1[i]) + Character.getNumericValue(arr2[i]) + addition;
			if (newsum <= 9){
				arr1[i] = Integer.toString(newsum).charAt(0);
				addition = 0;
			} else {
				arr1[i + arr1.length - arr2.length] = Integer.toString(newsum).charAt(1);
				addition = 1;
			}
		}
		if (addition == 1) {
			return "1" + new String(arr1, 0, arr1.length);
		} else { 
			return new String(arr1, 0, arr1.length);
		}
	}
}
