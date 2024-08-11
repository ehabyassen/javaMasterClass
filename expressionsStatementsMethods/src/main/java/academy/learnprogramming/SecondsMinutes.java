package academy.learnprogramming;

public class SecondsMinutes {

    public static void main(String[] args) {
        System.out.println(getDurationString(61, 15));
        System.out.println(getDurationString(11, 3));
    }

    private static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && seconds >=0 && seconds <= 59) {
            int hours = minutes / 60;
            minutes %= 60;
            String hs = hours < 10 ? "0" + hours + "h " : hours + "h ";
            String ms = minutes < 10 ? "0" + minutes + "m " : minutes + "m ";
            String ss = seconds < 10 ? "0" + seconds + "s " : seconds + "s";
            return hs + ms + ss;
        } else {
            return "Invalid value";
        }
    }
}
