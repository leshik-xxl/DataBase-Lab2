package app.model;

import app.model.entities.Carriage;
import app.model.entities.Client;

import java.util.List;

public interface CarriageDao {
    List<Carriage> findAllCarriage();
    List<Client> getClientList(Integer id);
}
