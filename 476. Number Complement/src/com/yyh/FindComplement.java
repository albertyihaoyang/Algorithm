package com.yyh;

// Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation

public class FindComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindComplement my = new FindComplement();
		System.out.println(my.findComplement(5));
		System.out.println(my.findComplement(1));
	}

	public int findComplement(int num) {
        int com = 0;
        for (int i = 0; i < size(num); i++){
            com = com << 1 | 1;
        }
        return num ^ com;
    }
    
    private int size(int n){
        int size = 0;
        while (n > 0) {
            size++;
            n /= 2;
        }
        return size;
    }
}
