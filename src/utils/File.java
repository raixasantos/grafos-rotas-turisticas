package src.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import src.pcvq.Attraction;
import src.pcvq.Graph;

public class File {
    public static Graph readAttractionsFile(String path) {
        Graph graph = new Graph();
        String name = "";
        BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            System.out.print("primeira linha: " + line);
            int numAttractions = 0;
            if(!isNullOrEmpty(line)) {
                System.out.println(line.getClass().getSimpleName());
                numAttractions = Integer.parseInt(line);
                
            }	

            while((line = br.readLine()) != null) {
                Attraction attraction = new Attraction();
                System.out.println(line);
			}	
            graph = new Graph(numAttractions);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

        return graph;
    }

    private static Boolean isNullOrEmpty(String value) {
        if(value == null || value.isEmpty()) {
            return true;
        }
        return false;
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
