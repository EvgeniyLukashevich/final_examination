package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pack;

/**
 * "Ослы", дочерний класс класса Packs
 */
public class Donkey extends Pack {

    /**
     * Конструктор класса Donkey, дочернего от класса Packs,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Donkey(String name, String birthday) {
        super.subtype = "donkey";
        super.name = name;
        super.birthday = birthday;
    }
}
