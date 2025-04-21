import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;

public class LargeFile{

	public static void fileReader(String fp) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fp));
		long start = System.nanoTime();
		int ch;
		while((ch = br.read()) != -1){
			sb.append((char) ch);
		}
		long end = System.nanoTime();
		br.close();
		System.out.println("FileReader timetaken: "+((end-start)/1000000.0)+" ms");
	}
	
	public static void inputStream(String fp){
		try{
			long start = System.nanoTime();
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fp));
			int ch;
			while((ch = isr.read()) != -1){
				continue;
			}
			long end = System.nanoTime();
			isr.close();
			System.out.println("InputStreamReader timetaken: "+((end-start)/1000000.0)+" ms");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] a) throws IOException{
		String filepath = "StringsRuntime.java";
		
		fileReader(filepath);
		inputStream(filepath);
	}
}