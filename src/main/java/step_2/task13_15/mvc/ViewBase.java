package step_2.task13_15.mvc;

import step_2.task13_15.models.Animal;
import step_2.task13_15.models.types.Pack;
import step_2.task13_15.models.types.Pet;

import java.util.ArrayList;

/**
 * Базовый интервейс работы с вводом/выводом
 */
public interface ViewBase {
    abstract String userInput();

    abstract void showMainMenu();

    abstract void showAddMenu1();

    abstract void showAddMenu2();

    abstract void showAddMenu3();

    abstract void showAddMenuLast();

    abstract void showAnimals(ArrayList<Pet> pets, ArrayList<Pack> packs);

    abstract void showLearnMenu1(ArrayList<Animal> animals);

    abstract void showLearnMenu2();

    abstract void showLearnMenuLast(String name, String command);

    abstract void showErrorMessage();

    abstract void showExitMessage();
}
