package Interpreter.Core;

import Interpreter.Graphics.Controller.CompilePageController;

public class Print {
    public int print(String line, Int intData, Float floatData) {
        line = line.trim();
        String output = line.substring(6).trim();
        if (output.matches("[\\d]") || output.matches("[\\f]")) {
            System.out.println(output);
            return output.length();
        } else {
            if (intData.containsKey(output)) {
                System.out.println(intData.get(output));
                return intData.get(output).toString().length();
            } else if (floatData.containsKey(output)) {
                System.out.println(floatData.get(output));
                return floatData.get(output).toString().length();
            } else {
                System.out.println("not found!");
                return 10;
            }
        }
    }
}
