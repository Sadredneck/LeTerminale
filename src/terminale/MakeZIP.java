package terminale;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        Path source = Paths.get(params.get(0));
        File file;
        if (source.isAbsolute())
            file = source.toFile();
        else
            file = Paths.get(ChangeLocation.getCurrentLocation().toString(), source.toString()).toFile();
        if (!file.exists()){
            System.out.println("File doesn't exist.");
            return;
        }
       try {
            File f = new File(file.getName() + ".zip");
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry(file.getName());
            out.putNextEntry(e);

            byte[] data = file.toString().getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();

            out.close();
        }
        catch (IOException exc){
            System.out.println("Can't create zip");
        }
    }
}
