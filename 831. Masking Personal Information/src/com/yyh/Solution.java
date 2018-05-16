package com.yyh;

public class Solution {
	public String maskPII(String S) {
        int email = -1;
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '@'){
                email = i;
                break;
            }
        }
        if (email >= 0){
            return toEmail(S, email);
        } else {
            return toPhone(S);
        }
    }
    
    private String toEmail(String S, int email){
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        sb.append("*****");
        int i = 1;
        while (S.charAt(i) != '@'){
            i++;
        }
        sb.append(S.substring(i - 1));
        return sb.toString().toLowerCase();
    }
    
    private String toPhone(String S){
        int count = 0;
        char[] lastFour = new char[4];
        int j = 3;
        for (int i = S.length() - 1; i >= 0; i--){
            char ch = S.charAt(i);
            if (ch >= '0' && ch <= '9'){
                count++;
                if (j >= 0) lastFour[j--] = ch;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (count > 10){
            sb.append('+');
            for (int i = 0; i < count - 10; i++){
                sb.append('*');
            }
            sb.append('-');
        }
        sb.append("***-***-");
        for (char ch: lastFour){
            sb.append(ch);
        }
        return sb.toString();
    }
}
