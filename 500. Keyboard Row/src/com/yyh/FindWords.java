package com.yyh;
import java.util.*;
public class FindWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindWords my = new FindWords();
		System.out.println(Arrays.toString(my.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
	}

	public String[] findWords(String[] words) {
        if (words == null || words.length == 0){
            return words;
        }
        List<String> list = new ArrayList<>();
        for (String word: words){
            if (isRow(word)){
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }
    
    private boolean isRow(String word){
        Set<Character> qSet = new HashSet <>(Arrays.asList('q', 'Q', 'w', 'W', 'e', 'E', 'r', 'R', 't', 'T',
                                                                      'y', 'Y', 'u', 'U', 'i', 'I', 'o', 'O', 'p', 'P'));
        Set<Character> aSet = new HashSet <>(Arrays.asList('a', 'A', 's', 'S', 'd', 'D', 'f', 'F', 'g', 'G',
                                                                      'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L'));
        Set<Character> zSet = new HashSet <>(Arrays.asList('z', 'Z', 'x', 'X', 'c', 'C', 'v', 'V', 'b', 'B',
                                                                      'n', 'N', 'm', 'M'));
        char[] arr = word.toCharArray();
        if (qSet.contains(arr[0])){
            for (char ch : arr){
                if (!qSet.contains(ch)){
                    return false;
                }
            }
        }else if (aSet.contains(arr[0])){
            for (char ch : arr){
                if (!aSet.contains(ch)){
                    return false;
                }
            }
        } else if (zSet.contains(arr[0])){
            for (char ch : arr){
                if (!zSet.contains(ch)){
                    return false;
                }
            }
        }
        return true;           
    }
}
