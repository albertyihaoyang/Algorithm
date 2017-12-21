package com.yyh;
/*
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
 * and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. 
 * Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, 
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
	public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> own = new HashMap<>();
        Map<String, String> par = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a: acts){
            for (int i = 1; i < a.size(); i++){
                par.put(a.get(i), a.get(i));
                own.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a: acts){
            String p = getP(a.get(1), par);
            for (int i = 2; i < a.size(); i++){
                par.put(getP(a.get(i), par), p);
            }
        }
        for (List<String> a: acts){
            for (int i = 1; i < a.size(); i++){
                String p = getP(a.get(i), par);
                if (!unions.containsKey(p)){
                    unions.put(p, new TreeSet<>());
                }
                unions.get(p).add(a.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String p: unions.keySet()){
            List<String> cur = new ArrayList<>(unions.get(p));
            cur.add(0, own.get(p));
            res.add(cur);
        }
        return res;
    }
    
    private String getP(String w, Map<String, String> par){
        if (!w.equals(par.get(w))){
            w = getP(par.get(w), par);
        }
        return w;
    }
}
