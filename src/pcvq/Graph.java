package src.pcvq;

import java.util.ArrayList;

public class Graph {
    private Integer numAttractions;
    private ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    private Integer[][] distances;

    public Graph() {
    }

    public Graph(Integer numAttractions) {
        this.numAttractions = numAttractions;
        initializeDistances();
    }

    private void initializeDistances() {
        distances = new Integer[numAttractions][numAttractions];
        for (int row = 0; row < numAttractions; row++) {
			for (int column = 0; column < numAttractions; column++) {
				distances[row][column] = -1;
			}
		}
    }

    public Integer getNumAttractions() {
        return this.numAttractions;
    }

    public void setNumAttractions(Integer numAttractions) {
        this.numAttractions = numAttractions;
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public Integer[][] getDistances() {
        return this.distances;
    }

    public void addDistance(Integer row, Integer column, Integer distance) {
        this.distances[row][column] = distance;
    }

    private String distancesToString(Integer[][] distances) {
        String toString = "";
        for (int row = 0; row < distances.length; row++) {
            toString += "[";
			for (int column = 0; column < distances.length; column++) {
				toString += distances[row][column] + " ";
			}
            toString += "] ";
		}
        return toString;
    }

    @Override
    public String toString() {
        return "Grafo com" +
            " numAttractions='" + getNumAttractions() + "'" +
            ", attractions='" + getAttractions().toString() + "'" +
            ", distances='" + distancesToString(distances) + "'";
    }

}
