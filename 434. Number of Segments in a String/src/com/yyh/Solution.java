package com.yyh;
// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
public class Solution {
	public int countSegments(String s) {
        int res = 0;
        if (s.length() == 0){
            return res;
        }
        int i = 0;
        boolean flag = false;
        while (i < s.length()){
            if (s.charAt(i) != ' '){
                flag = true;
            } else {
                if (flag){
                    res += 1;
                    flag = false;
                }
            }
            i++;
        }
        if (flag){
            res += 1;
        }
        return res;
    }
}
