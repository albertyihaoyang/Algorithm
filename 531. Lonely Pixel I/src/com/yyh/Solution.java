package com.yyh;
/*
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
*/
public class Solution {
	public int findLonelyPixel(char[][] picture) {
        int row = picture.length;
        int col = picture[0].length;
        int lonelyrow = 0;
        int lonelycol = 0;
        for (int i = 0; i < row; i++){
            int cur = 0;
            for (int j = 0; j < col; j++){
                if (picture[i][j] == 'B') cur++;
            }
            if (cur == 1) lonelyrow++;
        }
        for (int i = 0; i < col; i++){
            int cur = 0;
            for (int j = 0; j < row; j++){
                if (picture[j][i] == 'B') cur++;
            }
            if (cur == 1) lonelycol++;
        }
        return Math.min(lonelycol, lonelyrow);
    }
}
