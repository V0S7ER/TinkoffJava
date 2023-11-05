package edu.project1;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleHangman {
    private static final String EXIT_COMMAND = "exit";
    private static final String GUESS_MESSAGE = "Guess a letter:";
    private static final int MAX_ATTEMPTS = 10;

    private final PrintWriter out = new PrintWriter(System.out);
    private final Scanner scanner = new Scanner(System.in);
    private final Dictionary dictionary = new RandomDictionary();

    public void run() {
        Session session = new Session(dictionary.getWord(), MAX_ATTEMPTS);

        GuessResult lastResult = null;
        while (!(lastResult instanceof GuessResult.Win) && (!(lastResult instanceof GuessResult.Defeat))) {
            out.println(GUESS_MESSAGE);
            out.flush();

            lastResult = tryGuess(session, scanner.nextLine());
            printState(lastResult);
        }
    }

    private GuessResult tryGuess(Session session, String input) {
        if (EXIT_COMMAND.equals(input)) {
            return session.giveUp();
        }

        return session.guess(input);
    }

    private void printState(GuessResult result) {
        out.println(result.getMessage());
        out.flush();
    }
}
