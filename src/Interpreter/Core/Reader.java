package Interpreter.Core;

import java.io.*;

public class Reader {

    /**
     * reads the file text and call the related classes
     *
     * @param path the direction of the file
     * @throws Exception in case of problems which caused by for statement
     */
    public void Read(String path) throws Exception {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            Int intData = new Int();
            Float floatData = new Float();
            Calculations calculate;

            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                line = line.trim();
                if (line.matches(Patterns.intRegex)) {
                    intData.put("key", 0);
                } else if (line.matches(Patterns.floatRegex)) {
                    floatData.put("key", 0.0);
                } else if (line.matches(Patterns.sumRegex)) {
                    calculate = new Sum();
                    calculate.doSomething();
                } else if (line.matches(Patterns.subRegex)) {
                    calculate = new Submission();
                    calculate.doSomething();
                } else if (line.matches(Patterns.mulRegex)) {
                    calculate = new Multiplication();
                    calculate.doSomething();
                } else if (line.matches(Patterns.divRegex)) {
                    calculate = new Division();
                    calculate.doSomething();
                } else if (line.matches(Patterns.printRegex)) {
                    Print printer = new Print();
                    printer.print();
                } else if (line.matches(Patterns.forStartingRegex)) {
                    For loop = new For();
                    while (!line.matches(Patterns.forEndingRegex)) {
                        line = reader.readLine();
                        if (line == null)
                            throw new Exception("for statement was invalid");
                        line = line.trim();
                        //TODO save this lines in loop object
                        //TODO change the kind of Exception above
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
