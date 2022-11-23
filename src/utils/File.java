package src.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {


    /** 
     * Generate a file with the result of the algorithm execution.
     * @param path Where is the file to be written.
     * @param route The route to be written on the file.
     * @throws IOException
     */
    public static void generateRouteFile(String path, String route) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter buffWrite = new BufferedWriter(fileWriter);
        buffWrite.write(route + "\n");
        buffWrite.close();
    }
    
}
