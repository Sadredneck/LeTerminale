package terminale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static terminale.Commands.ALLFILES;
import static terminale.Commands.COPY;

public class Term {

    private static void handleInput(String input) throws IllegalArgumentException {
        String[] elems = input.split("\\s+");
        System.out.println(elems.length);
        switch (Commands.valueOf(elems[0].toUpperCase())){
            case ALLFILES:
            case COPY:
            case EXIT:
            case HELP:
            case RENAME:
            case GETLOCATION:
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
