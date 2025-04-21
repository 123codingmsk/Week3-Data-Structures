import java.util.HashSet;
public class DSComparing{
	
	public static void linearArray(int[] arr, int n, int target){
		long start = System.nanoTime();
		for(int i=0; i<n; i++){
			if(arr[i] == target){
				break;
			}
		}
		long end = System.nanoTime();
		System.out.println("TimeTaken by ArraySearch: "+((end -start)/1000000.0)+" ms");
	}
	
	public static void hashSet(int[] arr, int n, int target){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<n; i++){
			set.add(arr[i]);
		}
		long start = System.nanoTime();
		boolean f = set.contains(target);
		long end = System.nanoTime();
		System.out.println("TimeTaken by ArraySearch: "+((end -start)/1000000.0)+" ms");
	}
	
	public static void main(String[] a){
		int[] arr = new int[1000];
		int n =arr.length;
		int target = 999;
		for(int i=0; i<n; i++){
			arr[i] = i;
		}
		linearArray(arr, n, target);
		hashSet(arr, n, target);
	}
}