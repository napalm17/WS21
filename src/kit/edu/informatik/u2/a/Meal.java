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

    // Every meal contains pork by default, unless specified otherwise,
    // since boolean values are initialized with the default value 'false'.
    boolean isVegan;
    boolean isVegetarian;
    boolean isBeef; // if false, then it is pork
}
