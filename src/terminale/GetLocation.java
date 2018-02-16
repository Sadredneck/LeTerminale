package terminale;


public class GetLocation implements Commandable {

    @Override
    public void doCommand() {
        System.out.println(ChangeLocation.getCurrentLocation());
    }

    public GetLocation(String... params) {
        if (params.length>0)
            System.out.println("This command doesn't need any params");
    }
}
