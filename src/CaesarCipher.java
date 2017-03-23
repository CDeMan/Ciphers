import java.util.Scanner;

/**
 * Created by Cole DeMan on 3/20/2017.
 *
 * for simplicity I strip capitalization off the string. Keeping capitalization seems pointless.
 * In a message from one person to another it would make no difference; and you would and should never
 * use this for encryption between machines.
 *
 * I looked up the how to convert letters to unicode and found the link:
 * http://stackoverflow.com/questions/15027231/java-how-to-convert-letters-in-a-string-to-a-number
 */
public class CaesarCipher {

    public static void caesar() {

        //String plainText = "abcdefghijklmnopqrstuvwxyz";
        //String plainText = "fudge";
        //int key = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key (1-26):");
        int key = scanner.nextInt();

        System.out.print("Enter Plaintext:");
        scanner.nextLine();
        String plainText = scanner.nextLine();

        String encrypted = encryptCaesarCipher(plainText, key);
        System.out.println("Encrypted:");
        System.out.println(encrypted);
        System.out.println("Decrypted:");
        System.out.println(decryptCaesarCipher(encrypted, key));
        System.out.println();
    }

    public static String encryptCaesarCipher(String plainText, int key){

        plainText = plainText.toLowerCase();
        String result = "";
        int tmp;

        for(int i = 0; i < plainText.length(); i++){
            tmp = ((plainText.charAt(i)- 'a' + 1)+key)%26;
            if(tmp <= 0){
                tmp = 26+tmp;
            }
            if(plainText.charAt(i) == ' '){
                result+=' ';
            }else {
                result += (char) (tmp + 'a' - 1);
            }
        }

        return result;
    }

    public static String decryptCaesarCipher(String encryptedText, int key){
        encryptedText = encryptedText.toLowerCase();
        String result = "";
        int tmp;

        for(int i = 0; i < encryptedText.length(); i++){
            tmp = (encryptedText.charAt(i)- 'a' + 1);
            tmp = (tmp-key)%26;
            if(tmp <= 0){
                tmp = 26+tmp;
            }
            if(encryptedText.charAt(i) == ' '){
                result+=' ';
            }else {
                result += (char) (tmp + 'a' - 1);
            }
        }

        return result;
    }
}
