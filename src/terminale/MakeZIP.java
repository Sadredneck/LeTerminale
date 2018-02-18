package terminale;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MakeZIP implements Commandable {
    private List<String> params;

    public MakeZIP(String... params) {
        this.params = Arrays.asList(params);
    }

    public MakeZIP() {
    }

    @Override
    public void doCommand() {
        if (params.size() != 1) {
            System.out.println("You need only one parameter");
            return;
        }
        Path source = Paths.get(params.get(0));
        File file;
        if (source.isAbsolute())
            file = source.toFile();
        else
            file = Paths.get(ChangeLocation.getCurrentLocation().toString(), source.toString()).toFile();
        if (!file.exists()) {
            System.out.println("File doesn't exist.");
            return;
        }
        try {
            FileOutputStream f = new FileOutputStream(file.getName() + ".zip");
            ZipOutputStream out = new ZipOutputStream(f);
            doZip(file, "", out);
            out.close();
        } catch (IOException exc) {
            System.out.println("Can't create zip");
        }
    }

    private void doZip(File file, String fileName, ZipOutputStream out) throws IOException {
        if (file.isHidden()) {
            return;
        }
        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
                doZip(innerFile, fileName + "/" + innerFile.getName(), out);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(fileName);
        out.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            out.write(bytes, 0, length);
        }
        fis.close();
    }
}
