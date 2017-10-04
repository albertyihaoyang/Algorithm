package com.yyh;

public class FindNthDigit {

	public static void main(String[] args) {
		FindNthDigit my = new FindNthDigit();
		System.out.println(my.findNthDigit(1000000));
	}

	public int findNthDigit(int n) {
        int i = 1;
        int idx = 1;
        while (true){
        	int len = (int)(Math.log(i) / Math.log(10)) + 1;
            if (idx + len <= n){
            	idx += len;
            } else {
            	int[] cur = breakNum(i);
            	return cur[n - idx];
            }
            i++;
        }
    }
    
    public int[] breakNum(int num){
        int[] digit = new int[(int)(Math.log(num) / Math.log(10)) + 1];
        for (int i = digit.length - 1; i >= 0; i--){
            digit[i] = num % 10;
            num /= 10;
        }
        return digit;
    }
}
