package u2.a;

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

    // this attribute is not to be assigned if the above one already is
    boolean isVegetarian;

    // this attribute is not to be assigned if the above one already is
    boolean isPork; // if false, then it is beef
}
