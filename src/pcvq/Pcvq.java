package src.pcvq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pcvq {
    public static void findRoute(Graph graphReceived, Route route) {
        Route routeAttempted = new Route();
        Integer scoreSatisfaction = route.getScoreSatisfaction();
        List<Integer> visited = new ArrayList<Integer>(Collections.nCopies(graphReceived.getNumAttractions(), 0));

        addHotel(graphReceived, routeAttempted);
        backtracking(graphReceived, routeAttempted, 0, 1, visited, scoreSatisfaction);
        addHotel(graphReceived, routeAttempted);

        route.setRoute(routeAttempted.getRoute());
        route.setScoreSatisfaction(routeAttempted.getScoreSatisfaction());
        route.setDistance(routeAttempted.getDistance());
    }

    public static void backtracking(Graph graphReceived, Route routeAttempted, Integer currAttraction, Integer adj, List<Integer> visited, Integer scoreSatisfaction) {
        Integer indexStartAttraction = graphReceived.getAttractions().get(currAttraction).getId()-1;
        visited.set(indexStartAttraction, currAttraction);
        Boolean allAttractionsVisited = visited.stream().allMatch(value -> value == 1);
        List<Integer> currentAttractionsAdj = graphReceived.getAdjacents(currAttraction);

        if(allAttractionsVisited || routeAttempted.getScoreSatisfaction() > scoreSatisfaction) {
            return;
        } 
        for (int i = 0; i < currentAttractionsAdj.size(); i++) {
            if (visited.get(currentAttractionsAdj.get(i)) == 0) {
                Attraction attractionAux = graphReceived.getAttractionByIndex(currentAttractionsAdj.get(i));
                visited.set(currentAttractionsAdj.get(i), 1);
                routeAttempted.addAttraction(attractionAux);
                Integer distance = routeAttempted.getDistance() + graphReceived.getDistance(currAttraction, currentAttractionsAdj.get(i));
                routeAttempted.setDistance(distance);
                Integer currScoreSatisfaction = routeAttempted.getScoreSatisfaction() + attractionAux.getPointSatisfaction();
                routeAttempted.setScoreSatisfaction(currScoreSatisfaction);
                backtracking(graphReceived, routeAttempted, currAttraction, currentAttractionsAdj.get(i), visited, scoreSatisfaction);
            }
        }
    }

    

    /** 
     * Add hotel -start and final place - into the route.
     * @param graphReceived Graph received with all attractions.
     * @param graphAttempted Graph with attractions to build the final route.
     */
    private static void addHotel(Graph graphReceived, Route routeAttempted) {
        routeAttempted.addAttraction(graphReceived.getAttractions().get(0));
    }
}
