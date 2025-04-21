public class FirstLastOcc{

	public static int[] findFirstLastIndex(int[] arr, int target){
		int l = 0;
		int r = arr.length-1;
		
		int firstIndex = -1;
		int lastIndex = -1;
		
		while(l <= r && (firstIndex == -1 || lastIndex == -1)){
			int mid = (l + r) / 2;
			if(arr[mid] == target){

				if(firstIndex == -1){
					int index = mid;
					while(index >= 0 && arr[index] == target){
						index--;
					}
					firstIndex = index + 1;
				}
				if(lastIndex == -1){
					int index = mid;
					while(index < arr.length && arr[index] == target){
						index++;
					}
					lastIndex = index - 1;
				}
			}else if(arr[mid] < target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		return new int[] {firstIndex, lastIndex};
	}

	public static void main(String[] a){
		int[] arr = {1,1,2,3,3,4,4,5,5,5,6};
		int target = 2;
		
		int[] res = findFirstLastIndex(arr, target);
		System.out.println(res[0]+" "+res[1]);
	}
}