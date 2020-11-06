package app.model;

import app.model.entities.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAllClient();
    void insertClient(Client client);
    void deleteClient(Integer id);
}
