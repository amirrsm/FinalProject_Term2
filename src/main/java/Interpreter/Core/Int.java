package Interpreter.Core;

import java.util.HashMap;

public class Int extends HashMap<String, Integer> {

    void setParams(String line) {
        String newLine;
        String key;
        int value;
        newLine = line.substring(3).trim();
        int equalIndex = newLine.indexOf('=');
        if (equalIndex == -1) {
            key = newLine.trim();
            value = 0;
        } else {
            key = newLine.substring(0, newLine.indexOf('=')).trim();
            value = Integer.parseInt(newLine.substring(newLine.indexOf('=') + 1).trim());
        }

        this.put(key, value);
    }

}
