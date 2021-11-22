package u2.d;

public class Main {
    public static void main(String[] args) {
        boolean result = PaswordTools.isPasswordLeaked("123456abcdHAUS", "");
        System.out.println(result);
    }
}
