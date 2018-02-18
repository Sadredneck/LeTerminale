package terminale;

public class Help implements Commandable{

    private String help = "Command: {ALLFILES} + Parameters: {{-name}, {-time}, none}\n" +
            "Command: {CHANGELOCATION} + Parameters: {absolute or relative path}\n" +
            "Command: {GETLOCATION} + Parameters: none\n" +
            "Command: {COPY} + Parameters: {{absolute or relative path}, {absolute or relative path}}\n" +
            "Command: {RENAME} + Parameters: {{absolute or relative path}, {absolute or relative path}}\n" +
            "Command: {HELP} + Parameters: none\n" +
            "Command: {MAKEZIP} + Parameters: {{absolute or relative path}, {absolute or relative path}}\n" +
            "Command: {EXIT} + Parameters: none";

    public Help(){

    }

    public Help (String... args){

    }

    @Override
    public void doCommand() {
        System.out.println(help);
    }
}
