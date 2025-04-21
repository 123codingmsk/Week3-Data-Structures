
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class InputStreamReader1 {
    public static void main(String[] args) throws IOException{
        String filepath = "CompareBufferBuilder.java";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath));
        int ch;
        while((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        isr.close();
    }
}

