package ru.gb.jdk.seminar01.tasks05_serverChat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LogArchive {
    private static String filepath = "./log.txt";
    public static void create() {
        try {
            Files.createFile(Paths.get(filepath));
        } catch (IOException e) {
            System.out.println("Unable to create new file.");
        }
    }

    public static void save(String input) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            writer.append(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read() {
        List<String> tempList;
        String result = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            tempList = reader.lines().toList();
            for (String line : tempList) {
                result += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static boolean isExist() {
        Path checkFile = Paths.get(filepath);
        if (!Files.exists(checkFile)) return false;
        return true;
    }

    public static boolean isBlank() {
        Path checkFile = Paths.get(filepath);
        boolean result = false;
        try {
            if (Files.size(checkFile) == 0) {
                result = true;
            }
        } catch (IOException e) {
            System.out.println("Unable to access the file. ");
        }
        return result;
    }
}
