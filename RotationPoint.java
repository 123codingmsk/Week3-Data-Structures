public class RotationPoint{

	public static int findRotationPoint(int[] arr, int left, int right){
		while(left < right){
			int mid = (left + right) / 2;
			if(arr[mid] > arr[right]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return arr[left];
	}

	public static void main(String[] a){
		int[] arr = {3,4,5,1,2};
		int n = arr.length;
		
		int left = 0;
		int right = n-1;
		
		int point = findRotationPoint(arr, left, right);
		System.out.println("The Rotation point is: "+point);
	}
}