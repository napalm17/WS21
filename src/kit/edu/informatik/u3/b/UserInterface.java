package kit.edu.informatik.u3.b;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program program = new Program();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            if (command.equals("quit")) {
                break;
            }
            String[] params = input[1].split(";");
            switch (command) {
                case "set-date" -> System.out.println(program.setDate(Integer.parseInt(params[0])));
                case "add-person" -> System.out.println(program.addPerson(params[0], params[1], params[2]));
                case "add-certificate" -> System.out.println(program.addCertificate(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2])));
                case "print-person" -> System.out.println(program.printPerson(Integer.parseInt(params[0])));
                case "print-people" -> System.out.println(program.printPeople(params[0]));
                case "add-event" -> System.out.println(program.addEvent(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), params[3], Integer.parseInt(params[4])));
                case "increase-security" -> System.out.println(program.increaseSecurity(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
            }
        }
        scanner.close();
    }
}
