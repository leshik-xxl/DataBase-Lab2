package app.model.sql;

import app.model.ClientDao;
import app.model.entities.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlClientDao implements ClientDao {
    public static final String SQL_FIND_ALL_CLIENT = "SELECT * FROM client";

    @Override
    public List<Client> findAllClient() {
        List<Client> result = new ArrayList<Client>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_CLIENT);
            while (rs.next()) {
                result.add(new Client(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
