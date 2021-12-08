package kit.edu.informatik.u3.b.PersonRelated;

import kit.edu.informatik.u3.b.ListModeling.ListCell;

public class PersonManagement {
    private int date = 0;
    private static int PERSON_INDEX = 0;
    private ListCell firstPerson;
    private ListCell lastPerson;

    public PersonManagement() {
        this.firstPerson = null;
        this.lastPerson = null;
    }
    // B.2.2
    public int addPerson(String role, String firstName, String lastName) {
        Person person = new Person(PERSON_INDEX, firstName, lastName, Person.Role.valueOf(role.toUpperCase()));
        ListCell newListCell = new ListCell(person, null, this.lastPerson, null);

        if (this.firstPerson == null) {
            this.firstPerson = newListCell;
        } else {
            this.lastPerson.next = newListCell;
        }
        this.lastPerson = newListCell;
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
        String result = "ad";
        ListCell c = this.firstPerson;
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
        ListCell c = this.firstPerson;
        while (c != null) {
            if (c.person.getId() == personId) {
                return c.person;
            }
            c = c.next;
        }
        return this.lastPerson.person;
    }
}
