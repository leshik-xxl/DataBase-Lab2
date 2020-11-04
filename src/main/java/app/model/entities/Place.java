package app.model.entities;

import java.util.List;

public class Place {
    private Integer id;
    private Integer number;
    private List<Carriage> carriageList;

    public Place(Integer id, Integer number, List<Carriage> carriageList) {
        this.id = id;
        this.number = number;
        this.carriageList = carriageList;
    }

    public Integer getId() {
        return id;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Carriage> getCarriageList() {
        return carriageList;
    }

    public void setCarriageList(List<Carriage> carriageList) {
        this.carriageList = carriageList;
    }
}
