package com.yyh;

// Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

public class ToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToHex my = new ToHex();
		System.out.println(my.toHex(-1));
		System.out.println(my.toHex(16));
	}

	public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean init = false;
        for (int i = 7; i >= 0; i--){
            char dig = charConv((num >> (i * 4)) & 15);
            if (init == true){
                sb.append(dig);
            } else if (dig != '0'){
                sb.append(dig);
                init = true;
            }
        }
        return sb.toString();
    }
    
    private char charConv(int num){
        if (num >= 0 && num < 10){
            return (char)((int)'0' + num);
        }
        return (char)((int)'a' + num - 10);
    }
}
