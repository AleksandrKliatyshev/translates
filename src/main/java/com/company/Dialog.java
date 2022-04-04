package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Dialog {
    private int input0 = -1;

    public void dialogUser() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (input0 == -1) {
            System.out.println("Здравствуйте, каким словарём Вы бы хотели воспользоваться?\n" +
                    "1. Цифро-русским\n" +
                    "2. Англо-русским\n" +
                    "0. Выход");
            int inputNumber = sc.nextInt();
            switch (inputNumber) {
                case 1:
                    Translate digRu = new Translate("Resources\\translateDigital.txt");
                    DialogTranslateUser dialogDig = new DialogTranslateUser(digRu);
                    dialogDig.dialogUserPat2();
                    break;
                case 2:
                    Translate enRu = new Translate("Resources\\translateLatin.txt");
                    DialogTranslateUser dialogEn = new DialogTranslateUser(enRu);
                    dialogEn.dialogUserPat2();
                    break;
                case 0:
                    input0 = 0;
            }
        }
    }
}
