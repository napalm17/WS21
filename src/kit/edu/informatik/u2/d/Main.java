package kit.edu.informatik.u2.d;

public class Main {
    public static void main(String[] args) {
        boolean result = PasswordTools.isPasswordLeaked("123456abcdHAUS", "");
        System.out.println(result);
    }
}
