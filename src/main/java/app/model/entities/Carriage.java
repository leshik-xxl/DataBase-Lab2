package app.model.entities;

import java.util.List;

public class Carriage {
    private String type;
    private Integer number;
    private String id;
    private Integer routeToTrainTimeTable;

    public Carriage(String type, Integer number, String id, Integer routeToTrainTimeTable) {
        this.type = type;
        this.number = number;
        this.id = id;
        this.routeToTrainTimeTable = routeToTrainTimeTable;
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

    public Integer getRouteToTrainTimeTable() {
        return routeToTrainTimeTable;
    }

    public void setRouteToTrainTimeTable(Integer routeToTrainTimeTable) {
        this.routeToTrainTimeTable = routeToTrainTimeTable;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", id='" + id + '\'' +
                ", routeToTrainTimeTable=" + routeToTrainTimeTable +
                "}\n";
    }
}
