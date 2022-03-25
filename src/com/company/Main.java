package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Pattern pattern = Pattern.compile("[A-Za-z]{4}");
    static Pattern pattern1 = Pattern.compile("\\d{5}");

    public static void main(String[] args) throws IOException {
        Form fr = new Form();
        fr.mainForm();
        Scanner sc = new Scanner(System.in);
        int input0 = -1;
        while (input0 == -1) {
            System.out.println("Что бы Вы хотели выполнить?\n" +
                    "1. Посмотреть содержимое словаря;\n" +
                    "2. Добавить запись в словарь;\n" +
                    "3. Удалить запись из словаря\n" +
                    "4. Воспользоваться словарём\n" +
                    "0. Выйти\n" +
                    "(Для продолжения введите номер пункта)");
            int input1 = sc.nextInt();
            switch (input1) {
                case (1) -> {
                    BDTranslateLat.showFile();
                    break;
                }
                case (2) -> {
                    System.out.println("При добавлении записи помни:\n" +
                            "- Словарь осуществляет перевод с латиницы на digital язык" +
                            "- длина слов латиницы может быть только 4 символа, а digital - строго 5\n" +
                            "и это только цифры\n" +
                            "Пожалуйста, направление перевода:\n" +
                            "1. Латиница -> digital\n" +
                            "2. digital ->Латиница\n" +
                            "0. Выйти");
                    int input2 = sc.nextInt();
                    switch (input2) {
                        case 1 -> {
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Введите 4 латинских символа");
                            String str = sc1.nextLine();
                            Matcher matcher = pattern.matcher(str);
                            if (matcher.matches()) {
                                System.out.println("Введите 5 цифр");
                                String num = sc1.nextLine().trim();
                                matcher = pattern1.matcher(num);
                                if (matcher.matches()) {
                                    BDTranslateLat.adder(str, Integer.parseInt(num));
                                    System.out.println("Записано");
                                } else {
                                    System.out.println("Вы ввели неверное значение, надо повторить");
                                }
                                break;
                            } else {
                                System.out.println("Вы ввели неверное значение, надо повторить?");
                            }
                        }
                        case (2) -> {
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Введите 5 цифр");
                            Pattern pattern1 = Pattern.compile("\\d{5}");
                            String num = sc1.nextLine().trim();
                            Matcher matcher = pattern1.matcher(num);
                            if (matcher.matches()) {
                                System.out.println("Введите 4 латинских символа");
                                Pattern pattern = Pattern.compile("[A-Za-z]{4}");
                                String str = sc1.nextLine();
                                matcher = pattern.matcher(str);
                                if (matcher.matches()) {
                                    BDTranslateDig.adder(Integer.parseInt(num), str);
                                    System.out.println("Записано");
                                } else {
                                    System.out.println("Вы ввели неверное значение, надо повторить");
                                }
                            }
                        }
                    }
                }
                case (3) -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите значение которое надо удалить:");
                    String str3 = scanner.nextLine();
                    Matcher matcher = pattern.matcher(str3);
                    if (matcher.matches()) {
                        BDTranslateLat.removes(str3);
                        System.out.println("Удалено");
                    } else {
                        System.out.println("Вы ввели неверное значение, надо повторить");
                    }
                    break;
                }
                case (4) -> {
                    System.out.println("Пожалуйста,укажи направление перевода:\n" +
                            "1. Латиница -> digital\n" +
                            "2. digital ->Латиница\n" +
                            "0. Выйти");
                    int input2 = sc.nextInt();
                    switch (input2) {
                        case 1 -> {
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Введите 4 латинских символа");
                            String str = sc1.nextLine();
                            Matcher matcher = pattern.matcher(str);
                            if (matcher.matches()) {
                                BDTranslateLat.getWorld(str);
                                System.out.println("Готово");
                            } else {
                                System.out.println("Вы ввели неверное значение, надо повторить?");
                            }
                            break;
                        }
                        case (2) -> {
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("Введите 5 цифр");
                            Pattern pattern1 = Pattern.compile("\\d{5}");
                            String num = sc1.nextLine().trim();
                            Matcher matcher = pattern1.matcher(num);
                            if (matcher.matches()) {
                                System.out.println("Введите 4 латинских символа");
                                Pattern pattern = Pattern.compile("[A-Za-z]{4}");
                                String str = sc1.nextLine();
                                matcher = pattern.matcher(str);
                                if (matcher.matches()) {
                                    BDTranslateDig.getWorld(Integer.parseInt(num));
                                    System.out.println("Готово");
                                } else {
                                    System.out.println("Вы ввели неверное значение, надо повторить");
                                }
                            }
                            break;
                        }
                    }
                }case (0) -> input0 = 0;
            }
        }
    }
}

