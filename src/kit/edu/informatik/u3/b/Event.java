package kit.edu.informatik.u3.b;

public class Event {
    private int NUMBER_OF_PARTICIPANTS = 0;

    private int lecturerId;
    private String location;
    private int capacity;
    private boolean is3G;
    private int date;
    private int id;
    private int[] participants;

    public Event (int id, int lecturerId, String location, int capacity, boolean is3G, int date) {
        this.lecturerId = lecturerId;
        this.location = location;
        this.capacity = capacity;
        this.is3G = is3G;
        this.date = date;
        this.id = id;
        this.participants = new int[capacity];
        this.participants[this.NUMBER_OF_PARTICIPANTS] = lecturerId;
        this.NUMBER_OF_PARTICIPANTS++;
    }
    public void addParticipant(int personId) {
        this.participants[this.NUMBER_OF_PARTICIPANTS] = personId;
    }
    public int[] getParticipants() {
        return this.participants;
    }
    public int getId() {
        return this.id;
    }
    public int getDate() {
        return this.date;
    }
    public int getRemaining() {
        return this.capacity - this.NUMBER_OF_PARTICIPANTS;
    }
    public boolean is3G () {
        return this.is3G;
    }

}
