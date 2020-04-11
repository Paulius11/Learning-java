import java.nio.file.Path;
import java.nio.file.Paths;

public class JoinPathDemoAndRelativizedPath {
    public static void main(String[] args) {
        Path basicPath = Paths.get("C:/JavaProgramming");
        Path newPath = Paths.get("IO/Logs");
        System.out.println(basicPath.toString());
        Path basicPath2 = basicPath.resolve(newPath.toString()); // C:/JavaProgramming/IO/Logs
        Path newPath2 = newPath.resolve(basicPath.toString()); // C:/JavaProgramming/IO/Logs
        System.out.println(basicPath2.toString());
        System.out.println(newPath2.toString());


        Path p1 = Paths.get("C:/JavaProgramming/IO/Logs/errorLogs.txt"); // ps1 is the Absolute path
        Path p2 = Paths.get("C:/JavaProgramming/IO"); // p2 is the Base path
        Path p3 = p2.relativize(p1); // p3 is the Relative path
        System.out.println(p3);  // Logs/errorLogs.txt
    }
}