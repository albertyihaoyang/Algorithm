package com.yyh;
// Count the number of prime numbers less than a non-negative number, n.
public class CountPrime2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrime2 my = new CountPrime2();
		System.out.println(my.countPrimes(150000000));
	}

	public int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		for (int i = 2; i < n; i++){
			prime[i] = true;
		}
		for (int i = 2; i * i < n; i++){
			if (!prime[i]){
				continue;
			}
			for (int j = i * i; j < n; j += i){
				prime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++){
			if (prime[i]){
				count++;
			}
		}
		return count;
    }
    
}
