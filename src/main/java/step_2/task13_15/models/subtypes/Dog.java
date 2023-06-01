package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pet;

/**
 * "Собаки", дочерний класс класса Pets
 */
public class Dog extends Pet {

    /**
     * Конструктор класса Dog, дочернего от класса Pets,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Dog(String name, String birthday) {
        super.subtype = "dog";
        super.name = name;
        super.birthday = birthday;
    }
}
