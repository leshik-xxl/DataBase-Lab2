package app.model.entities;

public class Route {
    private Integer id;
    private String place_of_departure;
    private String place_of_arrival;

    public Route(Integer id, String place_of_departure, String place_of_arrival) {
        this.id = id;
        this.place_of_departure = place_of_departure;
        this.place_of_arrival = place_of_arrival;
    }

    public Integer getId() {
        return id;
    }

    public String getPlace_of_departure() {
        return place_of_departure;
    }

    public void setPlace_of_departure(String place_of_departure) {
        this.place_of_departure = place_of_departure;
    }

    public String getPlace_of_arrival() {
        return place_of_arrival;
    }

    public void setPlace_of_arrival(String place_of_arrival) {
        this.place_of_arrival = place_of_arrival;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", place_of_departure='" + place_of_departure + '\'' +
                ", place_of_arrival='" + place_of_arrival + '\'' +
                '}';
    }
}
