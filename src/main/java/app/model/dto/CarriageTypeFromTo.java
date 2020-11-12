package app.model.dto;

import java.util.Date;

public class CarriageTypeFromTo {
    private String place_of_depart;
    private String place_of_arrival;
    private String type;
    private String carName;
    private Date arriveTime;
    private Date departTime;

    public CarriageTypeFromTo(String place_of_depart, String place_of_arrival,
                              String type, String carName, Date arriveTime, Date departTime) {
        this.place_of_depart = place_of_depart;
        this.place_of_arrival = place_of_arrival;
        this.type = type;
        this.carName = carName;
        this.arriveTime = arriveTime;
        this.departTime = departTime;
    }

    public String getPlace_of_depart() {
        return place_of_depart;
    }

    public void setPlace_of_depart(String place_of_depart) {
        this.place_of_depart = place_of_depart;
    }

    public String getPlace_of_arrival() {
        return place_of_arrival;
    }

    public void setPlace_of_arrival(String place_of_arrival) {
        this.place_of_arrival = place_of_arrival;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    @Override
    public String toString() {
        return "CarriageTypeFromTo{" +
                "place_of_depart='" + place_of_depart + '\'' +
                ", place_of_arrival='" + place_of_arrival + '\'' +
                ", type='" + type + '\'' +
                ", carName='" + carName + '\'' +
                ", arriveTime=" + arriveTime +
                ", departTime=" + departTime +
                "\n";
    }
}
