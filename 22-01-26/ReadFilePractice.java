import java.io.File;
import java.util.Scanner;
public class ReadFilePractice {
    public static void main(String[] args) {
        try {
            File myFile = new File("File.txt");
            Scanner fileReader = new Scanner(myFile);

            while (fileReader.hasNext()) {
                String data = fileReader.next();
                System.out.println(data);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }
}
