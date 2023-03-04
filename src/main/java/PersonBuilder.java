public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected boolean hasAge = false;
    protected boolean hasAddress = false;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        if (this.age < 0 || this.age > 150){
            throw new IllegalArgumentException("Incorrect age");
        }
        this.hasAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
        return this;
    }

    public Person build() {
        if (name == null || surname == null){
            throw new IllegalStateException("You didn't specify your name or last surname");
        }
        return new Person(this);
    }
}