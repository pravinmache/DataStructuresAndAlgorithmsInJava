package recursion;

public class Factorials {
	
	public static long factorial(int n) {
		if(n == 1 || n == 0)  return 1; //base case
		
		
		return n * factorial(n-1);
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(6));
		System.out.println(factorial(7));
		System.out.println(factorial(8));
		System.out.println(factorial(9));
		System.out.println(factorial(10));
	}

}
