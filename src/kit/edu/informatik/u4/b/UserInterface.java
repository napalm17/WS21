package kit.edu.informatik.u4.b;

import java.text.ParseException;
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
        final long defaultSeed = 0; // Set to 0 zero by default, will later be changed by user input.
        Scanner sc = new Scanner(System.in);
        Game game = new Game(defaultSeed);

        while (true) {
            int playerNo;
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
            else {
                try {
                    int i = parseInt(params[1]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Parsing Error " + e.getMessage());
                    continue;
                }
            }
            switch (command) {
                // If the given command is start, then a new game is started with the given seed.
                case "start":
                    game = new Game(parseInt(params[1]));
                    System.out.println("Player 1 takes the turn.");
                    break;
                case "show game":
                    System.out.println(game.showGame().replaceAll("@", "10"));
                    break;
                case "show":
                    System.out.println(game.showHand(parseInt(params[1]) - 1).replaceAll("@", "10"));
                    break;
                case "discard":
                    if (parseInt(params[1]) == game.getPlayerOnTurn()) {
                        System.out.print(game.discard(parseInt(params[1]) - 1,
                                params[2].replaceAll("10", "@")).replaceAll("@", "10"));
                        break;
                    }
                    System.out.println("Error, it is Player " + parseInt(params[1]) + "'s turn to play.");
                    break;
                case "pick":
                    if (parseInt(params[1]) == game.getPlayerOnTurn()) {
                        System.out.print(game.pick(parseInt(params[1]) - 1));
                        break;
                    }
                    System.out.println("Error, it is Player " + parseInt(params[1]) + "'s turn to play.");
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
