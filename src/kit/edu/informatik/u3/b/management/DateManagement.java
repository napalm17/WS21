package kit.edu.informatik.u3.b.management;

public class DateManagement {

    // B.2.1
    private int date = 0;

    public String setDate (int date) {
        this.date = date;
        return "OK";
    }
    public int getCurrentDate () {
        return this.date;
    }
}
