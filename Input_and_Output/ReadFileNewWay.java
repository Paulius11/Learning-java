import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ReadFileNewWay {
    public static final String FILENAME = "/home/sup/IdeaProjects/praktika/src/empl.txt";
    public static final String WRITE_FILENAME = "/home/sup/IdeaProjects/praktika/src/written.txt";

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        writeFromFileTo(list);
        displayLines(list);
        writeFile(list);
    }

    private static void writeFile(ArrayList<String> listOfLines) {
        Path path = Paths.get(WRITE_FILENAME);
        try {
            BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            for (String line: listOfLines)
            {
             bw.write(line);
             bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }
    }

    static void displayLines(ArrayList<String> listOfText) {
        for (String line: listOfText) {
            System.out.println(line);
        }
    }
    static void writeFromFileTo(ArrayList<String> lineList) {
        String line = "";
        Path path = Paths.get(FILENAME);
        try {
            BufferedReader fileInput = Files.newBufferedReader(path, Charset.defaultCharset());
            while (line != null){
                lineList.add(line);
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
