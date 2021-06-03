package Interpreter.Core;

public class Patterns {
    public final static String intRegex = "int[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[=][\\s]+[-]?[0-9][0-9]{0,7}";
    public final static String floatRegex = "float[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[=][\\s]+[-]?[0-9]+.[0-9]{1,10}";
    public final static String sumRegex = "[a-zA-Z][a-zA-Z_0-9]*[\\s]+=[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[+][\\s]+[a-zA-Z][a-zA-Z_0-9]*";
    public final static String subRegex = "[a-zA-Z][a-zA-Z_0-9]*[\\s]+=[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[-][\\s]+[a-zA-Z][a-zA-Z_0-9]*";
    public final static String mulRegex = "[a-zA-Z][a-zA-Z_0-9]*[\\s]+=[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[*][\\s]+[a-zA-Z][a-zA-Z_0-9]*";
    public final static String divRegex = "[a-zA-Z][a-zA-Z_0-9]*[\\s]+=[\\s]+[a-zA-Z_][a-zA-Z_0-9]*[\\s]+[/][\\s]+[a-zA-Z][a-zA-Z_0-9]*";
    public final static String printRegex = "print[\\s]+[a-zA-Z_][a-zA-Z_0-9]*";
    public final static String forStartingRegex = "for[\\s]+[\\d]";
    public final static String forEndingRegex = "end[\\s]+for";
}
