package step_2.task13_15.mvc;

import step_2.task13_15.models.Animal;
import step_2.task13_15.models.types.Pack;
import step_2.task13_15.models.types.Pet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс работающий с вводом/выводом, ориентированный на работу в консоли.
 * Наследник базового интерфеса ViewBase.
 */
public class ViewConsole implements ViewBase {

    @Override
    public String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void showMainMenu() {
        String mainMenu = "\n# # # # # # # # # # # # # # # # # # # # # # # # #\n" +
                "1 - Добавить животное\n" +
                "2 - Обучить животное\n" +
                "3 - Вывести список животных\n" +
                "Any other key - Выход\n" +
                "Выберите нужный пункт меню: ";
        System.out.println(mainMenu);
    }

    @Override
    public void showAddMenu1() {
        String addMenu1 = "\n1 - Собака\n" +
                "2 - Кошка\n" +
                "3 - Хомяк\n" +
                "4 - Лошадь\n" +
                "5 - Верблюд\n" +
                "6 - Осёл\n" +
                "Any other key - Выход\n" +
                "Выберите нужный вид животного: ";
        System.out.println(addMenu1);
    }

    @Override
    public void showAddMenu2() {
        System.out.println("\nВведите имя животного: ");
    }

    @Override
    public void showAddMenu3() {
        System.out.println(
                "\nФормат даты: 'дд.мм.гггг' (Например: 12.12.2012)\n" +
                        "Введите дату рождения животного: ");
    }

    @Override
    public void showAddMenuLast() {
        System.out.println("\nЖивотное успешно добавлено!");
    }

    @Override
    public void showAnimals(ArrayList<Pet> pets, ArrayList<Pack> packs) {
        System.out.println("\n### ДОМАШНИЕ ЖИВОТНЫЕ ###\n");
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }
        System.out.println("\n### ВЬЮЧНЫЕ ЖИВОТНЫЕ ###\n");
        for (Pack pack : packs) {
            System.out.println(pack.toString());
        }

    }

    @Override
    public void showLearnMenu1(ArrayList<Animal> animals) {
        System.out.println("\n### СПИСОК ВСЕХ ЖИВОТНЫХ ###");
        for (Animal animal : animals)
            System.out.println(animal.toString());
        System.out.println("\nВведите имя животного, которого необходимо обучить: ");
    }

    @Override
    public void showLearnMenu2() {
        System.out.println("\nВведите команду, которую животное должно выучить: ");

    }

    @Override
    public void showLearnMenuLast(String name, String command) {
        System.out.println(
                "\nЖивотное " + name + " успешно выучило команду " + command + "!");

    }

    @Override
    public void showErrorMessage() {
        System.out.println("\nПроизошла ошибка. Повторите попытку.\n");
    }

    @Override
    public void showExitMessage() {
        System.out.println("\nВсего доброго! :)");

    }
}
