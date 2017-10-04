package com.yyh;

// Reverse bits of integer

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits my = new ReverseBits();
		System.out.println(my.reverseBits(10));
	}

	public int reverseBits(int n){
		int dig = size(n) - 1;
		for (int i = 0; i <= dig / 2; i++){
			n = swapBits(n, i, dig - i);
		}
		return n;
	}
	
	private int swapBits(int n, int a, int b){
		int nA = n >> a & 1;
		int nB = n >> b & 1;
		if (nA == nB){
			return n;
		} else {
			n ^= ((1 << a) | (1 << b));
			return n;
		}
	}
	
	private int size(int n){
		int size = 0;
		while (n > 0){
			n /= 2;
			size++;
		}
		return size;
	}
}
