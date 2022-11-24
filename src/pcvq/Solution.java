package src.pcvq;

import java.io.IOException;

import src.utils.HandleFile;
import src.utils.HandleInput;

public class Solution {
    public static void main(String[] args) throws IOException {
        // tratar os args 
        String pathAttractions = HandleInput.handleAttractionsInput(args, "Arguments: path to attractions's file required!");
        Graph graphReceived = HandleFile.readAttractionsFile(pathAttractions);

        String pathDistances = HandleInput.readCommandLine("Enter the path to file with distances between attractions: ");
        HandleFile.readDistancesFile(graphReceived, pathDistances);
        System.out.println(graphReceived.toString()); // show graph received

        // chamar método da heurística e do cálculo de tempo
        long start = System.currentTimeMillis();

        long elapsed = System.currentTimeMillis() - start;

        // exibir resultado e gerar arquivo
        // HandleFile.generateRouteFile(pathDistances, elapsed);
    }
}
