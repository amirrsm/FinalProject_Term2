package Interpreter.Core;

public class Sum extends Calculations {

    @Override
    public double statement(String line, Int intData, Float floatData) {
        char[] lineArray = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        String[] keys = new String[3];
        String[] results = new String[3];
        int i = 0;
        while (index < lineArray.length - 1) {
            if (index == 0) {
                while (lineArray[index] != 32) {
                    builder.append(lineArray[index++]);
                }
                keys[i++] = builder.toString();
                builder.delete(0, builder.length());
            } else if (lineArray[index] == 32 && (lineArray[index + 1] != 32 && lineArray[index + 1] != 43 && lineArray[index + 1] != 61)) {
                index++;
                while (lineArray[index] != 32) {
                    builder.append(lineArray[index]);
                    index++;
                    if (index == lineArray.length)
                        break;
                }
                keys[i++] = builder.toString();
                if (keys[i - 1].matches(Patterns.number))
                    results[i - 1] = keys[i - 1];
                else if(intData.containsKey(keys[i - 1]))
                    results[i - 1] = String.valueOf(intData.get(keys[i - 1]));
                else if(floatData.containsKey(keys[i - 1]))
                    results[i - 1] = String.valueOf(floatData.get(keys[i - 1]));
                builder.delete(0, builder.length());
            } else
                index++;
        }
        if (intData.containsKey(keys[0])) {
            intData.put(keys[0], Integer.parseInt(results[1]) + Integer.parseInt(results[2]));
            return intData.get(keys[0]);
        } else if (floatData.containsKey(keys[0])) {
            floatData.put(keys[0],(double) java.lang.Float.parseFloat(results[1]) + java.lang.Float.parseFloat(results[2]));
            return floatData.get(keys[0]);
        }
        return 0;
    }
}
