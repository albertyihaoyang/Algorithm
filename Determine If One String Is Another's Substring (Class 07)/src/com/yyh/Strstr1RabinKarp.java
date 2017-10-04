package com.yyh;

public class Strstr1RabinKarp {
	public static void main(String[] args){
		System.out.println(strstr("bcabc","ab"));
	}
	
	public static int strstr(String large, String small) {
	    if (small.length() == 0){
	    	return 0;
	    } else if (large.length() < small.length()) {
	    	return -1;
	    }
	    // We need a large prime as module end.
	    int largePrime = 101;
	    // We also need a small prime to calculate the hash value
	    // (since the charset would be very large, e.g. 1,112,064 for using UTF,
	    // we can not use that number).
	    int prime = 31;
	    int seed = 1;
	    // hash value is calculated using the samllPrime and taken the module operation on largePrime.
	    // has = (s0 * smallP ^ k + s1 * smallP ^ (k - 1) + ... + sk * smallP ^ 0) % largeP
	    int targetHash = small.charAt(0) % largePrime;
	    for (int i = 1; i < small.length(); i++){
	    	seed = moduleHash(seed, 0, prime, largePrime);
	    	targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
	    }
	    int hash = 0;
	    for (int i = 0; i < small.length(); i++){
	    	hash = moduleHash(hash, large.charAt(i), prime, largePrime);
	    }
	    if (hash == targetHash && equals(large, 0, small)){
	    	return 0;
	    }
	    for (int i = 1; i <= large.length() - small.length(); i++){
	    	// we need to make sure the module number is non-negative.
	    	hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
	    	hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);
	    	// Notice: If the hash matches, it does not mean we really find a substring match.
	    	// Because there is collision, we need to check if the substring really matches the small string.
	    	// On average, this will not increase the time complexity, the probability of collision
	    	// is O(1) so we still have O(M + N).
	    	if (hash == targetHash && equals(large, i, small)){
	    		return i;
	    	}
	    }
	    return -1;
	 }
	
	public static boolean equals(String large, int start, String small){
		for (int i = 0; i < small.length(); i++){
			if (large.charAt(i + start) != small.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public static int moduleHash(int hash, int addition, int prime, int largePrime){
		return (hash * prime % largePrime + addition) % largePrime;
	}
	
	public static int nonNegative(int hash, int largePrime) {
		if (hash < 0){
			hash += largePrime;
		}
		return hash;
	}
}
