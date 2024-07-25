import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        StringBuilder logger = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add("src");
        list.add("res");
        list.add("savegames");
        list.add("temp");
        for (String file : list) {
            if (DirFile.mkdirFile("C://Games", file)) {
                logger.append("Каталог создан.");
            }
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("drawables");
        list1.add("vectors");
        list1.add("icons");
        for (String file : list1) {
            if (DirFile.mkdirFile("C://Games/res", file)) {
                logger.append("Подкаталог создан.");
            }
        }

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("main");
        list3.add("test");
        for (String file : list3) {
            if (DirFile.mkdirFile("C://Games/src", file)) {
                logger.append("Подкаталог создан.");
            }
        }

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("C://Games/src/main/Utils.java");
        list2.add("C://Games/src/main/Main.java");
        list2.add("C://Games/temp/temp.txt");

        for (String file : list2) {
            if (DirFile.createFile(file)) {
                logger.append("Файл был создан.");
            }
        }
        String resylt = logger.toString();
        DirFile.writerFile("C://Games/temp//temp.txt", resylt);

        GameProgress gameProgress1 = new GameProgress(10, 20, 40, 15.4);
        GameProgress gameProgress2 = new GameProgress(15, 14, 90, 28.5);
        GameProgress gameProgress3 = new GameProgress(14, 50, 91, 63.4);

        SaveGame.saveGame("C://Games/savegames/save.dat", gameProgress2);
        SaveGame.saveGame("C://Games/savegames/save1.dat", gameProgress1);
        SaveGame.saveGame("C://Games/savegames/save2.dat", gameProgress3);

        String[] myfile = {
                "C://Games/savegames/save.dat",
                "C://Games/savegames/save1.dat",
                "C://Games/savegames/save2.dat",
        };
        SaveGame.zipFiles("C://Games/savegames/save.zip", myfile);

        DeleteFile.deleteFile("C://Games/savegames/save.dat");
        DeleteFile.deleteFile("C://Games/savegames/save1.dat");
        DeleteFile.deleteFile("C://Games/savegames/save2.dat");
    }
}