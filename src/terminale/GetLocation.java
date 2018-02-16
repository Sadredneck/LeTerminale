package terminale;

import java.nio.file.Path;

public class GetLocation implements Commandable {
    private Path location;

    public void setLocation(Path location) {
        this.location = location;
    }

    @Override
    public void doCommand() {
        System.out.println(location);
    }
}
