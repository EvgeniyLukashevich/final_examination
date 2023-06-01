package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pack;

/**
 * "Лошади", дочерний класс класса Packs
 */
public class Horse extends Pack {

    /**
     * Конструктор класса Horse, дочернего от класса Packs,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Horse(String name, String birthday) {
        super.subtype = "horse";
        super.name = name;
        super.birthday = birthday;
    }
}
