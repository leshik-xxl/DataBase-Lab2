package app.model.sql;

import app.model.CarriageDao;
import app.model.entities.Carriage;
import app.model.entities.Client;

import java.util.List;

public class SqlCarriageDao implements CarriageDao {
    @Override
    public List<Carriage> findAllCarriage() {
        return null;
    }

    @Override
    public List<Client> getClientList(Integer id) {
        return null;
    }
}
