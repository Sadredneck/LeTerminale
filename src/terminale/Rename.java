package terminale;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Rename implements Commandable {

    final public String tutorial = "RENAME + oldName + newName";

    private List<String> params;

    public Rename(String... params) {
        this.params = Arrays.asList(params);
    }

    public Rename() {
    }

    @Override
    public void doCommand() {
        if (params.size() != 2) {
            System.out.println("You need only 2 parameters.");
            return;
        }

        Path from = Paths.get(params.get(0));
        Path to = Paths.get(params.get(1));

        if (!from.isAbsolute()) {
            from = Paths.get(ChangeLocation.getCurrentLocation().toString(),
                    from.toString());
        }
        if (!to.isAbsolute()) {
            to = Paths.get(ChangeLocation.getCurrentLocation().toString(),
                    to.toString());
        }
        try {
            Files.move(from, to);
        } catch (IOException exc) {
            System.out.println("Can't rename file.");
            return;
        }
        System.out.println("Rename successful.");
    }

    private void rename(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (newFile.exists()) {
            System.out.println("File with new name already exist.");
            return;
        }
        if (!oldFile.renameTo(newFile)) {
            System.out.println("Can't rename.");
        }
    }
}
