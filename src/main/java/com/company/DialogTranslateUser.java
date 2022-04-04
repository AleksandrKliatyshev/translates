package com.company;

import java.io.IOException;
import java.util.Scanner;

public class DialogTranslateUser {
    Scanner sc = new Scanner(System.in);
    private int numWhile = -1;
    Translate translates;

    public DialogTranslateUser(Translate translate) {
        this.translates = translate;
    }

    public void dialogUserPat2() throws IOException {

        while (numWhile == -1) {
            System.out.println("Выберите действие: \n" +
                    "1. Просмотреть словарь\n" +
                    "2. Удаление запись\n" +
                    "3. Поиск записи \n" +
                    "4. Добавление записи\n" +
                    "0. На предыдущий уровень");
            int numPoint = Integer.parseInt(sc.nextLine());
            switch (numPoint) {
                case 1:
                    translates.showFile();
                    break;
                case 2:
                    System.out.println("Какую запись удалить? Введите слово:");
                    String str = new Scanner(System.in).nextLine();
                    if (translates.checkInput(translates, str)) {
                        if (translates.adderMap().containsKey(str)) {
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
                        if (translates.adderMap().containsKey(str1)) {
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
                        if (!translates.adderMap().containsKey(str2)) {
                            translates.adder(str2, str3);
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
                    numWhile = 0;
            }

        }
    }

}
