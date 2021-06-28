package Interpreter.Core;

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
            System.out.println("couldn't parse");
        }
        for (int i = 0; i < number; i++) {
            try {
                Reader.read(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
