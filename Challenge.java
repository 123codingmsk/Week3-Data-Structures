import java.io.*;

public class Challenge{

	public static void bufferString(String[] arr){
		StringBuffer sb = new StringBuffer();
		
		long start = System.nanoTime();
		for(int i=0; i<=1000000; i++){
			sb.append(arr[i]);
		}
		long end = System.nanoTime();
		System.out.println("Time taken by buffer: "+(end - start)+" ns");
	}
	
	public static void builderString(String[] arr){
		StringBuilder sb = new StringBuilder();
		
		long start = System.nanoTime();
		for(int i=0; i<=1000000; i++){
			sb.append(arr[i]);
		}
		long end = System.nanoTime();
		System.out.println("Time taken by builder: "+(end - start)+" ns");
	}
	
	public static void fileReading() throws IOException{
		String filepath = "InputStreamReader2.java";
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String ch;
		long start = System.nanoTime();
		int len = 0;
		while((ch = br.readLine()) != null){
			String[] words = ch.split(" ");
			len += words.length;
		}
		long end = System.nanoTime();
		long timeTaken = end - start;
		System.out.println("Length: "+len+" TimeTaken: "+timeTaken);
		br.close();
		fr.close();
	}
	
	public static void inputFile() throws IOException{
		String filepath = "names.txt";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		FileWriter fw = new FileWriter(filepath);
		
		System.out.println("Enter text (type 'exit' to quit):");
		String line;
        while ((line = br.readLine()) != null){
            if (line.equalsIgnoreCase("exit")) break;
            fw.write(line + "\n");
        }
		fw.close();
		
		BufferedReader fr = new BufferedReader(new FileReader(filepath));
		int len = 0;
		long start = System.nanoTime();
		while((line = fr.readLine())!=null){
			String[] words = line.split(" ");
			len += words.length;
		}
		long end = System.nanoTime();
		br.close();
		long timeTaken = end - start;
		System.out.println("Length: "+len+" TimeTaken: "+timeTaken);
	}
	
	public static void main(String[] a)throws IOException{
		
		String[] arr = new String[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "a";
        }
		
		bufferString(arr);
		builderString(arr);
		fileReading();
		inputFile();
		
	}
}