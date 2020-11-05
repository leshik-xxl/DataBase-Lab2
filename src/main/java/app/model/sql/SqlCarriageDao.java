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
    public static final String SQL_GET_CARRIAGE_BY_ID = "SELECT * FROM carriage WHERE id_carriage LIKE ?";


    @Override
    public List<Carriage> findAllCarriage() {
        List<Carriage> result = new ArrayList<Carriage>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_CARRIAGE);
            TrainDao train = new SqlTrainDao();
            while (rs.next()) {
                result.add(new Carriage(rs.getString(1), rs.getInt(2),
                        rs.getString(3), train.getTrainById(rs.getString(4))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Carriage getCarriageById(String id) {
        Carriage result = new Carriage(null, null, null, null);
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_GET_CARRIAGE_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            TrainDao train = new SqlTrainDao();
            while (rs.next()) {
                result = new Carriage(rs.getString(1), rs.getInt(2),
                        rs.getString(3), train.getTrainById(rs.getString(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
