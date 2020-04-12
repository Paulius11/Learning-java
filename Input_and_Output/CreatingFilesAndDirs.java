import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingFilesAndDirs {
    public static void main(String[] args) throws IOException {
        Path dirPath = Paths.get("/home/sup/IdeaProjects/praktika/src/Input_and_Output/test");
        Path userFilesPath = Paths.get("UserFile.txt");
        Path settingsPath = Paths.get("Settings.txt");
        Path users, settings;
        users = checkFiles(dirPath, userFilesPath);
        settings = checkFiles(dirPath, settingsPath);
        if (users != null)
            displayFileStatus(users, settings);
        deleteFile(settings);
    }

    static Path checkFiles(Path dirPath, Path filePath) {
        // Checks path, if there is no dir or file create it
        Path absPath = dirPath.resolve(filePath);
        try {
            if (Files.notExists(dirPath))
                Files.createDirectories(dirPath);
            if (Files.notExists(absPath))
                Files.createFile(absPath);
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
        return absPath;
    }

    static void displayFileStatus(Path users, Path settings) throws IOException {
        System.out.println("Readable : " + Files.isReadable(users));
        System.out.println("Writeable : " + Files.isWritable(users));
        System.out.println("Executable: " + Files.isExecutable(users));
        System.out.println("Hidden : " + Files.isHidden(users));
        System.out.println("Same files: " + Files.isSameFile(users, settings));
    }

    static void deleteFile(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println(filePath.toString() + " deleted!");
            } else
                System.out.println(filePath.toString() + "not found");
        } catch (DirectoryNotEmptyException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
