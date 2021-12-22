package kit.edu.informatik.u3.b.management;

public class Utility {
    public static final int RECOVERY_SPAN = 180;
    public static boolean hasPermission(String proofType, int proofDate, int eventDate, boolean isEvent3G) {
        switch (proofType) {
            case "TESTED":
                if (isEvent3G) {
                    return eventDate == proofDate;
                } else return false;
            case "RECOVERED":
                return eventDate - proofDate < RECOVERY_SPAN;
            case "VACCINATED":
                return true;
            default:
                return false; // the person has no certificate
        }
    }
    public static boolean isInEvent (int personId, int[] participants) {
        for (int p:
                participants) {
            if (p == personId) {
                return true;
            }
        }
        return false;
    }
}
