package kit.edu.informatik.u3.b.Management;
import kit.edu.informatik.u3.b.ListCell;
import kit.edu.informatik.u3.b.ListItems.Event;

public class EventManagement {
    private static int EVENT_INDEX = 0;

    private ListCell first;
    private ListCell last;
    public EventManagement() {
        this.first = null;
        this.last = null;
    }
    // B.2.6
    public int addEvent (int personId, String location, int capacity, String regulationType, int date) {
        Event event = new Event(EventManagement.EVENT_INDEX, personId, location, capacity, regulationType.equals("3G"), date);
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
}
