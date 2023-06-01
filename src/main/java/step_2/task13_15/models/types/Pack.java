package step_2.task13_15.models.types;

import step_2.task13_15.models.Animal;

/**
 * "Вьючные животные", дочений класс класса Animal
 */
public class Pack extends Animal {
    protected Pack() {
        super.type = "pack";
    }
}
