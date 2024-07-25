import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirFile {
    public static boolean mkdirFile(String file, String fire1) {
        File file2 = new File(file, fire1);
        return file2.mkdir();
    }

    public static boolean createFile(String file) {
        try {
            File myfile = new File(file);
            return myfile.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static void writerFile(String file, String text) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
