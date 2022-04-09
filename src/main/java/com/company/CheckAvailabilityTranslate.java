package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckAvailabilityTranslate {

    private static final String DIRDIG = "src//main//resources//translateDigital.txt";
    private static final String DIRLAT = "src//main//resources//translateLatin.txt";

    public void checkExistFile () throws IOException {
        Translate translateDig = new Translate(DIRDIG);
        Translate translateLat = new Translate(DIRLAT);
        if (!Files.exists(Path.of(DIRDIG))) {
            Files.createFile(Path.of(DIRDIG));
            translateDig.adder("55555", "Дом");
            translateDig.adder("44444", "Дерево");
            translateDig.adder("11111", "Дверь");
            translateDig.adder("22222", "Нога");
            translateDig.adder("33333", "Дорога");
        }
        if(!Files.exists(Path.of(DIRLAT))){
            Files.createFile(Path.of(DIRLAT));
            translateLat.adder("home", "Дом");
            translateLat.adder("tree", "Дерево");
            translateLat.adder("door", "Дверь");
            translateLat.adder("foot", "Нога");
            translateLat.adder("rose", "Роза");
        }
        if(Files.size(Path.of(DIRDIG)) == 0 ){
            translateDig.adder("55555", "Дом");
            translateDig.adder("44444", "Дерево");
            translateDig.adder("11111", "Дверь");
            translateDig.adder("22222", "Нога");
            translateDig.adder("33333", "Дорога");
        }
        if(Files.size(Path.of(DIRLAT)) == 0 ){
            translateLat.adder("home", "Дом");
            translateLat.adder("tree", "Дерево");
            translateLat.adder("door", "Дверь");
            translateLat.adder("foot", "Нога");
            translateLat.adder("rose", "Роза");
        }
    }
}
