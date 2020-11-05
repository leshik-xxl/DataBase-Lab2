package app.model;

import app.model.entities.Route;

import java.util.List;

public interface RouteDao {
    List<Route> findAllRoute();
    Route getRouteById(Integer id);
}
