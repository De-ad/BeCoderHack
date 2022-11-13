package util;

public class TextPrintManager {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void printGreenText(String message){
        System.out.println(ANSI_GREEN
                + message
                + ANSI_RESET);
    }

    public static void printRedText(String message){
        System.out.println(ANSI_RED
                + message
                + ANSI_RESET);
    }
}
