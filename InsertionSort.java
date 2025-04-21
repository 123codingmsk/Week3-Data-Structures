import java.util.*;
public class InsertionSort{

	public static void sort(int[] arr){
		int n = arr.length;
		for(int i=1; i<n; i++){
			int temp = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > temp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] a){
		int[] arr = {3,4,5,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}