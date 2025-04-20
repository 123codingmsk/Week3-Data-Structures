import java.util.*;

public class TwoSumPairs{
	public static void main(String[] a){
		
		int[] arr = {10,20,12,14,13,11,19};
		int target = 30;
		
		List<int[]> result = findTwoSum(arr, target);
		if(!result.isEmpty()){
			for (int[] pair : result) {
				System.out.println("Values that add to target: " + arr[pair[0]] + " " + arr[pair[1]]);
			}
		}else{
			System.out.println("No pair found");
		}
	}
	
	public static List<int[]> findTwoSum(int[] arr, int target){
		Map<Integer, Integer> pairNum = new HashMap<>();
		List<int[]> res = new ArrayList<>();
		for(int i=0; i<arr.length; i++){
			int complement = target - arr[i];
			if(pairNum.containsKey(complement)){
				res.add(new int[] {pairNum.get(complement), i}); 
			}
			pairNum.put(arr[i], i);
		}
		return res;
	}
}