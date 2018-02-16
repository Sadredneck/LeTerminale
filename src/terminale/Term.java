package terminale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Term {

    public static void main(String[] args) {
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Weclome to Terminalus Motherfucker!");
        while (true) {
            try {
                inputLine.readLine();
            } catch (IOException e) {

            }
        }
    }
}
