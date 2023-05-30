package UI;

import Model.Pet;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getName() {
        System.out.printf("Имя: ");
        return in.nextLine();
    }

    @Override
    public String getBirthday() {
        System.out.printf("Введите дату рождения в формате 'dd.mm.yyyy': ");
        return in.nextLine();
    }

    @Override
    public <T> void printAll(List<T> list, Class<T> clazz) {
        System.out.print("\n");
        if (list.isEmpty())
            System.out.println("список пуст");
        else {
            if (clazz == Pet.class)
                System.out.println("\nСписок животных");
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
