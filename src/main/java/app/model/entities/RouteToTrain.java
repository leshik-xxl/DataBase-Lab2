package app.model.entities;

import javax.xml.crypto.Data;
import java.util.List;

public class RouteToTrain {
    private Integer id;
    private List<Route> routeList;
    private List<Train> trainList;
    private Data arriveTime;
    private Data DepartTime;

    public RouteToTrain(Integer id, List<Route> routeList, List<Train> trainList, Data arriveTime, Data departTime) {
        this.id = id;
        this.routeList = routeList;
        this.trainList = trainList;
        this.arriveTime = arriveTime;
        DepartTime = departTime;
    }

    public Integer getId() {
        return id;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public Data getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Data arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Data getDepartTime() {
        return DepartTime;
    }

    public void setDepartTime(Data departTime) {
        DepartTime = departTime;
    }

    @Override
    public String toString() {
        return "RouteToTrain{" +
                "id=" + id +
                ", routeList=" + routeList +
                ", trainList=" + trainList +
                ", arriveTime=" + arriveTime +
                ", DepartTime=" + DepartTime +
                '}';
    }
}
