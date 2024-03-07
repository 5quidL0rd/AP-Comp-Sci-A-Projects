/**
 * This class allows a user to create a caesar shift by utilizing the classes encryption and decryption
 *
 * @author Blake Fowler
 * @version 3/7/2023
 */




import java.util.Scanner;


public class CaesarTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validEntry = false;
        String cipherAlphabet = "";
        int shiftKey = 0; 

        while (!validEntry) {
            System.out.println("Please enter a shift key between 0 and 25 inclusive:");
            shiftKey = scanner.nextInt();
            scanner.nextLine();

            if (shiftKey > 25 || shiftKey < 0) {
                System.out.println("That is invalid. Please enter a number 0-25 in range.");
            } else {
                System.out.println("Here is your key for " + shiftKey);
                validEntry = true;
            }
        }

        Encryption encryption = new Encryption(shiftKey);
        cipherAlphabet = encryption.generateCipherAlphabet();
        System.out.println("Alphabet: " + Encryption.getAlphabet());
        System.out.println("Cipher Alphabet: " + cipherAlphabet);
        System.out.println();

        boolean userDecision = false;

        while (!userDecision) {
            System.out.println("Would you like to encrypt or decrypt a message? (Enter E or D)");
            String userCryption = scanner.nextLine();

            if (userCryption.equalsIgnoreCase("E")) {
                userDecision = true;
                System.out.println("You have selected encryption.");

                System.out.println("Enter a message you would like to encrypt. When you are done entering messages, press 1.");

                String userMessage = "";
                boolean userEncrypting = true;

                while (userEncrypting) {
                    System.out.println("Enter a message to be encrypted.");
                    userMessage = scanner.nextLine();

                    if (userMessage.equals("1")) {
                        userEncrypting = false;
                    } else {
                        String encryptedMessage = encryption.encryptMessage(userMessage);
                        System.out.println("Encrypted message: " + encryptedMessage);
                    }
                }
            } else if (userCryption.equalsIgnoreCase("D")) {
                userDecision = true;
                System.out.println("You have selected decryption.");

                System.out.println("Enter a message you would like to decrypt. When you are done entering messages, press 1.");

                String userMessage = "";
                boolean userDecrypting = true;

                while (userDecrypting) {
                    System.out.println("Enter a message to be decrypted.");
                    userMessage = scanner.nextLine();

                    if (userMessage.equals("1")) {
                        userDecrypting = false;
                    } else {
                        Decryption decryption = new Decryption(shiftKey);
                        String decryptedMessage = decryption.decryptMessage(userMessage);
                        System.out.println("Decrypted message: " + decryptedMessage);
                    }
                }
            } else {
                System.out.println("Invalid entry. Please try again.");
            }
        }
    }
}