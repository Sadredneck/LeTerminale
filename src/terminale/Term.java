package terminale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Term {
    private static Commandable commandable;

    private static void handleInput(String input) throws IllegalArgumentException {
        String[] elems = input.split("\\s+");
        System.out.println(elems.length);
        switch (Commands.valueOf(elems[0].toUpperCase())){
            case ALLFILES:
                commandable = new AllFiles(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case COPY:
            case EXIT:
            case HELP:
            case RENAME:
            case GETLOCATION:
                commandable = new GetLocation();
                commandable.doCommand();
                break;
            case CHANGELOCATION:
        }
    }

    public static void main(String[] args) {
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Terminalus Motherfucker!");
        while (true) {
            String line = "";
            try {
                line = inputLine.readLine();
                handleInput(line);
            } catch (IOException e) {
                System.out.println("Bizzare input.");
            }
            catch (IllegalArgumentException exc){
                System.out.println("wrong command");
            }
        }
    }
}
