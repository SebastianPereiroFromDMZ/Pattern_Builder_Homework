import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;


    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        if(!hasAge()) {
            this.age = age;
        }
        if (!hasAddress()) {
            this.address = address;
        }
    }


    public boolean hasAge() {
        return age != 0;
    }


    public boolean hasAddress() {
        return address != null;
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

    public PersonBuilder newChildBuilder()  {
        Random random = new Random();
        int maxChildAge = 14;
        return new PersonBuilder().setSurname(this.surname).setAge(random.nextInt(maxChildAge)).setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                (hasAge()? ", age='" + age + "'" : " ") +
                (hasAddress()? ", address='" + address + "'" : " " ) +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
