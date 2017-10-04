package com.yyh;

import java.util.Arrays;

/*
 * For a web developer, it is very important to know how to design a web page's size. 
 * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, 
 * whose length L and width W satisfy the following requirements:
 * 	1. The area of the rectangular web page you designed must equal to the given target area.
 * 	2. The width W should not be larger than the length L, which means L >= W.
 * 	3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 */
public class ConstructRectangle {

	public static void main(String[] args) {
		ConstructRectangle my = new ConstructRectangle();
		System.out.println(Arrays.toString(my.constructRectangle(9)));

	}

	public int[] constructRectangle(int area) {
        int[] result = new int[2];
        for (int i = 1; i * i <= area; i++){
            if (area % i == 0){
                result = new int[]{area / i, i};
            }
        }
        return result;
    }
}
