import java.io.*;
import java.util.ArrayList;

public class ReadFileOldWay {

    public static final String FILENAME = "/home/sup/IdeaProjects/praktik/src/empl.txt";

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        readFileToList(list);
        displayText(list);
    }
    public static void writeFile(ArrayList<String> employees) {
    }
    static void displayText(ArrayList<String> listOfLines) {
        for(String line: listOfLines)
            System.out.println(line);

    }

    static void readFileToList(ArrayList<String> listOfLines) {
        String line = "";
        BufferedReader fileInput = null;
        try {
            fileInput = new BufferedReader(new FileReader(new File(FILENAME)));
            line = fileInput.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = fileInput.readLine();
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (EOFException eofe) {
            System.out.println("No more lines to read.");
        }
        catch (IOException ioe) {
            System.out.println("Error reading file.");
        }
    }

}
