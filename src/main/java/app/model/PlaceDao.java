package app.model;

import app.model.entities.Carriage;
import app.model.entities.Place;

import java.util.List;

public interface PlaceDao {
    List<Place> findAllPlace();
    Carriage getCarriageName(String id);
}
