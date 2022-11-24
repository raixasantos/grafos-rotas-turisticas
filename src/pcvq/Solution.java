package src.pcvq;

import java.io.IOException;

import src.utils.HandleFile;
import src.utils.HandleInput;

public class Solution {
    public static void main(String[] args) throws IOException {
        String pathAttractions = HandleInput.handleAttractionsInput(args, "Arguments: path to attractions's file required!");
        Graph graphReceived = HandleFile.readAttractionsFile(pathAttractions);

        String pathDistances = HandleInput.readCommandLine("Enter the path to file with distances between attractions: ");
        HandleFile.readDistancesFile(graphReceived, pathDistances);
        System.out.println(graphReceived.toString()); // TODO: show graph received with a better view

        Route route = new Route(); // TODO: add scoreSatisfaction in constructor
        long start = System.currentTimeMillis();
        Pcvq.findRoute(graphReceived, route);
        long elapsed = System.currentTimeMillis() - start;

        HandleFile.generateRouteFile(route, elapsed);
    }
}
