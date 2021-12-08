package kit.edu.informatik.u3.b.PersonRelated;
import kit.edu.informatik.u3.b.ListModeling.ListCell;

public class PersonManagement {
    private int date = 0;
    private static int PERSON_INDEX = 0;
    private ListCell first;
    private ListCell last;

    public PersonManagement() {
        this.first = null;
        this.last = null;
    }
    // B.2.2
    public int addPerson(String role, String firstName, String lastName) {
        Person person = new Person(PERSON_INDEX, firstName, lastName, Person.Role.valueOf(role.toUpperCase()));
        ListCell newListCell = new ListCell(person, null, this.last, null);

        if (this.first == null) {
            this.first = newListCell;
        } else {
            this.last.next = newListCell;
        }
        this.last = newListCell;
        PERSON_INDEX++;
        return person.getId();
    }
    // B.2.3
    public String addCertificate (int personId, String proof, int date) {
        Person person = getPersonfromId(personId);
        person.setCertificate(proof, date);
        return "OK";
    }
    // B.2.4
    public String printPerson (int personId) {
        Person person = getPersonfromId(personId);
        return person.getFullInfo();
    }
    // B.2.5
    public String printPeople (String role) {
        String result = "";
        ListCell c = this.first;
        while (c != null) {
            if (c.person.getRole().equals(role)) {
                result += c.person.getFullInfo() + "\n";
            }
            c = c.next;
        }
        return result;
    }
    // helper method
    public Person getPersonfromId(int personId) {
        ListCell c = this.first;
        while (c != null) {
            if (c.person.getId() == personId) {
                return c.person;
            }
            c = c.next;
        }
        return this.last.person;
    }
}
