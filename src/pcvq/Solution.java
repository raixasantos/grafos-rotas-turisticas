package src.pcvq;

import src.utils.HandleInput;

public class Solution {
    public static void main(String[] args) {
        // tratar os args
        // chamar método da heurística e do cálculo de tempo
        // exibir resultado e gerar arquivo


        // teste de classes:
        // HandleInput
        HandleInput.handleArgsAttractions(args, "Arguments: path to attractions's file required!");

        // Attraction
        System.out.println("---------------Attraction----------------");
        Attraction attraction1 = new Attraction(1, "Praia do Meio", 5);
        Attraction attraction2 = new Attraction(2, "Praia do Ponta Negra", 10);
        System.out.println(attraction1.toString());
        System.out.println(attraction2.toString());

        // Graph
        System.out.println("\n\n---------------Graph---------------");
        Graph graph = new Graph(2);
        graph.addAttraction(attraction1);
        graph.addAttraction(attraction2);
        graph.addDistance(attraction1.getId()-1, attraction2.getId()-1, 1);
        graph.addDistance(attraction2.getId()-1, attraction1.getId()-1, 2);
        System.out.println(graph.toString());

        // Route
        System.out.println("\n\n---------------------Route------------------------");
        Route route70 = new Route(70);
        route70.setRoute(graph.getAttractions());
        System.out.println(route70.toString());
    }
}
