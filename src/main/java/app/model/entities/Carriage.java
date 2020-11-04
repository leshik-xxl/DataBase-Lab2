package app.model.entities;

import java.util.List;

public class Carriage {
    private Integer id;
    private String type;
    private Integer number;
    private List<Train> routeToTrainList;

    public Carriage(Integer id, String type, Integer number, List<Train> routeToTrainList) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.routeToTrainList = routeToTrainList;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Train> getRouteToTrainList() {
        return routeToTrainList;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setRouteToTrainList(List<Train> routeToTrainList) {
        this.routeToTrainList = routeToTrainList;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", routeToTrainList=" + routeToTrainList +
                '}';
    }
}
