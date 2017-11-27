package com.yyh;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int num, int den) {
        StringBuilder sb = new StringBuilder();
        if (den == 0){
            return "";
        }
        if (num == 0){
            return "0";
        }
        sb.append((num > 0) ^ (den > 0) ? "-" : "");
        long nu = Math.abs((long)num);
        long de = Math.abs((long)den);
        sb.append(nu / de);
        nu %= de;
        
        if (nu == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(nu, sb.length());
        while (nu != 0){
            nu *= 10;
            sb.append(nu / de);
            nu %= de;
            if (map.containsKey(nu)){
                int ind = map.get(nu);
                sb.insert(ind, "(");
                sb.append(")");
                break;
            } else {
                map.put(nu, sb.length());
            }
        }
        return sb.toString();
    }
}
