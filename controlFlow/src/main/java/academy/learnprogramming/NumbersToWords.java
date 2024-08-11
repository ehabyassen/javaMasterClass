package academy.learnprogramming;

public class NumbersToWords {

    public static void main(String[] args) {
        numberToWords(11);
    }

    public static void numberToWords(int num) {
        if (num < 0) {
            System.out.println("Invalid Value");
        } else {
            if (num == 0) {
                System.out.println("Zero");
            }
            String words = "";
            int revNum = reverse(num);
            int numLength = getDigitCount(num);
            int revNumLength = getDigitCount(revNum);
            String curWord;
            while (revNum > 0) {
                switch (revNum % 10) {
                    case 0:
                        curWord = "Zero";
                        break;
                    case 1:
                        curWord = "One";
                        break;
                    case 2:
                        curWord = "Two";
                        break;
                    case 3:
                        curWord = "Three";
                        break;
                    case 4:
                        curWord = "Four";
                        break;
                    case 5:
                        curWord = "Five";
                        break;
                    case 6:
                        curWord = "Six";
                        break;
                    case 7:
                        curWord = "Seven";
                        break;
                    case 8:
                        curWord = "Eight";
                        break;
                    case 9:
                        curWord = "Nine";
                        break;
                    default:
                        curWord = "";
                        break;
                }
                words += curWord + " ";
                revNum /= 10;
            }
            if (revNumLength < numLength) {
                for (int i = 0; i < numLength - revNumLength; i++) {
                    words = words + "Zero ";
                }
            }
            System.out.println(words);
        }
    }
    public static int reverse(int num) {
        boolean isNumNegative = num < 0;
        num = isNumNegative ? -1 * num : num;
        int length = getDigitCount(num);
        int rev = 0;
        while (num > 0) {
            rev += num % 10 * Math.pow(10, length - 1);
            length--;
            num /= 10;
        }
        return isNumNegative ? -1 * rev : rev;
    }

    public static int getDigitCount(int num) {
        if (num < 0) {
            return -1;
        } else if (num == 0) {
            return 1;
        } else {
            int count = 0;
            while (num > 0) {
                num /= 10;
                count++;
            }
            return count;
        }
    }
}
