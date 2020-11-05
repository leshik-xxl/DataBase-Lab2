package app.model.entities;

import javax.xml.crypto.Data;
import java.util.Date;

public class RouteToTrain {
    private Integer id;
    private Route route;
    private Train train;
    private Date arriveTime;
    private Date departTime;

    public RouteToTrain(Integer id, Route route, Train train, Date arriveTime, Date departTime) {
        this.id = id;
        this.route = route;
        this.train = train;
        this.arriveTime = arriveTime;
        this.departTime = departTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
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
        return "RouteToTrain{" +
                "id=" + id +
                ", train=" + train.getId_train() +
                ", place_of_departure=" + route.getPlace_of_departure() +
                ", place_of_arrival=" + route.getPlace_of_arrival() +
                ", arriveTime=" + arriveTime +
                ", departTime=" + departTime +
                "}\n";
    }
}
