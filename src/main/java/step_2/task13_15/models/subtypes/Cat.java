package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pet;

/**
 * "Кошки", дочерний класс класса Pets
 */
public class Cat extends Pet {

    /**
     * Конструктор класса Cat, дочернего от класса Pets,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Cat(String name, String birthday) {
        super.subtype = "cat";
        super.name = name;
        super.birthday = birthday;
    }
}
