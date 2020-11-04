package app.model.entities;

import java.util.List;

public class Carriage {
    private String type;
    private Integer number;
    private String id;
    private List<Train> routeToTrainList;

    public Carriage(String type, Integer number, String id, List<Train> routeToTrainList) {
        this.type = type;
        this.number = number;
        this.id = id;
        this.routeToTrainList = routeToTrainList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Train> getRouteToTrainList() {
        return routeToTrainList;
    }

    public void setRouteToTrainList(List<Train> routeToTrainList) {
        this.routeToTrainList = routeToTrainList;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", id='" + id + '\'' +
                ", routeToTrainList=" + routeToTrainList +
                "}\n";
    }
}
