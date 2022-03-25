package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;


import java.util.*;

public class BDTranslateDig {
    static String dirPath = "C:\\Users\\dobro\\IdeaProjects\\translate\\translate0.txt";
    static Path path = Path.of(dirPath);
    static Map<Integer, String> translateMapDig = new HashMap<>();
    static List<String> readTranslateBookDig;

    static {
        try {
            readTranslateBookDig = Files.readAllLines(path, Charset.forName("windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //преобразование списка из файла в Map
    public static Map<Integer,String> adderMap(){
        readBook();
        return translateMapDig;
    }

    private static void readBook() {
        if (!readTranslateBookDig.isEmpty()) {
            for (int i = 0; i < readTranslateBookDig.size(); i += 2) {
                translateMapDig.put(Integer.parseInt(readTranslateBookDig.get(i + 1)), (readTranslateBookDig.get(i)));
                System.out.println(i / 2 + " пара " + readTranslateBookDig.get(i) + " " + readTranslateBookDig.get(i + 1));
            }
        } else {
            System.out.println("Словарь совсем пустой");
        }
    }

    //просмотр словаря
    static public void showFile() {
        try {
            readTranslateBookDig = Files.readAllLines(path, Charset.forName("windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        readBook();
    }
    //удаление по ключу
    static public void removes(String str) throws IOException {
        adderMap();
        writerZero();
        translateMapDig.remove(str);
        Files.write(path, iterator(translateMapDig));
    }
    //добавление в словарь
    static public void adder(int num, String str) throws IOException {
        BDTranslateDig.adderMap().put(num, str);
        BDTranslateDig.writerZero();
        iterator(translateMapDig);
        Files.write(path, iterator(translateMapDig));
    }
    //из мапы в формат для записи в файл
    public static List <String> iterator(Map<Integer, String> map){
        List <String> listStr = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            listStr.add(value);
            listStr.add(key.toString());
        }
        return listStr;
    }
    //удаление содержимого файла
    public static void writerZero(){
        try {
            FileWriter fstream1 = new FileWriter(dirPath);
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    public static void getWorld(int num){
        adderMap();
        System.out.println(translateMapDig.get(num));
    }

}
