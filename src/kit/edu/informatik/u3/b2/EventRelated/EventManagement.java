package kit.edu.informatik.u3.b2.EventRelated;

import kit.edu.informatik.u3.b2.ListModeling.ListCell;

public class EventManagement {
    private static int EVENT_INDEX = 0;

    private ListCell firstEvent;
    private ListCell lastEvent;
    public EventManagement() {
        this.firstEvent = null;
        this.lastEvent = null;
    }
    // B.2.6
    public int addEvent (int personId, String location, int capacity, String regulationType, int date) {
        Event event = new Event(EventManagement.EVENT_INDEX, personId, location, capacity, regulationType.equals("3G"), date);
        ListCell newListCell = new ListCell(null, event, this.lastEvent, null);
        if (this.firstEvent == null) {
            this.firstEvent = newListCell;
        } else {
            this.lastEvent.next = newListCell;
        }
        this.lastEvent = newListCell;
        EventManagement.EVENT_INDEX++;
        return event.getId();
    }
    public Event getEventfromId(int eventId) {
        ListCell c = this.firstEvent;
        while (c != null) {
            if (c.event.getId() == eventId) {
                break;
            }
            c = c.next;
        }
        return c.event;
    }
}
