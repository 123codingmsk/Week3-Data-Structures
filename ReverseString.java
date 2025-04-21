public class ReverseString{
	public static void main(String[] a){
		String inp = "Manoj";
		StringBuilder sb = new StringBuilder();
		sb.append(inp);
		
		sb.reverse();
		sb.toString();
		System.out.println(sb);
	}
}