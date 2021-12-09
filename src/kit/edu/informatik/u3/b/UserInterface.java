package kit.edu.informatik.u3.b;
import kit.edu.informatik.u3.b.Management.EventManagement;
import kit.edu.informatik.u3.b.Management.DateManagement;
import kit.edu.informatik.u3.b.Management.EventAndPersonManagement;
import kit.edu.informatik.u3.b.Management.PersonManagement;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class UserInterface {
    public static void main(String[] args) {
        runUI();
    }
    private static void runUI() {
        Scanner sc = new Scanner(System.in);
        DateManagement dM = new DateManagement();
        PersonManagement pM = new PersonManagement();
        EventManagement eM = new EventManagement();
        EventAndPersonManagement eAPM = new EventAndPersonManagement(eM, pM, dM);

        while (true) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];
            if (command.equals("quit")) { break; }
            String[] params = input[1].split(";");
            switch (command) {
                case "set-date":
                    System.out.println(dM.setDate(parseInt(params[0])));
                    break;
                case "add-person":
                    System.out.println(pM.addPerson(params[0], params[1], params[2]));
                    break;
                case "add-certificate":
                    System.out.println(pM.addCertificate(parseInt(params[0]), params[1], parseInt(params[2])));
                    break;
                case "print-person":
                    System.out.println(pM.printPerson(parseInt(params[0])));
                    break;
                case "print-people":
                    System.out.println(pM.printPeople(params[0]));
                    break;
                case "add-event":
                    System.out.println(eM.addEvent(parseInt(params[0]), params[1], parseInt(params[2]), params[3], parseInt(params[4])));
                    break;
                case "increase-security":
                    System.out.println(eAPM.increaseSecurity(parseInt(params[0]), parseInt(params[1])));
                    break;
                case "book-spot":
                    System.out.println(eAPM.bookSpot(parseInt(params[0]), parseInt(params[1])));
                    break;
                // case "report-case" -> System.out.println(program.reportCase(Integer.parseInt(params[0])));
            }
        }
        sc.close();
    }
}
