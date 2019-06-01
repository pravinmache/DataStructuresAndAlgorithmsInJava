package recursion;


/*
 * 
 * for number n sum of powers will be 1 ^ 1+ 2 ^ 2+ 3 ^ 3......n ^ n
 */
public class SumOfPowers {
	
	
	public static long powerSum(int n) {
		
		if(n == 1) return 1;
		
		return (long) (Math.pow(n, n) + powerSum(n-1)); 
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(powerSum(6));
		System.out.println(powerSum(1));
		System.out.println(powerSum(2));
		System.out.println(powerSum(3));
		
	}

}
