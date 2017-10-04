package laioffer;

public class GoldbachConjecture {

	public static void main(String[] args) {
		new Goldbach().check();
	}
}
class Goldbach{
	public void check(){
		for (int i = 4;i < 100000000; i += 2){
			if (!checkEvenNumber(i)) {
				System.out.println("Congratulations!");
				break;
			}
			if (i % 10000 == 0) {
				System.out.println("Holds <= "+i);
			}
		}
	}
	private boolean isPrime(int n){
		for (int k = 2; k * k < n; n++){
			if (n % k == 0){
				return false;
			}
		}
		return true;
	}
	private boolean checkEvenNumber(int n){
		for (int i = 2; i <= n/2; i++){
			if (isPrime(i) && isPrime(n-i)){
				return true;
			}
		}
		return false;
	}
}