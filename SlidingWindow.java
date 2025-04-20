public class SlidingWindow {
    public static void main(String[] a) {
        int[] arr = {1, 3, 2, 5, 4, 6};
        int window_size = 3;
        int len = arr.length;

        if (window_size > len) {
            System.out.println("Window size larger than array length");
            return;
        }

        int[] large = new int[len - window_size + 1];

        for (int i = 0; i <= len - window_size; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + window_size; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            large[i] = max;
        }

        for (int i = 0; i < large.length; i++) {
            System.out.print(large[i] + " ");
        }
    }
}
