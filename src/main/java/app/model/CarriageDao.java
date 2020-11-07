package app.model;

import app.model.entities.Carriage;

import java.util.List;

public interface CarriageDao {
    List<Carriage> findAllCarriage();
    void insertCarriage(Carriage carriage);
    void deleteCarriage(String carriageID);
    void updateCarriageNumber(String id, Integer number);
    void updateCarriageRouteToTrain(String id, Integer routeToTrain);
}
