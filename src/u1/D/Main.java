package u1.D;

public class Main {
    public static void main(String[] args) {

        // Task D4
        Car golf = new Car();
        golf.manufacturer = "VW";
        golf.model = "golf";
        golf.engine.hp = 75;
        golf.engine.weight = 200;
        golf.vehicleBody.numberOfSeats = 5;
        golf.vehicleBody.cwValue = 0.35;
        golf.vehicleBody.weight = 1800;

        Car porsche = new Car();

        porsche.manufacturer = "Porsche";
        porsche.model = "911";
        porsche.engine.hp = 420;
        porsche.engine.weight = 250;
        porsche.vehicleBody.numberOfSeats = 4;
        porsche.vehicleBody.cwValue = 0.32;
        porsche.vehicleBody.weight = 1250;

        // Task D5
        int weight = golf.engine.weight + golf.vehicleBody.weight;

        // Task D6
        double maxSpeed = (6 * Math.sqrt(golf.engine.hp))/golf.vehicleBody.cwValue;

        // Task D7
        double fuelConsumption = (Math.sqrt(golf.engine.hp) * Math.sqrt(weight) * golf.vehicleBody.cwValue) / 25;

        // Task D8
        boolean isEcoFriendly = fuelConsumption / golf.vehicleBody.numberOfSeats <= 1.2;

        // Task D9
        golf.engine.hp = golf.engine.hp + 25;

        // Task D10
        golf.engine.hp = golf.engine.hp * (golf.engine.hp / 20); // 5% means to divide by 20.

        // Task D11: When you do "golf.engine = porsche.engine", the motor of the Golf is not converted into that of the Porsche
        // "in the real sense" because in reality a car engine has many more attributes besides its horsepower and weight which affect its design.
        // So, by only changing the engine's horsepower and weight you don't really "redesign" or convert it into the engine of the Porsche.
        golf.engine = porsche.engine;
    }
}