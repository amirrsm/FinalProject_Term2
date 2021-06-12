package Interpreter.Core;

public class Patterns {
    public final static String variable = "[a-zA-Z_][a-zA-Z_0-9]*";
    public final static String intNumber = "[-]?[0-9][0-9]{0,7}";
    public final static String floatNumber = "[-]?[0-9]+.[0-9]{1,10}";
    public final static String number = "[0-9][0-9]{0,7}[.]?[\\d]*";
    public final static String intRegex1 = "int[\\s]+" + variable + "[\\s]+[=][\\s]+" + intNumber;
    public final static String intRegex2 = "int[\\s]+" + variable;
    public final static String floatRegex1 = "float[\\s]+" + variable + "[\\s]+[=][\\s]+" + floatNumber;
    public final static String floatRegex2 = "float[\\s]+" + variable;
    public final static String sumRegex1 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[+][\\s]+" + variable;
    public final static String sumRegex2 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[+][\\s]+" + number;
    public final static String sumRegex3 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[+][\\s]+" + variable;
    public final static String sumRegex4 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[+][\\s]+" + number;
    public final static String subRegex1 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[-][\\s]+" + variable;
    public final static String subRegex2 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[-][\\s]+" + number;
    public final static String subRegex3 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[-][\\s]+" + variable;
    public final static String subRegex4 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[-][\\s]+" + number;
    public final static String mulRegex1 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[*][\\s]+" + variable;
    public final static String mulRegex2 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[*][\\s]+" + number;
    public final static String mulRegex3 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[*][\\s]+" + variable;
    public final static String mulRegex4 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[*][\\s]+" + number;
    public final static String divRegex1 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[/][\\s]+" + variable;
    public final static String divRegex2 = variable + "[\\s]+[=][\\s]+" + variable + "[\\s]+[/][\\s]+" + number;
    public final static String divRegex3 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[/][\\s]+" + variable;
    public final static String divRegex4 = variable + "[\\s]+[=][\\s]+" + number + "[\\s]+[/][\\s]+" + number;
    public final static String printRegex = "print[\\s]+[a-zA-Z_][a-zA-Z_0-9]*";
    public final static String forStartingRegex = "for[\\s]+[\\d]+";
    public final static String forEndingRegex = "end[\\s]+for";
}
