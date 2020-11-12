package app.model.dto;

import java.sql.Timestamp;

public class RouteFromToDepartMore {
    private String place_of_departure;
    private String place_of_arrive;
    private Timestamp arrive_time;
    private Timestamp depart_time;

    public RouteFromToDepartMore(String place_of_departure
            , String place_of_arrive, Timestamp arrive_time, Timestamp depart_time) {
        this.place_of_departure = place_of_departure;
        this.place_of_arrive = place_of_arrive;
        this.arrive_time = arrive_time;
        this.depart_time = depart_time;
    }

    public String getPlace_of_departure() {
        return place_of_departure;
    }

    public void setPlace_of_departure(String place_of_departure) {
        this.place_of_departure = place_of_departure;
    }

    public String getPlace_of_arrive() {
        return place_of_arrive;
    }

    public void setPlace_of_arrive(String place_of_arrive) {
        this.place_of_arrive = place_of_arrive;
    }

    public Timestamp getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(Timestamp arrive_time) {
        this.arrive_time = arrive_time;
    }

    public Timestamp getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(Timestamp depart_time) {
        this.depart_time = depart_time;
    }

    @Override
    public String toString() {
        return "RouteFromToDepartMore{" +
                "place_of_departure='" + place_of_departure + '\'' +
                ", place_of_arrive='" + place_of_arrive + '\'' +
                ", arrive_time=" + arrive_time +
                ", depart_time=" + depart_time +
                "}\n";
    }
}
