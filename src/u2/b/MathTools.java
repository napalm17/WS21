package u2.b;

/**
 * Utility class for Task B
 * @author ugpsy
 * @version 1.0
 */
public final class MathTools {

    /**
     * Private constructor to prevent instantiation
     */
    private MathTools(){}

    /**
     * B.1: approximates Euler's numbers.
     * @param n: a positive integer that serves as the upper bound of summation.
     * @return an approximation of Euler's number.
     */
    public static double euler(int n){
        double sum = 0; // declaring a double variable which will store the value of "e".

        // The outer for-loop does the summation of the sequence "1/i!".
        for (int i = 0; i < n + 1; i++) {
            double factorial = 1; // declaring another double variable which will the store the value "i!"

            // The inner for-loop calculates the factorial of the integer i.
            for (int j = 1; j < i + 1; j++) {
                factorial *= j;
            }
            sum += 1 / factorial;
        }
        return sum;
    }

    /**
     * B.2: computes whether a given positive integer is a prime number.
     * @param n: a positive integer, we want to know whether it is prime or not.
     * @return whether the statement "n is prime a number" is a true or a false one.
     */
    public static boolean isPrime(int n){
        boolean nIsPrime = true; //declaring a boolean variable and assigning it as true by default.

        for (int i = 2; i < n; i++) {

            // if n is divisible without a remainder by any of any number larger than 1 and smaller than itself, then nIsPrime is set to false.
            if (n % i == 0){
                nIsPrime = false;
                break;
            }
        }
        return  nIsPrime;
    }
}
