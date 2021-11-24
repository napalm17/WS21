package kit.edu.informatik.u2.d;

/**
 * Utility class for Task D:
 * @author ugpsy
 * @version 1.0
 */
public final class PasswordTools {

    /**
     * Private constructor to prevent instantiation.
     */
    private PasswordTools(){}

    /**
     * Static method for task D.1:
     * Generates a password with a minimum length from the first letter of every word in a given sentence, if the password is too short
     * then the letters in the password are again concatenated to the end of the password until it reaches the minimum length required.
     * @param sentence a given sentence out of which the password is to be generated
     * @param minLength the minimum length of the to-be-generated password
     * @return a password that was generated out of a given sentence (and was extended if necessary).
     */
    public static String generateFromSentence(String sentence, int minLength) {

        // Every password starts with the first letter of the first word of the sentence.
        String password  = String.valueOf(sentence.charAt(0));

        /* Goes through all characters in the given sentence, if the character is a space,
           then the subsequent one must be the first letter of a word in the sentence. */
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                char theFirstLetterOfAWord = sentence.charAt(i + 1);

                // The first letter of every word in the sentence is concatenated to the end of the password.
                password = password.concat(String.valueOf(theFirstLetterOfAWord));
            }
        }
        return passwordExtender(password, minLength);
    }

    /**
     * A private helper method for Task D.1:
     * The method extends the password -if necessary-, until it reaches the minimum password length.
     * @param password a password which is to be extended(if necessary!)
     * @param minLength required minimum length of the password
     * @return the extended password
     */
    //
    private static String passwordExtender(String password, int minLength) {
        int i = 0;
        while (password.length() < minLength) {
            password = password.concat(String.valueOf(password.charAt(i)));
            i++;
        }
        return password;
    }

    /**
     * static method for task D.2
     * checks whether a password is secure or not
     * @param password a password whose security is to be checked
     * @return whether the given password is secure or not
     */
    public static boolean checkPassword(String password) {
        boolean hasSmallLetter = false; boolean hasLargeLetter = false;
        boolean hasNumberAfterLetter = false; boolean hasSymbol = false;
        String symbols = "$#?!_-=%";

        for (int i = 0; i < password.length(); i++) {

            /* Checks -in case the previous character was a small or a large letter-
            whether the current letter's ASCII code is between that of '0' and '9'. */
            if ((hasLargeLetter || hasSmallLetter) && isInBetween('0', '9', password.charAt(i))) {
                hasNumberAfterLetter = true;
            }
            // If the current character's ASCII code is between that of 'a' and 'z', then it must be a small letter.
            else if (isInBetween('a', 'z', password.charAt(i))) {
                hasSmallLetter = true;
            }
            // Analogous to the one above but for large letters.
            else if (isInBetween('A', 'Z', password.charAt(i))) {
                hasLargeLetter = true;
                continue;
            }
            // Checks whether the current character is one of the symbols $#?!_-=%.
            for (int j = 0; j < symbols.length(); j++) {
                if (password.charAt(i) == symbols.charAt(j)){
                    hasSymbol = true;
                    break;
                }
            }
        }

        return hasSmallLetter && hasLargeLetter && hasNumberAfterLetter && hasSymbol;
    }

    /**
     * A private helper method for Task D.2:
     * The method finds out if character's ascii code is in between another two.
     * @param startChar The lower bound in ascii table
     * @param endChar The upper bound in ascii table
     * @param myChar the character whose position in the ascii table is to be checked
     * @return whether the given character lies between the two given bounds
     */
    private static boolean isInBetween(char startChar, char endChar, char myChar) {
        return startChar <= myChar && myChar <= endChar;
    }

    /**
     * Static method for task D.3:
     * Checks whether a password was leaked or not, by searching the character sequence in the password in the leaked dataset.
     * @param password a password whose security is to be checked.
     * @return whether the given password is secure or not.
     */
    public static boolean isPasswordLeaked(String leakedDataset, String password) {

        // If password is blank-space, it's automatically considered to be leaked.
        if (password.equals("")) return true;

        boolean isLeaked = false;

        // isLeaked is set to true, if the first letter of the password is found in the leaked dataset.
        for (int i = 0; i < leakedDataset.length(); i++) {
            if (leakedDataset.charAt(i) == password.charAt(0)){
                isLeaked = true;

                // isLeaked is set to false again, if the character sequence in the leaked dataset doesn't exactly match the given password.
                for (int j = 1; j < password.length(); j++) {
                    if (leakedDataset.charAt(i + j) != password.charAt(j)) {
                        isLeaked = false;
                        break;
                    }
                }
            }
        }
        return isLeaked;
    }
}
