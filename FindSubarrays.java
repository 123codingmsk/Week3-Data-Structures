import java.util.*;

public class FindSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int startIdx : indices) {
                    result.add(new int[]{startIdx + 1, i}); 
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (int[] pair : subarrays) {
            int start = pair[0], end = pair[1];
            System.out.print("Subarray from index " + start + " to " + end + "-->");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
