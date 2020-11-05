package app.model.entities;

import java.util.List;

public class Place {
    private Integer id;
    private Integer number;
    private String carriage;

    public Place(Integer id, Integer number, String carriage) {
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

    public String getCarriage() {
        return carriage;
    }

    public void setCarriage(String carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", number=" + number +
                ", carriage='" + carriage + '\'' +
                "}\n";
    }
}
