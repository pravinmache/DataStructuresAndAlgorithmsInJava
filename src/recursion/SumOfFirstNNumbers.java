package recursion;

public class SumOfFirstNNumbers {
	
	public static int sum(int n) {
		
		if(n == 1) return 1; //base case
		return n + sum(n-1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(sum(10));
		System.out.println(sum(100));
		System.out.println(sum(123));
		System.out.println(sum(1123));
		
	}
	
}
