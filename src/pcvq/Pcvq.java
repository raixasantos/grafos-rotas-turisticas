package src.pcvq;

public class Pcvq {
    public static void findRoute(Graph graphReceived, Route route) {
        Graph graphAttempted = new Graph(1);
        addHotel(graphReceived, graphAttempted);
        Integer scoreSatisfaction = 0;
        Integer distance = 0;
        // heuristic
        addHotel(graphReceived, graphAttempted);

        route.setRoute(graphAttempted.getAttractions());
        route.setScoreSatisfaction(scoreSatisfaction);
        route.setDistance(distance);
    }

    

    /** 
     * Add hotel into the route.
     * @param graphReceived Graph received with all attractions.
     * @param graphAttempted Graph with attractions to build the final route.
     */
    private static void addHotel(Graph graphReceived, Graph graphAttempted) {
        graphAttempted.addAttraction(graphReceived.getAttractions().get(0));
    }
}
