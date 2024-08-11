package academy.learnprogramming;

public class VipPersonApp {

    public static void main(String[] args) {
        VipPerson p1 = new VipPerson("person1", 5_000, "p1@gmail.com");
        VipPerson p2 = new VipPerson("person2", "p2@gmail.com");
        VipPerson p3 = new VipPerson();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
