package u1.B;
import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        String delimiter = args[0];
        Scanner sc = new Scanner(System.in);
	    String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String input3 = sc.nextLine();
        System.out.println(input1 + delimiter + input2 + delimiter + input3);
    }
}
