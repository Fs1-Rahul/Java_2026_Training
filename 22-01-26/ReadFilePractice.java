import java.io.File;
import java.util.Scanner;
public class ReadFilePractice {
    public static void main(String[] args) {
        try {
            File myFile = new File("File.txt");
            Scanner fileReader = new Scanner(myFile);
            String content = "";
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
                content += data + "\n";
            }
            for(int i=0;i<content.length();i++){
                char ch = content.charAt(i);
                if(ch=='.'){
                    System.out.println("Period found at index: " + i);
                }
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }
}
