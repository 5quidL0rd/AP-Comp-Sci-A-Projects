/**
 * Encrypts a message using Caesar shift
 *
 * @author Blake Fowler
 * @version 3/7/2023
 */




public class Encryption {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int shiftKey;

    public Encryption(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String generateCipherAlphabet() {
        String cipherAlphabet = "";
        for (int i = 0; i < ALPHABET.length(); i++) {
            int shiftedIndex = (i + shiftKey) % ALPHABET.length();
            cipherAlphabet += ALPHABET.charAt(shiftedIndex);
        }
        return cipherAlphabet;
    }

    public String encryptMessage(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (isLetter(currentChar)) {
                char base = 'A';
                if (isLowerCase(currentChar)) {
                    base = 'a';
                }
                char encryptedChar = (char) (((currentChar - base + shiftKey) % 26) + base);
                encryptedMessage += encryptedChar;
            } else {
                encryptedMessage += currentChar;
            }
        }
        return encryptedMessage;
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