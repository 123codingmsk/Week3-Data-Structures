import java.util.*;

public class LongestConsecutiveSeq{
	public static void main(String[] a){
		int[] arr = {1,3,4,5,2,0,9,10};
		
		int res = findLongestSeq(arr);
		
		System.out.println("Longest Consecutive Sequence: "+res);
		
	}
	
	public static int findLongestSeq(int[] arr){
		Map<Integer, Boolean> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++){
			map.put(arr[i], true);
		}
		
		for (int num : arr) {
            if (map.containsKey(num - 1)) {
                map.put(num, false); 
            }
        }
		
		int maxlength = 0;
		
		for (int num : map.keySet()) {
            if (map.get(num)) { 
                int currentNum = num;
                int currentStreak = 1;

                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxlength = Math.max(maxlength, currentStreak);
            }
        }
		return maxlength;
	}
}