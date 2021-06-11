package Interpreter.Core;

import javax.crypto.spec.PSource;
import java.io.*;

public class Reader {


    static Int intData = new Int();
    static Float floatData = new Float();

    /**
     * reads the file text and call the related classes
     *
     * @param Data the direction of the file
     * @throws Exception in case of problems which caused by for statement
     */
    public static void read(String Data) throws Exception {
        try {
            BufferedReader reader;
            reader = new BufferedReader(new StringReader(Data));

            Calculations calculate;
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                line = line.trim();
                if (line.contains("int")) {
                    intData.setParams(line);
                } else if (line.matches(Patterns.floatRegex)) {
                    floatData.setParams(line);
                } else if (line.matches(Patterns.sumRegex)) {
                    calculate = new Sum();
                    calculate.statement(line, intData, floatData);
                } else if (line.matches(Patterns.subRegex)) {
                    calculate = new Submission();
                    calculate.statement(line, intData, floatData);
                } else if (line.matches(Patterns.mulRegex)) {
                    calculate = new Multiplication();
                    calculate.statement(line, intData, floatData);
                } else if (line.matches(Patterns.divRegex)) {
                    calculate = new Division();
                    calculate.statement(line, intData, floatData);
                } else if (line.matches(Patterns.printRegex)) {
                    Print printer = new Print();
                    int result = printer.print(line, intData, floatData);
                } else if (line.matches(Patterns.forStartingRegex)) {
                    For loop = new For(line);
                    StringBuilder builder = new StringBuilder();
                    while (!line.matches(Patterns.forEndingRegex)) {
                        line = reader.readLine();
                        if (line == null)
                            throw new InvalidForException("for statement was invalid");
                        if (line.contains("end"))
                            break;
                        line = line.trim();
                        builder.append(line).append("\n");
                    }

                    loop.forOperator(builder.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class InvalidForException extends Exception {

        public InvalidForException(String string) {
            super(string);
        }
    }
}
