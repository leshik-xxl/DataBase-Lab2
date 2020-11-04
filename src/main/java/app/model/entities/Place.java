package app.model.entities;

import java.util.List;

public class Place {
    private Integer id;
    private Integer number;
    private Carriage carriage;

    public Place(Integer id, Integer number, Carriage carriage) {
        this.id = id;
        this.number = number;
        this.carriage = carriage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", number=" + number +
                ", carriage=" + carriage.getId() +
                "}\n";
    }
}
