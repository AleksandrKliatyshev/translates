package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Dialog {
    private int inputStart = -1;

    public void dialogUser() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (inputStart == -1) {
            System.out.println("Здравствуйте, каким словарём Вы бы хотели воспользоваться?\n" +
                    "1. Цифро-русским\n" +
                    "2. Англо-русским\n" +
                    "0. Выход");
            int inputNumber = sc.nextInt();
            switch (inputNumber) {
                case 1:
                    Translate digRu = new Translate("src//main//resources//translateDigital.txt");
                    DialogTranslateUser dialogDig = new DialogTranslateUser(digRu);
                    dialogDig.dialogUserPat2();
                    break;
                case 2:
                    Translate enRu = new Translate("src//main//resources//translateLatin.txt");
                    DialogTranslateUser dialogEn = new DialogTranslateUser(enRu);
                    dialogEn.dialogUserPat2();
                    break;
                case 0:
                    inputStart = 0;
            }
        }
    }
}
