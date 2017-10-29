package com.yyh;
/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Set<Integer>> rowMap = new HashMap<>();
        Map<Character, Set<Integer>> colMap = new HashMap<>();
        Map<Character, Set<Integer>> nineMap = new HashMap<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                char ch = board[i][j];
                if (ch == '.'){
                    continue;
                }
                Set<Integer> curRow = rowMap.get(ch);
                Set<Integer> curCol = colMap.get(ch);
                Set<Integer> curNine = nineMap.get(ch);
                if (curRow != null){
                    if (curRow.contains(i)){
                        return false;
                    }
                    curRow.add(i);
                } else {
                    curRow = new HashSet<>();
                    curRow.add(i);
                    rowMap.put(ch, curRow);
                }
                if (curCol != null){
                    if (curCol.contains(j)){
                        return false;
                    }
                    curCol.add(j);
                } else {
                    curCol = new HashSet<>();
                    curCol.add(j);
                    colMap.put(ch, curCol);
                }
                int nine = i / 3 * 3 + j / 3;
                if (curNine != null){
                    if (curNine.contains(nine)){
                        return false;
                    }
                    curNine.add(nine);
                } else {
                    curNine = new HashSet<>();
                    curNine.add(nine);
                    nineMap.put(ch, curNine);
                }
            }
        }
        return true;
    }
}