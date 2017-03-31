import java.util.Scanner;

/**
 * Created by Cole DeMan on 3/20/2017.
 */
@SuppressWarnings("Duplicates")
public class VigenereCipher {

    public static void vigenere() {

        //String plainText = "abcdefghijklmnopqrstuvwxyz";
        //String plainText = "plaintext plaintext thats some plaintext";
        //String key = "key";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key:");
        String key = scanner.nextLine();

        System.out.print("Enter Plaintext:");
        String plainText = scanner.nextLine();

        //System.out.print(encrypt(plainText,key));

        String encrypted = encrypt(plainText, key);
        System.out.println("Encrypted:");
        System.out.println(encrypted);
        System.out.println("Decrypted:");
        System.out.println(decrypt(encrypted, key));
        System.out.println();

    }

    public static String encrypt(String plainText, String key) {

        plainText = plainText.toLowerCase();
        String result = "";
        String tmp = "";
        int keyLength = key.length();

        int num;
        for (int i = 0; i < plainText.length(); i++) {
            if(plainText.charAt(i) == ' '){
                result+=' ';
            }else {
                num = ((plainText.charAt(i) - 'a') + (key.charAt(i % (keyLength)) - 'a')) % 26;
                if (num <= -1) {
                    num = 26 + num;
                }
                result += (char) (num + 'a');
            }
        }
        return result;
    }

    public static String decrypt(String encryptedText, String key) {
        encryptedText = encryptedText.toLowerCase();
        String result = "";
        String tmp = "";
        int keyLength = key.length();
        for (int i = 0; i < encryptedText.length(); i++) {
            tmp += key.charAt(i % (keyLength));
        }
        key = tmp;
        int num;
        for (int i = 0; i < encryptedText.length(); i++) {
            if (encryptedText.charAt(i) == ' ') {
                result += ' ';
            } else {
                num = ((encryptedText.charAt(i) - 'a') - (key.charAt(i) - 'a')) % 26;
                if (num <= -1) {
                    num = 26 + num;
                }
                result += (char) (num + 'a');
            }
        }
        return result;
    }

}
