import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreams {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    
}
