package com.yyh;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * 	return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits my = new ReverseBits();
		System.out.println(my.reverseBits(43261596));
	}

	public int reverseBits(int n) {
        for (int i = 0; i < 16; i++){
            n = swap(n, i, 31 - i);
        }
        return n;
    }
    
    private int swap(int n, int a, int b){
        int nA = (n >> a & 1);
        int nB = (n >> b & 1);
        if (nA == nB){
            return n;
        } 
        return (n ^ ((1 << a) | (1 << b)));
    }
}
