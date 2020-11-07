package app.model;

import app.model.entities.Route;
import app.model.entities.Train;

import java.util.List;

public interface TrainDao {
    List<Train> findAllTrain();
    void InsertTrain(Train train);
    void deleteTrain(String trainId);
    void updateTrainMaxCarriage(String id, Integer maxCarriage);
}
