package academy.learnprogramming;

public class PrimitiveTypes {

    public static void main(String[] args) {
        int e = 1000; //takes 4 bytes / 32 bits in memory. can be signed or unsigned.
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println(myMinIntValue);
        System.out.println(myMaxIntValue);
        System.out.println(myMinIntValue - 1);

        //int myMaxIntTest = 2147483648; overflow int max value with 1
        //int myMinIntTest = -2147483649; underflow int min value with 1

        //the basic declaration of an int declares a signed int where the most bit to the left is the sign bit.

        int x = 2_147_483_647;

        byte minByte = Byte.MIN_VALUE;      //a byte is 8 bits
        byte maxByte = Byte.MAX_VALUE;

        System.out.println(minByte);
        System.out.println(maxByte);

        short minShort = Short.MIN_VALUE; //a short is 2 bytes -> 16 bits
        short maxShort = Short.MAX_VALUE;

        System.out.println(minShort);
        System.out.println(maxShort);

        long longVal = 100L; //an L must be put at the end
        long minLong = Long.MIN_VALUE; // a long takes 8 bytes -> 64 bits
        long maxLong = Long.MAX_VALUE;

        System.out.println(minLong);
        System.out.println(maxLong);
        long bigLongLiteralValue = 2_147_483_647_234L; //compiler will complain if we don't add an L next to the value

        int myTotal = (myMinIntValue / 2);
        byte myNewByteValue = (byte) (minByte / 2); //we cast here because the default type in java is an int if not
        //specified. so java treats the value between the parentheses as an int. so a casting to byte is required here

        short myNewShortVal = (short) (minShort / 2);



    }
}
