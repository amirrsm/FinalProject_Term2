package Interpreter.Core;

import java.io.StringWriter;

public class For {
    private final String mainLine;

    public For(String mainLine) {
        this.mainLine = mainLine.trim();
    }

    public void forOperator(StringWriter writer) {
        String repeat = mainLine.substring(4).trim();
        int number = 0;
        try {
            number = Integer.parseInt(repeat);
        } catch (Exception e) {
            System.out.println("couldn't parse");
        }
        String data = writer.toString();
        for (int i = 0; i < number; i++) {
            try {
                Reader.read(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
