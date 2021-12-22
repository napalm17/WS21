package kit.edu.informatik.u4.b;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class UserInterface {

    public void run() {
        final long DEFAULT_SEED = 0;
        Scanner sc = new Scanner(System.in);
        Game game = new Game(DEFAULT_SEED);

        while (true) {
            String input = sc.nextLine();
            String[] params = input.split(" ");
            String command = params[0];
            if (command.equals("quit")) break;
            else if (input.equals("show game")) command = "show game";
            switch (command) {
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
                    System.out.print(game.pick(parseInt(params[1]) - 1));
                    break;
            }
        }
        sc.close();
    }
}
