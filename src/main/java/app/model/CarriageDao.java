package app.model;

import app.model.entities.Carriage;
import app.model.entities.Train;

import java.util.List;

public interface CarriageDao {

    List<Carriage> findAllCarriage();
    List<Train> getTrainName(String id);

}
