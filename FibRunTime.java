public class FibRunTime{

	public static void iterativeFib(int n){
		int a = 0, b = 1, sum;
		
		long start = System.nanoTime();
		System.out.print(a+" "+b+" ");
		for(int i=2; i<=n; i++){
			sum = a+b;
			a=b;
			b=sum;
			System.out.print(b+" ");
		}
		System.out.println();
		long end = System.nanoTime();
		
		System.out.println("Iterative Time: "+((end-start)/ 1000000.0)+" ms");
	}
	
	public static void recursiveFib(int n) {
		long start = System.nanoTime();
		int result = fibonacci(n);
		long end = System.nanoTime();

		System.out.println("Fibonacci of " + n +" = "+ result);
		System.out.println("Recursive Time: " + ((end - start) / 1000000.0) + " ms");
	}

	public static int fibonacci(int n) {
		if (n <= 1) return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}


	public static void main(String[] a){
		int num = 10;
		iterativeFib(num);
		recursiveFib(num);
	}
}