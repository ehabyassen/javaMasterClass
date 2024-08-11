package academy.learnprogramming;

public class OperatorsOperandsExpressions {

    public static void main(String[] args) {
        int res = 1 + 2;
        System.out.println(res);

        int prevRes = res;
        System.out.println(prevRes);
        res -= 1;
        System.out.println(res);
        System.out.println(prevRes);

        int a = 5 | 3;
        System.out.println(a);

        boolean x = true;
        int b = x ? 1 : 2;
        System.out.println(b);


    }
}
