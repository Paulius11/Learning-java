import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
    public static final String FILENAME = "/home/sup/IdeaProjects/praktika/src/empl.txt";
    public static void main(String[] args) {


        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(FILENAME);
        System.out.println("Default Dir [" + path + "]"); //Default Dir [/home/sup/IdeaProjects/praktika/src/empl.txt]
        System.out.println(path.getFileName()); // empl.txt
        System.out.println(path.getParent()); // /home/sup/IdeaProjects/praktika/src
        System.out.println(path.getNameCount()); // 6
        System.out.println(path.isAbsolute()); // true
        System.out.println(path.toAbsolutePath()); // /home/sup/IdeaProjects/praktika/src/empl.txt
        System.out.println(path.toUri()); // file:///home/sup/IdeaProjects/praktika/src/empl.txt

        Path rp = Paths.get("/home/sup/IdeaProjects/praktika/src/..");
        System.out.println("rp.normalize() [" + rp.normalize() + "]"); // rp.normalize() [/home/sup/IdeaProjects/praktika]
        System.out.println("rp.normalize() [" + rp.getNameCount() + "]"); // 6 Number of name elements in the path.
        System.out.println("rp.normalize() [" + rp.subpath(0,2) + "]"); // rp.normalize() [/home/sup/]

    }
}
