package src.pcvq;

public class Attraction {
    private Integer id;
    private String name;
    private Integer pointSatisfaction;

    public Attraction() {
    }

    public Attraction(Integer id, String name, Integer pointSatisfaction) {
        this.id = id;
        this.name = name;
        this.pointSatisfaction = pointSatisfaction;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPointSatisfaction() {
        return this.pointSatisfaction;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPointSatisfaction(Integer pointSatisfaction) {
        this.pointSatisfaction = pointSatisfaction;
    }

    @Override
    public String toString() {
        return "Atração com" +
            " id='" + getId() + "'" +
            " nome='" + getName() + "'" +
            " ponto de satisfação='" + getPointSatisfaction() + "'";
    }

}
