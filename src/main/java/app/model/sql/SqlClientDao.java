package app.model.sql;

import app.model.ClientDao;
import app.model.entities.Client;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlClientDao implements ClientDao {
    public static final String SQL_FIND_ALL_CLIENT = "SELECT * FROM client";
    public static final String SQL_INSERT_CLIENT = "INSERT INTO client (email, login, full_name) " +
            "VALUES (?, ?, ?)";

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

    @Override
    public void insertClient(Client client) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_CLIENT);
            ps.setString(1, client.getE_mail());
            ps.setString(2, client.getLogin());
            ps.setString(3, client.getFull_name());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
