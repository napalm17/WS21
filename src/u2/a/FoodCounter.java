package u2.a;

/**
 * Models a food counter at Mensa with the following attributes:
 * counter's name, counter's opening-closing time, at the counter offered meal
 * and whether it is for takeaway or for eating on-site
 * P.S. Couldn't find a better translation for "Essenausgabe" other than food counter.
 * @author ugpsy
 * @version 1.0
 */
public class FoodCounter {
    String name;
    boolean isForTakeAway; // if false then it is to consume "at site"
    Time openingTime;
    Time closingTime;
    Meal meal1;
    Meal meal2;
    Meal meal3;
}
