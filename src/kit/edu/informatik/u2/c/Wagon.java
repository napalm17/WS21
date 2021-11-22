package kit.edu.informatik.u2.c;

/**
 * Models a wagon with the following attributes:
 * number of seats/bike spaces the wagon contains, whether it has an on-board restaurant,
 * wagon's model and serial number and its air conditioner
 * @author ugpsy
 * @version 1.0
 */
public class Wagon {
    int numberOfSeats;
    int numberOfBikeSpaces;
    boolean isWithRestaurant;
    AlphaNumeric modelName;
    AlphaNumeric serialNo;
    AirConditioner airConditioner;
}
