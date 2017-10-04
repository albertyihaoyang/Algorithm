package com.yyh;
import java.util.*;
// Given an index k, return the kth row of the Pascal's triangle.
public class GetRow {

	public static void main(String[] args){
		GetRow my = new GetRow();
		System.out.println(my.getRow(5).toString());
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        curRow.add(1);
        if (rowIndex == 0){
            return curRow;
        }
        for (int i = 0; i < rowIndex; i++){
        	lastRow = curRow;
        	curRow = new ArrayList<>();
        	curRow.add(1);
        	for (int j = 1; j < lastRow.size(); j++){
        		curRow.add(lastRow.get(j - 1) + lastRow.get(j));
        	}
        	curRow.add(1);
        }
        return curRow;
    }
}
