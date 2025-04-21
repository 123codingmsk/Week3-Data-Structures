import java.io.*;

public class InputStreamReader2{
	public static void main(String[] a) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String filepath = "names.txt";
		FileWriter fr = new FileWriter(filepath);
		
		String line;
        System.out.println("Enter text (type 'exit' to quit):");
        while ((line = br.readLine()) != null){
            if (line.equalsIgnoreCase("exit")) break;
            fr.write(line + "\n");
        }
		fr.close();
        br.close();
	}
}