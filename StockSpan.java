import java.util.*;
public class StockSpan{
	public static void main(String[] a){
		int[] arr = {7,4,5,10,6,8,1};
		Stack<Integer> store = new Stack<>();
		
		int maxDays = 0;
		int len = arr.length;
		for(int i=len-1; i>=0; i--){
			int count = 0;
			for(int j=i; j>=0; j--){
				if(arr[i] >= arr[j]){
					count++;
				}else{
					break;
				}
			}
			store.push(count);
		}
		System.out.print("[");
		while(!store.isEmpty()){
			System.out.print(store.peek()+", ");
			store.pop();
		}
		System.out.print("]");
	}
}