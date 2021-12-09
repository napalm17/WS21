package kit.edu.informatik.u3.b.listItems;

public class Event {
    private int lecturerId;
    private String location;
    private int capacity;
    private boolean is3G;
    private int date;
    private int id;
    private int numberOfParticipants = 0;
    private int[] participants;

    public Event(int id, int lecturerId, String location, int capacity, boolean is3G, int date) {
        this.lecturerId = lecturerId;
        this.location = location;
        this.capacity = capacity;
        this.is3G = is3G;
        this.date = date;
        this.id = id;
        this.participants = new int[capacity];
        for (int i = 0; i < capacity ; i++) {
            this.participants[i] = -1;
        }
        this.participants[0] = lecturerId;
        this.numberOfParticipants++;
    }
    public void addParticipant(int personId) {
        this.participants[this.numberOfParticipants] = personId;
        numberOfParticipants++;
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
        return this.capacity - this.numberOfParticipants;
    }
    public boolean is3G () {
        return this.is3G;
    }

}
