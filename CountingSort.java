import java.util.*;
public class CountingSort{

	public static void sort(int[] arr){
		int max = arr[0];
		//find max element
		for(int num : arr){
			if(num > max) max = num;
		}
		
		//declare count arr, think as map
		int[] count = new int[max + 1];
		
		for(int num : arr){
			count[num]++;
		}
		
		int index = 0;
		//again imagine map
		for(int i=0; i<=max; i++){
			while(count[i] > 0){
				arr[index++] = i;
				count[i] = 0;
			}
		}
	}
	
	public static void main(String[] a){
		int[] arr = {3,4,5,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}