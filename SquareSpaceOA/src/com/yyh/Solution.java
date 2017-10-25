package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static boolean isBalanced(String input) {
        if (input == null || input.length() == 0){
            return true;
        } // Corner Case
        boolean singleQ = false;
        boolean doubleQ = false;
        boolean backSl = false;
        Deque<Character> stack = new ArrayDeque<>();//Stack to store the grouping character
        for (char ch : input.toCharArray()){
            if (singleQ == true) {
                if (ch != '\'') continue;
                else {
                    singleQ = false;
                    continue;
                }    
            }
            if (doubleQ == true) {
                if (ch != '\"') continue;
                else {
                    doubleQ  = false;
                    continue;
                }    
            }
            if (backSl == true) {
                backSl = false;
                continue;    
            }
            switch (ch){
                case '\'': singleQ = true; break;
                case '\"': doubleQ = true; break;
                case '\\': backSl = true; break;
                case '(': stack.offerFirst('('); break;
                case ')': if (stack.isEmpty() || stack.pollFirst() != '(') return false; break;
                case '[': stack.offerFirst('['); break;
                case ']': if (stack.isEmpty() || stack.pollFirst() != '[') return false; break;
                case '{': stack.offerFirst('{'); break;
                case '}': if (stack.isEmpty() || stack.pollFirst() != '{') return false; break;
                case '<': stack.offerFirst('<'); break;
                case '>': if (stack.isEmpty() || stack.pollFirst() != '<') return false; break;
                default: break;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(isBalanced(input));
        }
    }
}
