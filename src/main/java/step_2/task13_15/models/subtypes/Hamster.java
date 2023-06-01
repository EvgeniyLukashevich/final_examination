package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pet;

/**
 * "Хомяки", дочерний класс класса Pets
 */
public class Hamster extends Pet {

    /**
     * Конструктор класса Hamster, дочернего от класса Pets,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Hamster(String name, String birthday) {
        super.subtype = "hamster";
        super.name = name;
        super.birthday = birthday;
    }
}
