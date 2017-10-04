package com.yyh;

public class RemoveDuplicatedSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatedSpace mySol = new RemoveDuplicatedSpace();
		System.out.println(mySol.removeDup("  I    Love  LA   "));
		System.out.println(mySol.removeDupInPlace("  I    Love  LA   "));
	}

	// Using String Builder
	// Time complexity: O(n); /Space Complexity: O(n);
	public String removeDup (String input){
		if (input == null) {
			return null;
		}
		boolean initSpace = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++){
			char a = input.charAt(i);
			if (a != ' '){
				sb.append(a);
				initSpace = false;
			} else if (a == ' '  && (!initSpace && ( i > 0 && input.charAt(i - 1) != ' '))){
				sb.append(a);
			}
		}
		if (sb.charAt(sb.length() - 1) == ' '){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();	
	}
		
		// Inplace method
		// Time complexity: O(n); /Space Complexity: O(n);
		public String removeDupInPlace (String input) {
			if (input == null) {
				return null;
	}
			char[] arr = input.toCharArray();
			// Result we need is the chars before end (including end)
			int end = 0;
			for (int i = 0; i < input.length(); i++){
				if (arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ')) {
					continue;
				}
				arr[end++] = arr[i];
			}
			if (end > 0 && arr[end - 1] == ' '){
				return new String(arr, 0, end - 1);
			}
			return new String(arr, 0, end);
		}

}
