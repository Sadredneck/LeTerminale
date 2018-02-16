package terminale;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeLocation implements Commandable {
    private static Path toLocation;
    private static Path currentLocation;

    public ChangeLocation() {
        System.out.println("Print the location to change");
    }

    public ChangeLocation(String... toLocation) {
        ChangeLocation.toLocation = Paths.get(toLocation[0]);
    }

    public static Path getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void doCommand() {
        if (toLocation.isAbsolute()) {
            ChangeLocation.currentLocation = toLocation;
        } else {
            ChangeLocation.currentLocation = Paths.get(ChangeLocation.currentLocation.toString(),
                    toLocation.toString());
        }
        System.out.println("Location has been changed");
    }
}
