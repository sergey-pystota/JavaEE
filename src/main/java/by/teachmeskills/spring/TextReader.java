package by.teachmeskills.spring;

import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
public class TextReader {

    public List<String> readText() {
        List<String> text = null;
        Path file = Paths.get("E:\\spring\\src\\main\\resources\\text.txt");
        try {
            text = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}

