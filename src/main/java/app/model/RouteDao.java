package app.model;

import app.model.entities.Route;

import java.util.List;

public interface RouteDao {
    List<Route> findAllRoute();
    void insertRoute(Route route);
    void deleteRoute(Integer id);
}
