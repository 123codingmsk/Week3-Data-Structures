public class FirstNegNum{

	public static int searchForNegNum(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i] < 0){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] a){
		int[] arr = {2,3,4,5,-1,0};
		
		int index = searchForNegNum(arr);
		if(index == -1){
			System.out.println("No negative number is found!");
			return;
		}
		System.out.println(index);
	}
}