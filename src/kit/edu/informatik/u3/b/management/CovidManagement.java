package kit.edu.informatik.u3.b.management;
import kit.edu.informatik.u3.b.listItems.Event;
import kit.edu.informatik.u3.b.listItems.Person;

public class CovidManagement {
    EventManagement eventManagement;
    PersonManagement personManagement;
    DateManagement dateManagement;

    public CovidManagement(EventManagement e, PersonManagement p, DateManagement d) {
        this.eventManagement = e;
        this.personManagement = p;
        this.dateManagement = d;

    }
    // B.2.7
    public String increaseSecurity (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        Person p = this.personManagement.getPersonFromId(personId);
        if (canAddToEvent(eventId, personId)) {
            e.addParticipant(personId);
            p.addEvent(eventId);
            return "OK";
        }
        return "Could not add security";
    }

    // B.2.8
    public String bookSpot (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        Person p = this.personManagement.getPersonFromId(personId);
        if (canAddToEvent(eventId, personId)) {
            e.addParticipant(personId);
            p.addEvent(eventId);
            return e.getRemaining() + " spot(s) left";
        }
        return "Could not book spot";
    }
    public String reportCase (int exposedPersonId) {

        String result = "";
        for (int i = 0; i < this.personManagement.getNumberOfPeople(); i++) {
            if (i != exposedPersonId) {
                result += getContacted(exposedPersonId, this.personManagement.getPersonFromId(i));
            }
        }
        return result.substring(0, result.length() - 1);
    }


    private String getContacted(int exposedPersonId, Person p) {
        int[] joinedEvents = p.getJoinedEvents();
        String result = "";
        int i = 0;
        int contacts = 0;
        final int DANGER_RANGE = 14;
        while (joinedEvents[i] != -1) {
            Event e = this.eventManagement.getEventfromId(joinedEvents[i]);
            boolean isIn14DayRange = this.dateManagement.getCurrentDate() - DANGER_RANGE <= e.getDate() && e.getDate() <= this.dateManagement.getCurrentDate();
            boolean hadExposedPerson = Utility.isInEvent(exposedPersonId, e.getParticipants());
            if (isIn14DayRange && hadExposedPerson) {
               result = p.getFullInfo();
               contacts++;
            }
            i++;
        }

        if (!(result.equals(""))) {
            return result + " [" + contacts + "]\n";
        }
        return "";
    }
    private boolean canAddToEvent(int eventId, int personId) {
        Person p = this.personManagement.getPersonFromId(personId);
        Event e = this.eventManagement.getEventfromId(eventId);
        return Utility.hasPermission(p.getProoftype(), p.getProofdate(), e.getDate(), e.is3G())
                && e.getRemaining() > 0 && !(Utility.isInEvent(personId, e.getParticipants()));
    }
}
