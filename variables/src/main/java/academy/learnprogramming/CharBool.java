package academy.learnprogramming;

public class CharBool {

    public static void main(String[] args) {
        char myChar = 'A'; //size of char is 2 bytes -> 16 bits. to allo us to store unicode characters incl. emojis
        System.out.println(myChar);
        char aInUniCode = '\u0041';
        System.out.println(aInUniCode);

        char copyRightUni = '\u00A9';
        System.out.println(copyRightUni);

        boolean myBool = true;
        System.out.println(myBool);
    }
}
