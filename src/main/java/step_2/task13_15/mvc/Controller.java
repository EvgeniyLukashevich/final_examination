package step_2.task13_15.mvc;

import step_2.task13_15.data.BaseData;
import step_2.task13_15.models.Animal;
import step_2.task13_15.models.subtypes.*;
import step_2.task13_15.models.types.Pack;
import step_2.task13_15.models.types.Pet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Контроллер, использующий некоторую модель, вью и дата
 */
public class Controller {
    private BaseData data;
    private ModelBase model;
    private ViewBase view;

    /**
     * Конструктор контроллера
     *
     * @param data  экземляр класса управляющего чтением/записью данных
     * @param model экземпляр класса, управляющего логикой каких-нибудь функций
     * @param view  экземпляр класс, управляющего вводом/выводом
     */
    public Controller(BaseData data, ModelBase model, ViewBase view) {
        this.data = data;
        this.model = model;
        this.view = view;
    }

    /**
     * Метод запуска приложения
     */
    public void start() {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Pet> pets = new ArrayList<>();
        ArrayList<Pack> packs = new ArrayList<>();


        while (true) {
            try {
                animals = data.dataOut();
                pets.clear();
                packs.clear();
                for (Animal animal : animals)
                    if (animal instanceof Pet) {
                        pets.add((Pet) animal);
                    } else {
                        packs.add((Pack) animal);
                    }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            view.showMainMenu();
            String userInput = view.userInput();

            if (userInput.equals("1")) {
                try {
                    view.showAddMenu2();
                    String animalName = view.userInput();
                    view.showAddMenu3();
                    String animalBirthday = model.dateCheck(view.userInput());
                    view.showAddMenu1();
                    String animalSubtype = view.userInput();
                    Animal animal;

                    switch (animalSubtype) {
                        case "1" -> animal = new Dog(animalName, animalBirthday);
                        case "2" -> animal = new Cat(animalName, animalBirthday);
                        case "3" -> animal = new Hamster(animalName, animalBirthday);
                        case "4" -> animal = new Horse(animalName, animalBirthday);
                        case "5" -> animal = new Camel(animalName, animalBirthday);
                        case "6" -> animal = new Donkey(animalName, animalBirthday);
                        default -> {
                            continue;
                        }
                    }

                    data.dataIn(animal);
                    view.showAddMenuLast();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                    view.showErrorMessage();
                }

            } else if (userInput.equals("2")) {
                try {
                    view.showLearnMenu1(animals);
                    String animalName = view.userInput();
                    boolean bingo = false;
                    for (Animal animal : animals)
                        if (animal.getName().equals(animalName)) {
                            bingo = true;
                            view.showLearnMenu2();
                            String command = view.userInput().strip();
                            animal.addCommand(command);
                            data.dataIn(animal);
                            view.showLearnMenuLast(animalName, command);
                            break;
                        }
                    if (!bingo)
                        view.showErrorMessage();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if (userInput.equals("3")) {
                view.showAnimals(pets, packs);

            } else {
                view.showExitMessage();
                break;
            }
        }
    }
}

