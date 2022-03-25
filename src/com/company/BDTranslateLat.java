package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;


import java.util.*;
public class BDTranslateLat {
    static String dirPath = "C:\\Users\\dobro\\IdeaProjects\\translate\\translate0.txt";
    static Path path = Path.of(dirPath);
    static Map<String, Integer> translateMap = new HashMap<>();
    static List<String> readTranslateBook;

    static {
        try {
            readTranslateBook = Files.readAllLines(path, Charset.forName("windows-1251"));
            System.out.println(readTranslateBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> adderMap() throws IOException {
        readBook();
        return translateMap;
    }

    //просмотр словаря
    static public void showFile() throws IOException {
        try {
            readTranslateBook = Files.readAllLines(path, Charset.forName("windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        readBook();
    }

    private static void readBook() throws IOException {
        readTranslateBook = Files.readAllLines(path, Charset.forName("windows-1251"));
        if (!readTranslateBook.isEmpty() ) {
            for (int i = 0; i < readTranslateBook.size(); i += 2) {
                translateMap.put(readTranslateBook.get(i), Integer.parseInt(readTranslateBook.get(i + 1)));
                System.out.println(i / 2 + " пара " + readTranslateBook.get(i) + " " + readTranslateBook.get(i + 1));
            }
        } else {
            System.out.println("Словарь совсем пустой");
        }
    }

    //удаление по ключу
    static public void removes(String str) throws IOException {
        BDTranslateLat.adderMap();
        BDTranslateLat.writerZero();
        translateMap.remove(str);
        Files.write(path, iterator(translateMap));
    }

    //добавление в словарь
    static public void adder(String str, int num) throws IOException {
        BDTranslateLat.adderMap().put(str, num);
        BDTranslateLat.writerZero();
        iterator(translateMap);
        Files.write(path, iterator(translateMap));
    }

    //из мапы в формат для записи в файл
    public static List<String> iterator(Map<String, Integer> map) {
        List<String> listStr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            listStr.add(key);
            Integer value = entry.getValue();
            String valueStr = value.toString();
            listStr.add(valueStr);
        }
        return listStr;
    }

    //удаление содержимого файла
    public static void writerZero() {
        try {
            FileWriter fstream1 = new FileWriter(dirPath);
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }

    public static void getWorld(String str) throws IOException {
        System.out.println(BDTranslateLat.adderMap().get(str));
    }


}
