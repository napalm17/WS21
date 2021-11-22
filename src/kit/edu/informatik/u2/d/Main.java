package kit.edu.informatik.u2.d;

public class Main {
    public static void main(String[] args) {
        String result = PasswordTools.generateFromSentence("123 456 abcdH AUS", 6);
        System.out.println(result);
    }
}
