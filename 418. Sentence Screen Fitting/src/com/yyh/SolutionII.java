package com.yyh;

public class SolutionII {
	public int wordsTyping(String[] sen, int rows, int cols) {
        String s = String.join(" ", sen) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++){
            start += cols;
            if (s.charAt(start % l) == ' '){
                start++;
            } else{
                while (start > 0 && s.charAt((start - 1) % l) != ' '){
                    start--;
                }
            }
        }
        return start / l;
    }
}
