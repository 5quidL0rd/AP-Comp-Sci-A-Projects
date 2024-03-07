/**
 * Decrypts a message using Caesar shift
 *
 * @author Blake Fowler
 * @version 3/7/2023
 */




public class Decryption {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int shiftKey;

    public Decryption(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String generateCipherAlphabet() {
        String cipherAlphabet = "";
        for (int i = 0; i < ALPHABET.length(); i++) {
            int shiftedIndex = (i - shiftKey + ALPHABET.length()) % ALPHABET.length();
            cipherAlphabet += ALPHABET.charAt(shiftedIndex);
        }
        return cipherAlphabet;
    }

    public String decryptMessage(String message) {
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (isLetter(currentChar)) {
                char base = 'A';
                if (isLowerCase(currentChar)) {
                    base = 'a';
                }
                char decryptedChar = (char) (((currentChar - base - shiftKey + 26) % 26) + base);
                decryptedMessage += decryptedChar;
            } else {
                decryptedMessage += currentChar;
            }
        }
        return decryptedMessage;
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static String getAlphabet() {
        return ALPHABET;
    }
}