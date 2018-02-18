package terminale;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 1 on 18.02.2018.
 */
public class Rename implements Commandable{
    private List<String> params;

    @Override
    public void doCommand() {

    }

    public Rename(String...  params) {
        this.params = Arrays.asList(params);
    }

    public Rename() {
    }
}
