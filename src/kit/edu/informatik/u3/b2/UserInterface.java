package kit.edu.informatik.u3.b2;


import kit.edu.informatik.u3.b2.EventRelated.EventManagement;
import kit.edu.informatik.u3.b2.PersonRelated.PersonManagement;

import java.util.Scanner;

public class UserInterface {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        PersonManagement pM = new PersonManagement();
        EventManagement eM = new EventManagement();
        EventAndPersonManagement eAPM = new EventAndPersonManagement(eM, pM);
        String[] params = new String[0];
        boolean isCommandQuit = false;

        while (!(isCommandQuit)) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            if (input.length > 1) {
                params = input[1].split(";");
            }
            switch (command) {
                // case "set-date" -> System.out.println(program.setDate(Integer.parseInt(params[0])));
                case "add-person" -> System.out.println(pM.addPerson(params[0], params[1], params[2]));
                case "add-certificate" -> System.out.println(pM.addCertificate(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2])));
                case "print-person" -> System.out.println(pM.printPerson(Integer.parseInt(params[0])));
                case "print-people" -> System.out.println(pM.printPeople(params[0]));
                case "add-event" -> System.out.println(eM.addEvent(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), params[3], Integer.parseInt(params[4])));
                case "increase-security" -> System.out.println(eAPM.increaseSecurity(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
                case "book-spot" -> System.out.println(eAPM.bookSpot(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
                // case "report-case" -> System.out.println(program.reportCase(Integer.parseInt(params[0])));
                case "quit" -> isCommandQuit = true;
            }
        }
        scanner.close();
    }
}
