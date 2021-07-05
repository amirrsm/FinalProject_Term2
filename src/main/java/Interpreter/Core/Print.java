package Interpreter.Core;

public class Print {
    public int print(String line, Int intData, Float floatData) {
        line = line.trim();
        String output = line.substring(6).trim();
        if (output.matches("[\\d]") || output.matches("[\\f]")) {
            System.out.println(output);
            return output.length();
        } else {
            if (intData.containsKey(output)) {
                Reader.stream.append(intData.get(output));
                Reader.stream.append("\n");
                return intData.get(output).toString().length();
            } else if (floatData.containsKey(output)) {
                Reader.stream.append(floatData.get(output));
                Reader.stream.append("\n");
                return floatData.get(output).toString().length();
            } else {
                Reader.stream.append("not found!\n");
                return 10;
            }
        }
    }
}
