import java.util.OptionalInt;

public class Main {

    public static void main(String[] args)  {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        son.happyBirthday();
        System.out.println(son);

        Person dad = new PersonBuilder()
                .setName("Толян")
                .setSurname("Коловратов")
                .build();

        System.out.println(dad);



        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}
