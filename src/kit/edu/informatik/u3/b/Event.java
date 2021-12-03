package kit.edu.informatik.u3.b;

public class Event {
    private int NUMBER_OF_PARTICIPANTS = 0;

    private int lecturerId;
    private String location;
    private int capacity;
    private boolean is3G;
    private int date;
    private int id;

    public Event (int lecturerId, String location, int capacity, boolean is3G, int date) {
        this.lecturerId = lecturerId;
        this.location = location;
        this.capacity = capacity;
        this.is3G = is3G;
        this.date = date;
        this.NUMBER_OF_PARTICIPANTS++;
    }
    public void setID (int id) {
        this.id = id;
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
