import java.io.File;
import java.io.IOException;

public class DeleteFile {

    public static void deleteFile(String file) {
        File file1 = new File(file);
        file1.delete();
    }
}
