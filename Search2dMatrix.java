public class Search2dMatrix{

	public static boolean search(int[][] arr, int rows, int cols, int target){
		int l = 0;
		int r = cols-1;
		for(int i=0; i<rows; i++){
			while(l <= r){
				int mid  = (l+r) / 2;
				if(arr[i][mid] == target){
					return true;
				}else if(arr[i][mid] < target){
					l = mid + 1;
				}else{
					r = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] a){
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int rows = arr.length;
		int cols = arr[0].length;
		int target = 10;
		
		boolean found = search(arr, rows, cols, target);
		System.out.println(found);
	}
}