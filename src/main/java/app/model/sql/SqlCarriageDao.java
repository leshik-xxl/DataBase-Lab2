package app.model.sql;

import app.model.CarriageDao;
import app.model.TrainDao;
import app.model.entities.Carriage;
import app.model.entities.Route;
import app.model.entities.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlCarriageDao implements CarriageDao {

    public static final String SQL_FIND_ALL_CARRIAGE = "SELECT * FROM carriage";

    @Override
    public List<Carriage> findAllCarriage() {
        List<Carriage> result = new ArrayList<Carriage>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_CARRIAGE);
            while (rs.next()) {
                result.add(new Carriage(rs.getString(1), rs.getInt(2),
                        rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
