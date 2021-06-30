package Interpreter.Core;

import java.io.*;

public class Reader {

    static Int intData = new Int();
    static Float floatData = new Float();
    public static StringBuilder stream = new StringBuilder();

    /**
     * reads the file text and call the related classes
     *
     * @param Data the direction of the file
     * @throws Exception in case of problems which caused by for statement
     */
    public static StringBuilder read(String Data) throws Exception {
        try {
            BufferedReader reader;
            reader = new BufferedReader(new StringReader(Data));

            Calculations calculate;
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                line = line.trim();
                if (line.matches(Patterns.intRegex1) || line.matches(Patterns.intRegex2)) {
                    intData.setParams(line);
                } else if (line.matches(Patterns.floatRegex1) || line.matches(Patterns.floatRegex2)) {
                    floatData.setParams(line);
                } else if (line.matches(Patterns.sumRegex1) || line.matches(Patterns.sumRegex2) || line.matches(Patterns.sumRegex3) || line.matches(Patterns.sumRegex4)) {
                    calculate = new Sum();
                    try {
                        calculate.statement(line, intData, floatData);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (line.matches(Patterns.subRegex1) || line.matches(Patterns.subRegex2) || line.matches(Patterns.subRegex3) || line.matches(Patterns.subRegex4)) {
                    calculate = new Submission();
                    try {
                        calculate.statement(line, intData, floatData);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (line.matches(Patterns.mulRegex1) || line.matches(Patterns.mulRegex2) || line.matches(Patterns.mulRegex3) || line.matches(Patterns.mulRegex4)) {
                    calculate = new Multiplication();
                    try {
                        calculate.statement(line, intData, floatData);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (line.matches(Patterns.divRegex1) || line.matches(Patterns.divRegex2) || line.matches(Patterns.divRegex3) || line.matches(Patterns.divRegex4)) {
                    calculate = new Division();
                    try {
                        calculate.statement(line, intData, floatData);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (line.matches(Patterns.printRegex)) {
                    Print printer = new Print();
                    int result = printer.print(line, intData, floatData);
                } else if (line.matches(Patterns.forStartingRegex)) {
                    For loop = new For(line);
                    int countInnerFor = 1;
                    StringBuilder builder = new StringBuilder();
                    while (!line.matches(Patterns.forEndingRegex) || countInnerFor != 0) {
                        line = reader.readLine();
                        if (line == null)
                            throw new InvalidForException("for statement was invalid");
                        if (line.matches(Patterns.forStartingRegex)) {
                            countInnerFor++;
                        }
                        if (line.matches(Patterns.forEndingRegex))
                            countInnerFor--;
                        if (line.matches(Patterns.forEndingRegex) && countInnerFor == 0)
                            break;
                        line = line.trim();
                        builder.append(line).append("\n");
                    }
                    loop.forOperator(builder.toString());
                }
            }
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class InvalidForException extends Exception {

        public InvalidForException(String string) {
            super(string);
        }
    }
}
