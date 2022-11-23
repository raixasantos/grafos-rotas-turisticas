package src.utils;

import java.util.Objects;

public class HandleInput {
    // printAndExit("Arguments: path to attractions's file required!");
    // printAndExit("Arguments: path to score of satisfaction and distances between attractions required!");

    /** 
     * Handle command line to get the path to some file.
     * @param args The arguments of the program.
     * @param message The message to display in required field.
     * @return String Path received.
     */
    public static String handleArgsAttractions(String[] args, String message) {
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
    
    /** 
     * Print error message and exit program.
     * @param message Message to print.
     */
    private static void printAndExit(String message) {
        System.out.println(message);
        System.exit(-1);
    }
}