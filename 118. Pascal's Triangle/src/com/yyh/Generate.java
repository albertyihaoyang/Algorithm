package com.yyh;
// Given numRows, generate the first numRows of Pascal's triangle.
import java.util.*;
public class Generate {

	public static void main(String[] args) {
		Generate my = new Generate();
		System.out.println(my.generate(6).toString());

	}

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        List<Integer> curRow = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        curRow.add(1);
        for (int i = 0; i < numRows; i++){
        	result.add(curRow);
        	lastRow = curRow;
        	curRow = new ArrayList<>();
        	curRow.add(1);
        	for (int j = 1; j < lastRow.size(); j++){
        		curRow.add(lastRow.get(j - 1) + lastRow.get(j));
        	}
        	curRow.add(1);
        }
        return result;
    }
}
