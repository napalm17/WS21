package kit.edu.informatik.u3.b;
import kit.edu.informatik.u3.b.listItems.Event;
import kit.edu.informatik.u3.b.listItems.Person;

public class ListCell {
    public Person person;
    public Event event;
    public ListCell prev;
    public ListCell next;

    public ListCell(Person person, Event event, ListCell p, ListCell n) {
        this.person = person;
        this.event = event;
        this.prev = p;
        this.next = n;
    }
}
