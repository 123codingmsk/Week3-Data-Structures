import java.util.Arrays;
public class SortingRuntime{

	public static void bubble(int[] arr, int n){
		
		long start = System.nanoTime();
		
		for(int i=0; i<n-1; i++){
			boolean swap = false;
			for(int j=0; j<n-i-1; j++){
				if(arr[j] > arr[j+1]){
					swap = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;	
				}
			}
			if(!swap) break;
		}
		long end = System.nanoTime();
		System.out.println("Bubble sort time taken: "+((end - start)/1000000.0)+" ms");
	}
	
	public static void merge(int[] arr){
		long start = System.nanoTime();
		Arrays.sort(arr);
		long end = System.nanoTime();
		System.out.println("Merge sort time taken: "+((end - start)/1000000.0)+" ms");
	}
	
	public static void quick(int[] arr){
		long start = System.nanoTime();
		Arrays.sort(arr);
		long end = System.nanoTime();
		System.out.println("Quick sort time taken: "+((end - start)/1000000.0)+" ms");
	}

	public static void main(String[] a){
		int[] arr = new int[1000];
		int n = arr.length;
		int value = n;
		for(int i=0; i<n; i++){
			arr[i] = value;
			value--;
		}
		
		bubble(arr, n);
		merge(arr);
		quick(arr);
	}
}