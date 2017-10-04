package com.yyh;
public class MySqrt {

	public static void main(String[] args){
		MySqrt my = new MySqrt();
		System.out.println(my.mySqrt(46340*46340));
		System.out.println(289398 * 289398);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.sqrt(2147395600));
	}
	public int mySqrt(int x) {
        int i = 0;
        while (i * i <= x && i * i >= 0){
            i++;
        }
        return i - 1;
    }
}
