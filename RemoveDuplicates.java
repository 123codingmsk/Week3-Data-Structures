import java.util.*;
public class RemoveDuplicates{
	public static void main(String[] a){
		String inp = "Deekshith";
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < inp.length(); i++){
			char ch = inp.charAt(i);
			if(!set.contains(ch)){
				set.add(ch);
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
}