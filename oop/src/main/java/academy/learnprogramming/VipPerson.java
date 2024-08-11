package academy.learnprogramming;

public class VipPerson {

    private String name;
    private int creditLimit;
    private String emailAddress;

    public VipPerson() {
        this.name = "default name";
        this.creditLimit = 0;
        this.emailAddress = "default email";
    }

    public VipPerson(String name, String emailAddress) {
        this(name, 0, emailAddress);
    }

    public VipPerson(String name, int creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "VipPerson{" +
                "name='" + name + '\'' +
                ", creditLimit=" + creditLimit +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
