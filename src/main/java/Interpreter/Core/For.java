package Interpreter.Core;

import java.io.BufferedReader;
import java.io.StringReader;

public class For {
    private final String mainLine;

    public For(String mainLine) {
        this.mainLine = mainLine.trim();
    }

    public void forOperator(String data) {
        String repeat = mainLine.substring(4).trim();
        int number = 0;
        try {
            number = Integer.parseInt(repeat);
        } catch (Exception e) {
            Reader.stream.append("couldn't parse number of loops");
        }
        for (int i = 0; i < number; i++) {
            try {
                BufferedReader readFor = new BufferedReader(new StringReader(data));
                Reader.readStatement(readFor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
