import java.util.Scanner;

/**
 * Created by Cole DeMan on 3/20/2017.
 *
 */
@SuppressWarnings("Duplicates")
public class MatrixTransposition {

    public static void matrixTransposition() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key:");
        String key = scanner.nextLine();

        System.out.print("Enter Plaintext:");
        String plainText = scanner.nextLine();

        String encrypted = encrypt(plainText, stringToKey(key));
        System.out.println("Encrypted:");
        System.out.println(encrypted);
        System.out.println("Decrypted:");
        System.out.println(decrypt(encrypted, stringToKey(key)));
        System.out.println();

    }

    public static String encrypt(String plainText, int[] key) {

        if(!checkValidKey(key)) return "key is invalid.";
        plainText = plainText.toLowerCase();
        String result = "";

        double temp = (double)plainText.length()/((double)key.length);

        int x = key.length;
        int y = (int) Math.ceil(temp);
        int rowColumn = y*x;

        //System.out.println("x length: "+x+"\ny Length: "+y+"\nText Length: "+plainText.length());

        char[][] matrix = new char[x][y];

        plainText = plainText.replace(' ', '%');

        int count = 0;

        for (int j = 0; j < y; j++){
            for (int i = 0; i < x; i++){
                if(count < plainText.length()) {
                    matrix[i][j] = plainText.charAt(count);
                    count++;
                }else{
                    matrix[i][j] = '%';
                }
            }
        }

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                result += matrix[key[i]-1][j];
            }
        }

        return result;
    }

    public static String decrypt(String encryptedText, int[] key) {
        if(!checkValidKey(key)) return "key is invalid.";
        encryptedText = encryptedText.toLowerCase();
        String result = "";

        double temp = (double)encryptedText.length()/((double)key.length);

        int x = key.length;
        int y = (int) Math.ceil(temp);
        int rowColumn = y*x;

        //System.out.println("x length: "+x+"\ny Length: "+y+"\nText Length: "+encryptedText.length());

        char[][] matrix = new char[x][y];

        int count = 0;

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if(count < encryptedText.length()) {
                    matrix[key[i]-1][j] = encryptedText.charAt(count);
                    count++;
                }
            }
        }

        for (int j = 0; j < y; j++){
            for (int i = 0; i < x; i++){
                result += matrix[i][j];
            }
        }

        return result;
    }

    public static int[] stringToKey(String key){
        int k[] = new int[key.length()];
        for(int i = 0; i<key.length(); i++){
            if (key.charAt(i) != ' '){
                k[i] = Character.getNumericValue(key.charAt(i));
            }else{
                i++;
            }
        }
        return k;
    }

    public static boolean checkValidKey(int[] key){
        //checks if number are consectutive starting at 1\
        int length = key.length;
        int tmp2 , tmp = 0;
        //most efficient way to tell if no good.
        for(int i = 0; i < length; i++){
            tmp+= key[i];
        }
        tmp2 = (length*(length+1))/2;
        if(tmp != tmp2) return false;
        int i,j;
        i = 0;
        j = 1;
        boolean check = true;
        while(i < length && j <= length){
            if(i==0){
                if(check == false) break;
                check = false;
            }
            if(key[i] == j) {
                i = 0;
                j++;
                check = true;
            }
            i++;
        }
        return check;
    }

}
