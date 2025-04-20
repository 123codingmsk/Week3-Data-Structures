public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int total_surplus = 0;
        int curr_surplus = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - distance[i];
            total_surplus += diff;
            curr_surplus += diff;

            // If current surplus is negative, reset start point
            if (curr_surplus < 0) {
                curr_surplus = 0;
                start = i + 1;
            }
        }

        return (total_surplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol =  {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No valid starting point found.");
        }
    }
}
