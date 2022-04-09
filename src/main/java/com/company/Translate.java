package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Translate {
    private final String dirPath;
    private boolean check = false;
    private final Path path;
    private Map<String, String> translateMap = new HashMap<>();

    public Translate(String str) {
        this.dirPath = str;
        this.path = Path.of(str);
    }

    public List<String> readFile() throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }


    public Map<String, String> adderMap() throws IOException {
        readBook();
        return translateMap;
    }


    public void showFile() throws IOException {
        readFile();
        System.out.println(adderMap());
    }

    public void readBook() throws IOException {
        if (!readFile().isEmpty()) {
            readFile();
            List<String> world = new ArrayList<>();
            for (var str : readFile()) {
                Collections.addAll(world, str.split("\\s"));
            }
            for (int i = 0; i < world.size() - 1; i += 2) {
                translateMap.put(world.get(i), world.get(i + 1));
            }

        } else {
            System.out.println("Словарь совсем пустой");
        }
    }

    public boolean checkInput(Translate digOrEnWorld, String str) {

        if (digOrEnWorld.dirPath.equals("src//main//resources//translateLatin.txt")) {
            Pattern pattern = Pattern.compile("[A-Za-z]{4}");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                check = true;
            }
        } else {
            Pattern pattern = Pattern.compile("\\d{5}");
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                check = true;
            }
        }
        return check;
    }

    public void removes(String str) throws IOException {
        adderMap();
        writerZero();
        adderMap().remove(str);
        Files.write(path, preparing(adderMap()));
    }

    public void adder(String str1, String str2) throws IOException {
        adderMap().put(str1, str2);
        writerZero();
        Files.write(path, preparing(adderMap()));
    }

    public List<String> preparing(Map<String, String> map) {
        List<String> listStr = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            listStr.add(key + " " + value);
        }
        return listStr;
    }

    public void writerZero() {
        try {
            FileWriter fileWriter = new FileWriter(dirPath);
            BufferedWriter out1 = new BufferedWriter(fileWriter);
            out1.write("");
            out1.close();
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }

    public void getWorld(String str) throws IOException {
        adderMap();
        System.out.println(adderMap().get(str));
    }
}

