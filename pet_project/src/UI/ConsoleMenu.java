package UI;

import Controller.PetController;
import Exceptions.IncorrectDataException;
import Model.PetType;
import Services.Counter;

import java.util.Scanner;

public class ConsoleMenu {

    PetController petController;

    public ConsoleMenu(PetController controller) {
        this.petController = controller;
    }

    public void start() {
        try (Scanner in = new Scanner(System.in); Counter count = new Counter()) {

            boolean flag = true;
            int id;
            while (flag) {

                System.out.println(
                        "\n1 - Список всех животных\n2 - Добавить животное\n3 - Изменить информацию о животном\n4 - Посмотреть список команд\n5 - Обучить животное\n6 - Удалить запись\n0 - Выход");
                String key = in.next();
                switch (key) {
                    case "1":
                        petController.getAllPet();
                        break;
                    case "2":
                        PetType type = menuChoice(in);
                        if (type != null) {
                            try {
                                petController.createPet(type, count.getId());
                                count.add();
                                System.out.println("ОК");
                            } catch (IncorrectDataException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            id = menuChoicePet(in);
                            if (id != 0)
                                try {
                                    petController.updatePet(id);
                                } catch (IncorrectDataException e) {
                                    System.out.println(e.getMessage());
                                }
                            else
                                break;
                        }
                        break;
                    case "4":
                        while (true) {
                            id = menuChoicePet(in);
                            if (id != 0)
                                petController.getCommands(id);
                            else
                                break;
                        }
                        break;
                    case "5":
                        id = menuChoicePet(in);
                        if (id != 0)
                            menuTrainPet(id, in);
                        break;
                    case "6":
                        id = menuChoicePet(in);
                        if (id != 0)
                            petController.delete(id);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("некорректный ввод");
                        break;
                }
            }
        }
    }

    private PetType menuChoice(Scanner in) {
        System.out.println("Какое животное добавить:\n1 - Кошка\n2 - Собака\n3 - Хомяк\n4 - Осел\n5 - Лошадь\n0 - Возврат в основное меню");

        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    return PetType.Cat;
                case "2":
                    return PetType.Dog;
                case "3":
                    return PetType.Hamster;
                case "4":
                    return PetType.Donkey;
                case "5":
                    return PetType.Horse;
                case "0":
                    return null;
                default:
                    System.out.println("Такого варианта нет, введите число от 0 до 5");
                    break;
            }
        }
    }

    private int menuChoicePet(Scanner in) {
        System.out.println("\nВведите номер животного, 0 для возврата в основное меню: ");
        while (true) {
            int id = in.nextInt();
            in.nextLine();
            if (id == 0)
                return id;
            if (petController.getById(id) == null) {
                System.out.println("Животного с таким номером нет, попробуйте еще раз, 0 для возврата в основное меню:");
            } else
                return id;

        }
    }

    private void menuTrainPet(int petId, Scanner in) {
        Scanner sc = in;
        while (true) {
            System.out.println("Введите новую команду, 0 для возврата в основное меню: ");
            String command = sc.nextLine();
            if (command.length() == 1 && command.equals("0"))
                return;
            if (petController.trainPet(petId, command))
                System.out.println("Команда добавлена!");
        }
    }
}
