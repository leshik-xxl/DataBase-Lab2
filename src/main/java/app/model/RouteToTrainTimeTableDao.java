package app.model;

import app.model.entities.Route;
import app.model.entities.RouteToTrainTimeTable;

import java.util.Date;
import java.util.List;

public interface RouteToTrainTimeTableDao {
    List<RouteToTrainTimeTable> findAllRouteToTrainTimeTable();
    void insertRouteToTrainTimeTable(RouteToTrainTimeTable routeToTrainTimeTable);
    void deleteRouteToTrainTimeTable(Integer id);
    void updateRouteToTrainTimeTableOfDeparture(Integer id, Date departure);
    void updateRouteToTrainTimeTableOfArrival(Integer id, Date arrival);
}
