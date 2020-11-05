package app.model.entities;

import java.util.List;

public class Carriage {
    private String type;
    private Integer number;
    private String id;
    private Train train;

    public Carriage(String type, Integer number, String id, Train train) {
        this.type = type;
        this.number = number;
        this.id = id;
        this.train = train;
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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", id='" + id + '\'' +
                ", train=" + train.getId_train() +
                "}\n";
    }
}
