package terminale;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (params.contains("-time")) {

        }
    }
}
