package Interpreter.Core;

public class Sum extends Calculations {

    @Override
    public double statement(String line, Int intData, Float floatData) {
        char[] lineArray = line.toCharArray();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        String[] keys = new String[3];
        int i = 0;
        while (index < lineArray.length - 1) {
            if(index == 0){
               while (lineArray[index] != 32){
                   builder.append(lineArray[index++]);
               }
               keys[i++] = builder.toString();
               builder.delete(0, builder.length());
            }
            else if (lineArray[index] == 32 && (lineArray[index + 1] != 32 && lineArray[index + 1] != 43 && lineArray[index + 1] != 61)) {
                index++;
                while (lineArray[index] != 32) {
                    builder.append(lineArray[index]);
                    index++;
                    if(index == lineArray.length)
                        break;
                }
                keys[i++] = builder.toString();
                System.out.println(builder);
                builder.delete(0, builder.length());
            } else
                index++;
        }
        System.out.println(keys[0] + " " + keys[1] + " " + keys[2]);
        if(intData.containsKey(keys[0])) {
            intData.put(keys[0], intData.get(keys[1]) + intData.get(keys[2]));
            return intData.get(keys[0]);
        }
        else if(floatData.containsKey(keys[0])) {
            floatData.put(keys[0], floatData.get(keys[1]) + floatData.get(keys[2]));
            return floatData.get(keys[0]);
        }
        return 0;
    }
}
