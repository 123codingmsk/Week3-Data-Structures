public class SearchWordInSentence{

	public static void searchWord(String[] arr, String target){
		boolean found = false;
		for(int i=0; i<arr.length; i++){
			if(arr[i].contains(target)){
				found = true;
				System.out.println(arr[i]);
				return;
			}
		}
		if(!found){
			System.out.println("not found!");
			return;
		}
	}

	public static void main(String[] a){
		String[] arr = {"Manoj Sai Kumar", "Sai Baba"};
		String target = "Man";
		
		searchWord(arr, target);
	}
}