package terminale;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class AllFiles implements Commandable {
    private List<String> params;

    public AllFiles(String...  params) {
        if (params.length>2)
            System.out.println("Too many parameters. The max is 1");
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
        for (File f : files) {
            try {
                attr.add(Files.getFileAttributeView(f.toPath(),
                        BasicFileAttributeView.class).readAttributes());
            } catch (IOException e) {
                System.out.println("Can't get creation time of files");
            }
        }
        if (params.contains("-time")) {
            Collections.sort(files, new ComparatorByTime());
            for (File f : files)
                System.out.println(f.getName()+" "+attr.get(files.indexOf(f)).creationTime());
        }
        else if (params.contains("-name")) {
            Collections.sort(files, new ComparatorByName());
            for (File f : files)
                System.out.println(f.getName()+" "+attr.get(files.indexOf(f)).creationTime());
        } else {
            for (File f : files)
                System.out.println(f.getName()+" "+attr.get(files.indexOf(f)).creationTime());
        }

    }

    class ComparatorByTime implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            BasicFileAttributes view1 = null;
            BasicFileAttributes view2 = null;
            try {
                view1 = Files.getFileAttributeView(o1.toPath(),
                        BasicFileAttributeView.class).readAttributes();
                view2 = Files.getFileAttributeView(o2.toPath(),
                        BasicFileAttributeView.class).readAttributes();
            } catch (IOException e) {
                System.out.println("Can't get creation time of files");
            }
            if (view1.creationTime().toMillis()>view2.creationTime().toMillis()) return 1;
            return -1;
        }
    }

    class ComparatorByName implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            Comparator<String> c = Comparator.comparing((String x) -> x);
            return c.compare(o1.getName(), o2.getName());
        }
    }
}
