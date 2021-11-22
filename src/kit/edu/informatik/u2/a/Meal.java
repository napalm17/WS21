package kit.edu.informatik.u2.a;

/**
 * Models a meal with the following attributes:
 * its name, price, whether it is vegan or not
 * and if it contains meat, whether it is pork or beef
 * @author ugpsy
 * @version 1.0
 */
public class Meal {
    String name;
    double price; // is given in €
    boolean isVegan;
    boolean isVegetarian;
    boolean isPork; // if false, then it is beef
}
