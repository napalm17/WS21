package kit.edu.informatik.u3.b.Management;
import kit.edu.informatik.u3.b.ListItems.Event;
import kit.edu.informatik.u3.b.ListItems.Person;

public class EventAndPersonManagement {
    EventManagement eventManagement;
    PersonManagement personManagement;

    public EventAndPersonManagement(EventManagement e, PersonManagement p) {
        this.eventManagement = e;
        this.personManagement = p;
    }
    // B.2.7
    public String increaseSecurity (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        if (canAddToEvent(eventId, personId)) {
            e.addParticipant(personId);
            return "OK";
        }
        return "Could not add security";
    }
    // B.2.8
    public String bookSpot (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        if (canAddToEvent(eventId, personId)) {
            e.addParticipant(personId);
            return e.getRemaining() + " spot(s) left";
        }
        return "Could not book spot";
    }
    private boolean canAddToEvent(int eventId, int personId) {
        Person p = this.personManagement.getPersonFromId(personId);
        Event e = this.eventManagement.getEventfromId(eventId);
        return Utility.hasPermission(p.getProoftype(), p.getProofdate(), e.getDate(), e.is3G())
                && e.getRemaining() > 0 && !(Utility.isInEvent(personId, e.getParticipants()));
    }
}
