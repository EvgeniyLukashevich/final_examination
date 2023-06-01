package step_2.task13_15.models.subtypes;

import step_2.task13_15.models.types.Pack;

/**
 * "Верблюды", дочерний класс класса Packs
 */
public class Camel extends Pack {

    /**
     * Конструктор класса Camel, дочернего от класса Packs,
     * который, в свою очередь, является дочерним классом базового класса Animal
     *
     * @param name     имя животного (String)
     * @param birthday дата рождения животного (String)
     */
    public Camel(String name, String birthday) {
        super.subtype = "camel";
        super.name = name;
        super.birthday = birthday;
    }
}
