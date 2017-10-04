package com.yyh;

public class NthUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthUglyNumber my = new NthUglyNumber();
		System.out.println(my.nthUglyNumber(10));
	}

	public int nthUglyNumber(int n) {
        int num = 1;
        while (n > 0) {
            if (isUgly(num++)){
                n--;
            }
        }
        return num - 1;
    }
    
    private boolean isUgly(int num) {
        if (num <= 0){
            return false;
        }
        while (num % 2 == 0){
            num /= 2;
        }
        while (num % 3 == 0){
            num /= 3;
        }
        while (num % 5 == 0){
            num /= 5;
        }
        return num == 1;
    }
}
