package by.teachmeskills.spring.operations.wordsnumberoperation;

import by.teachmeskills.spring.AbstractOperation;
import by.teachmeskills.spring.TextReader;
import by.teachmeskills.spring.operations.IOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WordsNumberOperation extends AbstractOperation {
    private TextReader textReader;

    @Autowired
    public void setTextReader(TextReader textReader) {
        this.textReader = textReader;
    }

    @Override
    public List<String> textOperation() {
        String[] word;
        int count = 0;
        for (String str : textReader.readText()) {
            word = str.split("\\s+");
            count += word.length;

        }
        System.out.println("Number of words is: " + count);
        return new ArrayList<>();
    }
}
