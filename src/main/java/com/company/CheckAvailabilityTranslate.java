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
            translateDig.add("55555", "Дом");
            translateDig.add("44444", "Дерево");
            translateDig.add("11111", "Дверь");
            translateDig.add("22222", "Нога");
            translateDig.add("33333", "Дорога");
        }
        if(!Files.exists(Path.of(DIRLAT))){
            Files.createFile(Path.of(DIRLAT));
            translateLat.add("home", "Дом");
            translateLat.add("tree", "Дерево");
            translateLat.add("door", "Дверь");
            translateLat.add("foot", "Нога");
            translateLat.add("rose", "Роза");
        }
        if(Files.size(Path.of(DIRDIG)) == 0 ){
            translateDig.add("55555", "Дом");
            translateDig.add("44444", "Дерево");
            translateDig.add("11111", "Дверь");
            translateDig.add("22222", "Нога");
            translateDig.add("33333", "Дорога");
        }
        if(Files.size(Path.of(DIRLAT)) == 0 ){
            translateLat.add("home", "Дом");
            translateLat.add("tree", "Дерево");
            translateLat.add("door", "Дверь");
            translateLat.add("foot", "Нога");
            translateLat.add("rose", "Роза");
        }
    }
}
