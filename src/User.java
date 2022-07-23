import java.util.Objects;

class User{
    private int id;
    private String firstName;
    private String lastName;
    private float money;

    public User(int id, String firstName, String lastName, float money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                " id= " + id +
                ", firstName= '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", money = " + money +
                '}';
    }

}
