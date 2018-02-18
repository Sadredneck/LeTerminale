package terminale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Copy implements Commandable {
    private List<String> params;

    @Override
    public void doCommand() {
        Path copyFile = Paths.get(params.get(0));
        Path toFile = Paths.get(params.get(1));
        if (!copyFile.toFile().exists()) {
            System.out.println("The file doesn't exist");
            return;
        }
        if (!copyFile.isAbsolute())
            copyFile = Paths.get(ChangeLocation.getCurrentLocation().toString(), copyFile.toString());
        if (!toFile.isAbsolute())
            toFile = Paths.get(ChangeLocation.getCurrentLocation().toString(), toFile.toString());
        try {
            Files.copy(copyFile, toFile);
        } catch (IOException e) {
            System.out.println("Can't copy the file");
            return;
        }
        System.out.println("Copying successful");
    }

    public Copy() {
    }

    public Copy(String... params) {
        this.params = Arrays.asList(params);
    }
}
