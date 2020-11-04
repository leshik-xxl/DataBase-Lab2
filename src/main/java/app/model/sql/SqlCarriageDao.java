package app.model.sql;

import app.model.CarriageDao;
import app.model.entities.Carriage;
import app.model.entities.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlCarriageDao implements CarriageDao {
    public static final String SQL_GET_TRAIN_NAME = "SELECT id_train, max_carriage FROM train WHERE id_train = ?" ;
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
                        rs.getString(3), getTrainName(rs.getString(4))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Train> getTrainName(String id) {
        List<Train> result = new ArrayList<Train>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_GET_TRAIN_NAME);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Train(rs.getString(1), rs.getInt(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
