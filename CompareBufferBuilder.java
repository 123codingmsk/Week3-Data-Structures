public class CompareBufferBuilder{

	public static void bufferString(String[] arr){
		StringBuffer sb = new StringBuffer();
		
		long start = System.nanoTime();
		for(int i=0; i<arr.length; i++){
			sb.append(arr[i]);
		}
		long end = System.nanoTime();
		System.out.println("Time taken by buffer: "+(end - start)+" ns");
	}
	
	public static void builderString(String[] arr){
		StringBuilder sb = new StringBuilder();
		
		long start = System.nanoTime();
		for(int i=0; i<arr.length; i++){
			sb.append(arr[i]);
		}
		long end = System.nanoTime();
		System.out.println("Time taken by builder: "+(end - start)+" ns");
	}
	
	public static void main(String[] a){
		String[] arr = {"Manoj", "Sai", "Kumar"};
		
		bufferString(arr);
		builderString(arr);
	}
}