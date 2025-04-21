import java.util.Arrays;
public class LinearBinary {

    public static int findMissing(int[] arr){
        int[] res = new int[8];
        res[0]=-1;
        for(int i=0; i<arr.length; i++){
            int m = arr[i];
            res[m] = -1;
        }
        for(int i =0; i<res.length; i++){
            if(res[i]==0){
                return i;
            }
        }
        return 0;
    }

    public static boolean findTarget(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]<target){
                l = mid+1;
            }
            else if(arr[mid]>target){
                r = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {5,1,2,3,7,6};//5
        System.out.println(findMissing(arr));
        Arrays.sort(arr);
        if(findTarget(arr, 7)) System.out.println("Found");
        else System.out.println("Not found");
    }
}