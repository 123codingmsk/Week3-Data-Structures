public class LargeDataset{
	
	public static long linearTime(int[] arr){
		long start = System.nanoTime();
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 3){
				break;
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
	
	public static long binaryTime(int[] arr){
		int l = 0;
		int r = arr.length-1;
		int target = 3;
		long start = System.nanoTime();
		
		while(l <= r){
			int mid = (l+r) / 2;
			if(arr[mid] == target){
				break;
			}else if(arr[mid] < target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		long end = System.nanoTime();
		return end - start;
	}
	
	public static void main(String[] a){
		int[] arr = new int[1000];
		int n = arr.length;
		arr[n-1] = 3;
		for(int i=0; i<=n-2; i++){
			arr[i] = 1;
		}
		long lt = linearTime(arr);
		long bt = binaryTime(arr);
		
		System.out.println(lt/ 1000000.0);
		System.out.println(bt/ 1000000.0);
	}
}