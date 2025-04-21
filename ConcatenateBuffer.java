public class ConcatenateBuffer{
	public static void main(String[] a){
		String[] arr = {"Manoj", "Sai", "Kumar"};
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<arr.length; i++){
			sb.append(arr[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}