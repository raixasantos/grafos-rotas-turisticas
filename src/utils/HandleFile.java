package src.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import src.pcvq.Attraction;
import src.pcvq.Graph;

public class HandleFile {
    /**
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public static Graph readAttractionsFile(String path) throws FileNotFoundException {
        Graph graph = new Graph();

        Scanner inputFile = new Scanner(System.in);
        File file = new File(path);
        inputFile = new Scanner(file);

        if(file.length() == 0) {
            HandleInput.printAndExit("File empty!");
        }

        String currentLine = inputFile.nextLine();
        Integer numAttractions = Integer.parseInt(currentLine);
        graph = new Graph(numAttractions);

        while(inputFile.hasNextLine()) {
            Attraction attraction = new Attraction();
            currentLine = inputFile.nextLine();
            String[] attractionAtributes = currentLine.split(",");
            if(attractionAtributes.length == 3) {
                Integer id = Integer.parseInt(attractionAtributes[0]);
                attraction.setId(id);
                Integer scoreSatisfaction = Integer.parseInt(attractionAtributes[1]);
                attraction.setPointSatisfaction(scoreSatisfaction);
                attraction.setName(attractionAtributes[2]);
            } else {
                HandleInput.printAndExit("Necessary more arguments!");
            }
        }	
        
        return graph;
    }

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