package terminale;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AllFiles implements Commandable {
    private List<String> params;

    public AllFiles(String...  params) {
        this.params = Arrays.asList(params);
    }

    public AllFiles() {
    }

    @Override
    public void doCommand() {
        File[] filestemp = new File[100];
        filestemp = ChangeLocation.getCurrentLocation().toFile().listFiles();
        ArrayList<File> files = new ArrayList<>(Arrays.asList(filestemp));
        ArrayList<BasicFileAttributes> attr = new ArrayList<>();
        if (params.contains("-time")) {
            files.sort();
        }
    }

    public static Comparator<File>  {

    }
}
