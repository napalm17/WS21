package u2.c;

/**
 * Models a train ride with the following attributes:
 * the train, on which day of the week the ride is,
 * departure/arrival time, boarding/final station
 * train number and the price for a ride
 * @author ugpsy
 * @version 1.0
 */
public class TrainRide {
    Train train;
    String dayOfWeek;
    Time departureTime;
    Time arrivalTime;
    Station boardingStation;
    Station finalStation;
    int trainNo;
    int price;
}
