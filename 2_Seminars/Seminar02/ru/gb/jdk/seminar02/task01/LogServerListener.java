package ru.gb.jdk.seminar02.task01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogServerListener implements ServerListener {
    private File logFile;

    public LogServerListener(String log) {
        logFile = new File(log);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Override
    public void generateMessage(String msg) {
        msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")) + ": " + msg;
//
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {

            List<String> lines = reader.lines().toList();
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
            for (String line : lines) {
                    writer.append(line);
                    writer.newLine();
            }
            writer.append(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
