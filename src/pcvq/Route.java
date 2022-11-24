package src.pcvq;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Attraction> route = new ArrayList<Attraction>();
    private Integer scoreSatisfaction;
    private Integer distance = 0;

    public Route() {
    }

    public Route(Integer scoreSatisfaction) {
        this.scoreSatisfaction = scoreSatisfaction;
    }

    public List<Attraction> getRoute() {
        return this.route;
    }

    public void setRoute(List<Attraction> route) {
        this.route = route;
    }

    public Integer getScoreSatisfaction() {
        return this.scoreSatisfaction;
    }

    public void setScoreSatisfaction(Integer scoreSatisfaction) {
        this.scoreSatisfaction = scoreSatisfaction;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Rota com" +
            " route='" + getRoute().toString() + "'" +
            ", scoreSatisfaction='" + getScoreSatisfaction() + "'" +
            ", distance='" + getDistance() + "'";
    }

}
