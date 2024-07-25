import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SaveGame {
    public static void saveGame(String id, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(id);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String wayZip, String[] wayfile) {
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(wayZip));

            for (String file : wayfile) {
                File myFile = new File(file);
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(myFile.getName());
                byte[] buffer = new byte[fis.available()];
                zout.putNextEntry(entry);
                int count = 0;
                while ((count = fis.read(buffer)) != -1) {
                    zout.write(buffer, 0, count);
                }
                zout.flush();
                fis.close();
            }
            zout.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}