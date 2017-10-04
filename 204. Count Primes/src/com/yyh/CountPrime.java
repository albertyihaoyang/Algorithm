package com.yyh;
// Count the number of prime numbers less than a non-negative number, n.
public class CountPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrime my = new CountPrime();
		System.out.println(my.countPrimes(1500000));
	}

	public int countPrimes(int n) {
        int total = 0;
        for (int i = 2; i < n; i++){
            if (isPrime(i)){
                total++;
            }
        }
        return total;
    }
    
    private boolean isPrime(int n){
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
