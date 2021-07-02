package Interpreter.Graphics;

public class CorrectAnswers {

    private final static String answer1 = "1\n";
    private final static String answer2 = "4\n9\n13\n";
    private final static String answer3 = "4\n";
    private final static String answer4 = "4\n";
    private final static String answer5 = "31\n";
    private final static String answer6 = "0\n1\n1\n2\n";
    private final static String answer7 = "5040\n";
    private final static String answer8 = "200\n";
    private final static String answer9 = "5040\n";

    public static String getAnswer(int count) {
        switch (count) {
            case 1:
                return answer1;
            case 2:
                return answer2;
            case 3:
                return answer3;
            case 4:
                return answer4;
            case 5:
                return answer5;
            case 6:
                return answer6;
            case 7:
                return answer7;
            case 8:
                return answer8;
            case 9:
                return answer9;
        }
        return answer1;
    }
}
