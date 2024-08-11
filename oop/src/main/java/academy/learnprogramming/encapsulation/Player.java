package academy.learnprogramming.encapsulation;

public class Player {

    private String fullName;
    private int health;
    private String weapon;

    public Player(String name, String weapon) {
        this(name, 100, weapon);
    }

    public Player(String name, int health, String weapon) {
        this.fullName = name;
        this.health = health <= 0 ? 1 : health;
        this.weapon = weapon;
    }

    public String getFullName() {
        return fullName;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }
}
