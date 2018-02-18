package terminale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Term {
    private static Commandable commandable;

    private static void handleInput(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty())
            return;
        String[] elems = input.split("\\s+");
        if (elems.length == 0)
            return;

        switch (Commands.valueOf(elems[0].toUpperCase())) {
            case ALLFILES:
                commandable = new AllFiles(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case COPY:
                commandable = new Copy(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case EXIT:
                throw new Exit();
            case HELP:
                commandable = new Help(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case RENAME:
                commandable = new Rename(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case MAKEZIP:
                commandable = new MakeZIP(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case GETLOCATION:
                commandable = new GetLocation(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
            case CHANGELOCATION:
                commandable = new ChangeLocation(Arrays.copyOfRange(elems, 1, elems.length));
                commandable.doCommand();
                break;
        }
    }

    public static void main(String[] args) {
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Terminalus!");
        while (true) {
            System.out.print("Enter your command: ");
            try {
                String line = inputLine.readLine();
                handleInput(line);
            } catch (IOException e) {
                System.out.println("Bizzare input.");
            } catch (IllegalArgumentException exc) {
                System.out.println("wrong command");
            } catch (Exit error) {
                System.exit(0);
            }
        }
    }

    static class Exit extends Error {
    }
}
