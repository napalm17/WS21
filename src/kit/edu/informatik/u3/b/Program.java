package kit.edu.informatik.u3.b;

public class Program {

    private int date;
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
        ListCell c = this.firstPerson;
        while (c != null) {
            if (c.item.person.getID() == personId) {
                c.item.person.setCertificate(proof, date);
                return "OK";
            }
            c = c.next;
        }
        return "Couldn't find person with the id number: " + personId;
    }

    // B.2.4
    public String printPerson (int personId) {
        ListCell c = this.firstPerson;
        while (c != null) {
            if (c.item.person.getID() == personId) {
                return c.item.person.getFullInfo();
            }
            c = c.next;
        }
        return "Couldn't find person with the id number: " + personId;
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
        ListCell c1 = this.firstPerson;
        while (c1 != null) {
            if (c1.item.person.getID() == personId) {
                break;
            }
            c1 = c1.next;
        }
        ListCell c2 = this.firstEvent;
        while (c2 != null) {
            if (c2.item.event.getId() == eventId) {
                break;
            }
            c2 = c2.next;
        }
        if (hasPermission(c1.item.person.getProoftype(), c1.item.person.getProofdate(), c2.item.event.getDate(), c2.item.event.is3G())
                && c2.item.event.getRemaining() > 0) {
            return "OK";
        }
        return "Could not add security";
    }


    // B.2.8
    public String bookSpot (int eventId, int personId) {
        ListCell c1 = this.firstPerson;
        while (c1 != null) {
            if (c1.item.person.getID() == personId) {
                break;
            }
            c1 = c1.next;
        }
        ListCell c2 = this.firstEvent;
        while (c2 != null) {
            if (c2.item.event.getId() == eventId) {
                break;
            }
            c2 = c2.next;
        }
        return "Could not book spot";
    }
    // B.2.9
    public String reportCase (int personId) {
        return "ok";
    }

    private boolean hasPermission (String proofType, int proofDate, int eventDate, boolean isEvent3G) {
        switch (proofType) {
            case "TESTED":
                if (isEvent3G) {
                    return eventDate == proofDate;
                } else return false;
            case "RECOVERED":
                return eventDate - proofDate < 180;
            case "VACCINATED":
                return true;
            default:
                return false; // the person has no certificate
        }
    }
}

