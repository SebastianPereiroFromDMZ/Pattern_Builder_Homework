import java.util.Objects;
import java.util.OptionalInt;
import java.util.Random;


public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String address;
    private boolean hasAge = false;
    private boolean hasAddress = false;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        if (personBuilder.hasAge) {
            this.age = personBuilder.age;
            this.hasAge = true;
        }
        if (personBuilder.hasAddress) {
            this.address = personBuilder.address;
            this.hasAddress = true;
        }
    }


    public boolean hasAge() {
        return hasAge;
    }


    public boolean hasAddress() {
        return hasAddress;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void happyBirthday() {
        this.age = age + 1;
    }

    public PersonBuilder newChildBuilder() {
        Random random = new Random();
        int maxChildAge = 14;
        return new PersonBuilder().setSurname(this.surname).setAge(random.nextInt(maxChildAge)).setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                (hasAge() ? ", age='" + age + "'" : " ") +
                (hasAddress() ? ", address='" + address + "'" : " ") +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}