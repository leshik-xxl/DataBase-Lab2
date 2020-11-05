package app.model.entities;

import java.util.Date;

public class RouteToTrainTimeTable {
    private Integer id;
    private Integer route;
    private String train;
    private Date arriveTime;
    private Date departTime;

    public RouteToTrainTimeTable(Integer id, Integer route, String train, Date arriveTime, Date departTime) {
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

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
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
        return "RouteToTrainTimeTable{" +
                "id=" + id +
                ", route=" + route +
                ", train='" + train + '\'' +
                ", arriveTime=" + arriveTime +
                ", departTime=" + departTime +
                "}\n";
    }
}
