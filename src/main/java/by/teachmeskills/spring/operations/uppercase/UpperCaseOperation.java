package by.teachmeskills.spring.operations.uppercase;

import by.teachmeskills.spring.AbstractOperation;
import by.teachmeskills.spring.TextReader;

import by.teachmeskills.spring.operations.IOperations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UpperCaseOperation implements IOperations {

    private TextReader textReader;

    @Autowired
    public void setTextReader(TextReader textReader) {
        this.textReader = textReader;
    }

    @Override
    public List<String> textOperation() {
        List<String> result = new ArrayList<>();
        for(String str : textReader.readText() ){
            String line = str.toUpperCase();
            System.out.println((line));
            result.add(line);

        }
        return result;


    }
}
