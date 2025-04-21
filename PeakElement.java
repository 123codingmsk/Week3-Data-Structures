public class PeakElement{
	public static void main(String[] a){
		int[] arr = {2,3,5,1,7,4};
		int n = arr.length;
		int left = 0;
		int right = n-1;
		while(left < right){
			int mid = (left + right) / 2;
			if(arr[mid] < arr[mid+1]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		System.out.println("Peak Element is: "+arr[left]);
	}
}