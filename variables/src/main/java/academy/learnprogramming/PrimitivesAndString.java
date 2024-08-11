package academy.learnprogramming;

public class PrimitivesAndString {

    public static void main(String[] args) {
        /* primitives
          char
          boolean
          byte
          short
          int
          long
          float
          double
         */

        String myString = "This is a String";
        System.out.println(myString);
        // a String is a sequence of characters. it can contain as much as MAX_VALUE of int number of chars.
        myString += ", and this is more.";
        System.out.println(myString);
        myString += " \u00A9 2019";
        System.out.println(myString);

        String numberString = "250.00";
        numberString += "49.95";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        lastString += myInt;
        System.out.println(lastString);

        double dNumber = 120.47;
        lastString += dNumber;
        System.out.println(lastString);


    }
}
