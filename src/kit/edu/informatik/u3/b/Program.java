package kit.edu.informatik.u3.b;

public class Program {

    private int date = 0;
    private static int PERSON_INDEX = 0;
    private static int EVENT_INDEX = 0;
    private class ListCell {
        private Item item;
        ListCell prev;
        ListCell next;

        public ListCell(Item content, ListCell p, ListCell n) {
            this.item = content;
            this.prev = p;
            this.next = n;
        }
    }
    private ListCell firstPerson, lastPerson, firstEvent, lastEvent;
    public Program() {
        this.firstPerson = this.lastPerson = this.firstEvent = this.lastEvent = null;
    }

    // B.2.1
    public String setDate (int date) {
        this.date = date;
        return "OK";
    }
    // B.2.2
    public int addPerson(String role, String firstName, String lastName) {
        Item item = new Item();
        item.person = new Person(Program.PERSON_INDEX, firstName, lastName, Person.Role.valueOf(role.toUpperCase()));
        ListCell newListCell = new ListCell(item, this.lastPerson, null);
        if (this.firstPerson == null) {
            this.firstPerson = newListCell;
        } else {
            this.lastPerson.next = newListCell;
        }
        this.lastPerson = newListCell;
        Program.PERSON_INDEX++;
        return item.person.getID();
    }
    // B.2.3
    public String addCertificate (int personId, String proof, int date) {
        Person p = getPersonfromId(personId);
        p.setCertificate(proof, date);
        return "OK";
    }
    // B.2.4
    public String printPerson (int personId) {
        Person p = getPersonfromId(personId);
        return p.getFullInfo();
    }
    // B.2.5
    public String printPeople (String role) {
        String result = "ad";
        ListCell c = this.firstPerson;
        while (c != null) {
            System.out.println(c.item.person.getRole() + role.toUpperCase());
            if (c.item.person.getRole().equals(role.toUpperCase())) {
                result += c.item.person.getFullInfo() + "\n";
            }
            c = c.next;
        }
        return result;
    }
    // B.2.6

    public int addEvent (int personId, String location, int capacity, String regulationType, int date) {
        Item item = new Item();
        item.event = new Event(Program.EVENT_INDEX, personId, location, capacity, regulationType.equals("3G"), date);
        ListCell newListCell = new ListCell(item, this.lastEvent, null);
        if (this.firstEvent == null) {
            this.firstEvent = newListCell;
        } else {
            this.lastEvent.next = newListCell;
        }
        this.lastEvent = newListCell;
        Program.EVENT_INDEX++;
        return item.event.getId();
    }

    // B.2.7
    public String increaseSecurity (int eventId, int personId) {
        Event e = getEventfromId(eventId);
        if (canAddtoEvent(eventId, personId)) {
            e.addParticipant(personId);
            return "OK";
        }
        return "Could not add security";
    }
    // B.2.8
    public String bookSpot (int eventId, int personId) {
        Event e = getEventfromId(eventId);
        if (canAddtoEvent(eventId, personId)) {
            e.addParticipant(personId);
            return e.getRemaining() + " spot(s) left";
        }
        return "Could not book spot";
    }
    // B.2.9
    public String reportCase (int personId) {
        String result = "";
        for (int i = 0; i <= this.lastEvent.item.event.getId(); i++) {
            int[] participants = getEventfromId(i).getParticipants();
            if (Utility.isInEvent(personId, participants)) {
                for (int p : participants) {
                    result += getPersonfromId(p).getFullInfo() + "\n";
                }
            }
        }
        return result;
    }

    // helper methods
    private boolean canAddtoEvent(int personId, int eventId) {
        Person p = getPersonfromId(personId);
        Event e = getEventfromId(eventId);
        return Utility.hasPermission(p.getProoftype(), p.getProofdate(), e.getDate(), e.is3G())
                && e.getRemaining() > 0 && !(Utility.isInEvent(personId, e.getParticipants()));
    }
    public Person getPersonfromId(int personId) {
        ListCell c = this.firstPerson;
        while (c != null) {
            if (c.item.person.getID() == personId) {
                break;
            }
            c = c.next;
        }
        return c.item.person;
    }
    public Event getEventfromId(int eventId) {
        ListCell c = this.firstEvent;
        while (c != null) {
            if (c.item.event.getId() == eventId) {
                break;
            }
            c = c.next;
        }
        return c.item.event;
    }
}

