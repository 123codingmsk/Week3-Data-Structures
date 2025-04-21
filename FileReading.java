import java.util.*;
import java.io.*;

public class FileReading{
	
	private static String readWordsfromFile(String filePath){
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null){
				sb.append(line).append(" ");
			}
			return sb.toString();
		}catch(IOException e){
			e.printStackTrace();
		}
		br.close();
		return null;
	}
	
	public static void main(String[] a){
		String filePath = "CompareBufferBuilder.java";
		
		String content = readWordsfromFile(filePath);
		if (content == null) {
            System.out.println("Error reading the file.");
            return;
        }
		String[] words = content.split("\\s+"); // Splitting by whitespace
		System.out.println("Words in file:");
		for (String word : words) {
			System.out.println(word);
		}
	}
}