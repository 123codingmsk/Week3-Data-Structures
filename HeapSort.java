import java.util.*;
public class HeapSort{

	 public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;      // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	public static void main(String[] a){
		int[] arr = {3,4,5,2,1};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}