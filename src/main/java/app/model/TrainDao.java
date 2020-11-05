package app.model;

import app.model.entities.Route;
import app.model.entities.Train;

import java.util.List;

public interface TrainDao {
    List<Train> findAllTrain();
    Train getTrainById(String id);
}
