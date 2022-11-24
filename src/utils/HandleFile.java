package src.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import src.pcvq.Attraction;
import src.pcvq.Graph;
import src.pcvq.Route;

public class HandleFile {
    /**
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public static Graph readAttractionsFile(String path) throws FileNotFoundException {
        Scanner inputFile = readFile(path);
        Graph graph = new Graph();
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
                graph.addAttraction(attraction);
            } else {
                HandleInput.printAndExit("Necessary more arguments!");
            }
        }	        
        return graph;
    }

    public static void readDistancesFile(Graph graph, String path) throws FileNotFoundException {
        Scanner inputFile = readFile(path);
        String currentLine = "";
        
        Integer row = 0;
        while(inputFile.hasNextLine()) {
            currentLine = inputFile.nextLine();
            String[] distances = currentLine.split(" ");
            if(distances.length == graph.getNumAttractions()){
                for(int column = 0; column < distances.length; column++) {
                    Integer distance = Integer.parseInt(distances[column]);
                    graph.addDistance(row, column, distance);
                }
            } else {
                HandleInput.printAndExit("Necessary more arguments!");
            }
            row++;
        }	
        if(row < graph.getNumAttractions()) {
            HandleInput.printAndExit("Necessary more arguments!");
        }
    }

    private static void altReadDistancesFile(Graph graph, String path) throws FileNotFoundException {
        Scanner inputFile = readFile(path);
        String currentLine = "";        
        while(inputFile.hasNextLine()) {
            currentLine = inputFile.nextLine();
            String[] attractionsAndDistances = currentLine.split(" ");
            if(attractionsAndDistances.length == 3){
                Integer row = Integer.parseInt(attractionsAndDistances[0]);
                Integer column = Integer.parseInt(attractionsAndDistances[1]);
                Integer distance = Integer.parseInt(attractionsAndDistances[2]);
                graph.addDistance(row, column, distance);
            } else {
                HandleInput.printAndExit("Necessary more arguments!");
            }
        }
    }

    private static Scanner readFile(String path) throws FileNotFoundException {
        Scanner inputFile = new Scanner(System.in);
        File file = new File(path);
        isFileEmpty(file);
        inputFile = new Scanner(file);
        return inputFile;
    }

    private static void isFileEmpty(File file) {
        if(file.length() == 0) {
            HandleInput.printAndExit("File empty!");
        }
    }

    /** 
     * Generate a file with the result of the algorithm execution.
     * @param path Where is the file to be written.
     * @param route The route to be written on the file.
     * @throws IOException
     */
    public static void generateRouteFile(Route route, Long time) throws IOException {
        String path = generatePath();
        File file = new File(path);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter buffWrite = new BufferedWriter(fileWriter);
        buffWrite.write("Route builded in " + time + "seconds.\n");
        buffWrite.write("Route with " + route.getScoreSatisfaction() + " points of satisfaction.\n");
        buffWrite.write("Route with " + route.getDistance() + "m. \n");
        buffWrite.write("Route: \n");
        Integer order = 1;
        for(Attraction attraction: route.getRoute()) {
            buffWrite.write(order + "º: " + attraction.getName() + "\n");
            order++;
        }
        buffWrite.close();
        System.out.println("Route and others informations available on: " + path + ".");
    }

    private static String generatePath() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd'at'HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String path = "src/output/route-" + formatter.format(date) + ".txt";
        return path;
    }
    
}