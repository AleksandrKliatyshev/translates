package com.company;

import java.io.IOException;
import java.util.Scanner;

public class DialogTranslateUser {
    private Scanner sc = new Scanner(System.in);
    private int criterion = -1;
    private Translate translates;
    private int numPoint;

    public DialogTranslateUser(Translate translate) {
        this.translates = translate;
    }

    public void dialogUserPatTow() throws IOException {
        while (criterion == -1) {
            System.out.println("Выберите действие: \n" +
                    "1. Просмотреть словарь\n" +
                    "2. Удаление запись\n" +
                    "3. Поиск записи \n" +
                    "4. Добавление записи\n" +
                    "0. На предыдущий уровень");
            numPoint = Integer.parseInt(sc.nextLine());
            bodyProgram();
        }
    }

    public void bodyProgram() throws IOException {
        switch (numPoint) {
            case 1:
                translates.showFile();
                break;
            case 2:
                System.out.println("Какую запись удалить? Введите слово:");
                String str = new Scanner(System.in).nextLine();
                if (translates.checkInput(translates, str)) {
                    if (translates.addInMap().containsKey(str)) {
                        translates.removes(str);
                    } else {
                        System.out.println("Вы ошиблись, такого слова в словаре нет");
                        break;
                    }
                } else {
                    System.out.println("Вы ввели неверное значение");
                    break;
                }
                break;
            case 3:
                System.out.println("Что Вы хотели найти? Введите слово:");
                String str1 = new Scanner(System.in).nextLine();
                if (translates.checkInput(translates, str1)) {
                    if (translates.addInMap().containsKey(str1)) {
                        translates.getWorld(str1);
                    } else {
                        System.out.println("Вы ошиблись, такого слова в словаре нет");
                        break;
                    }
                } else {
                    System.out.println("Вы ввели неверное значение");
                    break;
                }
                break;
            case 4:
                System.out.println("Что Вы Хотели добавить в словарь");
                String str2 = new Scanner(System.in).nextLine();
                System.out.println("Введите перевод: \n");
                String str3 = new Scanner(System.in).nextLine();
                if (translates.checkInput(translates, str2)) {
                    if (!translates.addInMap().containsKey(str2)) {
                        translates.add(str2, str3);
                    } else {
                        System.out.println("Такое слово уже есть в словаре");
                        break;
                    }
                } else {
                    System.out.println("Вы ввели неверное значение");
                    break;
                }
                break;
            case 0:
                criterion = 0;
        }
    }

}
