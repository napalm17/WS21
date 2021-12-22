package kit.edu.informatik.u4.b;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Models the command line interface for the game of Mau-Mau.
 * @author ugpsy
 * @version 1.0
 */
public class UserInterface {
    /**
     * B.4: Runs the game of Mau-Mau on the console.
     */
    public void run() {
        final long DEFAULT_SEED = 0; // Set to 0 zero by default, will later be changed by user input.
        Scanner sc = new Scanner(System.in);
        Game game = new Game(DEFAULT_SEED);

        while (true) {
            String input = sc.nextLine();
            String[] params = input.split(" "); // User input is split into string variables by a space.
            String command = params[0];

            // B.4.7
            if (command.equals("quit")) {
                break;
            }
            else if (input.equals("show game")) {
                command = "show game";
            }
            switch (command) {
                // If the given command is start, then a new game is started with the given seed.
                case "start":
                    game = new Game(parseInt(params[1]));
                    System.out.println("Player 1 takes the turn.");
                    break;
                case "show game":
                    System.out.println(game.showGame());
                    break;
                case "show":
                    System.out.println(game.showHand(parseInt(params[1]) - 1));
                    break;
                case "discard":
                    System.out.print(game.discard(parseInt(params[1]) - 1, params[2]));
                    break;
                case "pick":
                    game.pick(parseInt(params[1]) - 1);
                    break;
            }
        }
        sc.close();
    }
}
