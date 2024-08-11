package academy.learnprogramming;

public class PrimitiveTypesChallenge {

    public static void main(String[] args) {
        byte myByte = 112;
        short myShort = 23233;
        int myInt = 1_221_543_432;

        long myLong = 50_000 + 10L * (myByte + myShort + myInt);

        System.out.println(myLong);

        short shortTotal = (short) (1000 + 10 * (myByte + myShort + myInt));

        System.out.println(shortTotal);
    }
}
