package step_2.task13_15.models.types;

import step_2.task13_15.models.Animal;

/**
 * "Домашние животные", дочений класс класса Animal
 */
public class Pet extends Animal {
    protected Pet() {
        super.type = "pet";
    }
}
