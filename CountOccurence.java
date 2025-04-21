import java.io.*;
import java.util.*;

public class CountOccurence{
	
	private static int readWordsFromFile(String filepath, String target){
		int length = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;
			while((line = br.readLine()) != null){
				String[] words = line.split("\\W+"); 
                for (String word : words) {
                    if (word.equals(target)) {
                        length++;
                    }
                }
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return length;
	}
	
	public static void main(String[] a){
		String filepath = "CompareBufferBuilder.java";
		String target = "String";
		
		int len = readWordsFromFile(filepath, target);
		if(len == 0){
			System.out.println("No content in this file");
			return;
		}
		System.out.println("Count of "+target+": "+len);
	}
}