package app.model;

import app.model.entities.RouteToTrain;

import java.util.List;

public interface RouteToTrainDao {
    List<RouteToTrain> findAllRouteToTrain();

}
