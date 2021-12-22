package kit.edu.informatik.u3.b.management;
import kit.edu.informatik.u3.b.ListCell;
import kit.edu.informatik.u3.b.listItems.Event;

public class EventManagement {
    private static int EVENT_INDEX = 0;
    private PersonManagement pM;
    private ListCell first;
    private ListCell last;
    public EventManagement(PersonManagement pM) {
        this.first = null;
        this.last = null;
        this.pM = pM;
    }
    // B.2.6
    public int addEvent (int lecturerId, String location, int capacity, String regulationType, int date) {
        Event event = new Event(EventManagement.EVENT_INDEX, lecturerId, location, capacity, regulationType.equals("3G"), date);
        pM.getPersonFromId(lecturerId).addEvent(EVENT_INDEX);
        ListCell newListCell = new ListCell(null, event, this.last, null);
        if (this.first == null) {
            this.first = newListCell;
        } else {
            this.last.next = newListCell;
        }
        this.last = newListCell;
        EventManagement.EVENT_INDEX++;
        return event.getId();
    }
    public Event getEventfromId(int eventId) {
        ListCell c = this.first;
        while (c != null) {
            if (c.event.getId() == eventId) {
                return c.event;
            }
            c = c.next;
        }
        return this.last.event;
    }
    public int getNumberOfEvents() {
        return EVENT_INDEX;
    }
}
