package app.model;

import app.model.entities.Route;
import app.model.entities.RouteToTrainTimeTable;

import java.util.List;

public interface RouteToTrainTimeTableDao {
    List<RouteToTrainTimeTable> findAllRouteToTrainTimeTable();
    void insertRouteToTrainTimeTable(RouteToTrainTimeTable routeToTrainTimeTable);
}
