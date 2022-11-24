package src.utils;

import java.util.Objects;
import java.util.Scanner;

public class HandleInput {
    private static Scanner readLine = new Scanner(System.in);
    /** 
     * Handle command line to get the path to some file.
     * @param args The arguments of the program.
     * @param message The message to display in required field.
     * @return String Path received.
     */
    public static String handleAttractionsInput(String[] args, String message) {
        String path = "";
        if (args.length == 0) {
            printAndExit(message);
        }

        for (int i = 0; i < args.length; i++) {
            if (i == 1) {
                printAndExit("Too many arguments!");
            }

            try {
                if (Objects.equals(args[i], null)) {
                    printAndExit("Plese, enter a valid path!");
                }
                path = args[i];
            }
            catch (Exception e) {
                printAndExit("Invalid arguments!");
            }
        }

        return path;
    }

    private static void verifyPath(String path) {
        if (Objects.equals(path, null)) {
            printAndExit("Plese, enter a valid path!");
        }
    }

    public static String readCommandLine(String message) {
        String path = "";
        System.out.println(message);
        path = readLine.nextLine();
        readLine.close();
        verifyPath(path);
        return path;
    }
    
    /** 
     * Print error message and exit program.
     * @param message Message to print.
     */
    public static void printAndExit(String message) {
        System.out.println(message);
        System.exit(-1);
    }
}