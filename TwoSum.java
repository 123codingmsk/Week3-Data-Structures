import java.util.*;

public class TwoSum{
	public static void main(String[] a){
		
		int[] arr = {10,20,12,14,13,11};
		int target = 30;
		
		int[] res = findTwoSum(arr, target);
		if(res != null){
			System.out.println("Indexes: "+res[0] + " " + res[1]);
			System.out.println("Values: "+arr[res[0]] + " "+arr[res[1]]);
		}else{
			System.out.println("No pair found");
		}
	}
	
	public static int[] findTwoSum(int[] arr, int target){
		Map<Integer, Integer> pairNum = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			int complement = target - arr[i];
			if(pairNum.containsKey(complement)){
				return new int[] {pairNum.get(complement), i}; 
			}
			pairNum.put(arr[i], i);
		}
		return null;
	}
}