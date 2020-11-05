package app.model;

import app.model.entities.Carriage;
import app.model.entities.Train;

import java.util.List;

public interface CarriageDao {
    List<Carriage> findAllCarriage();
    //void insertCarriage(Carriage carriage);
}
