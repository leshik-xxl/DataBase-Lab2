package app.model.sql;

import app.model.TrainDao;
import app.model.entities.Route;
import app.model.entities.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlTrainDao implements TrainDao{
    public static final String SQL_FIND_ALL_TRAIN = "SELECT * FROM train";
    public static final String SQL_GET_TRAIN_BY_ID = "SELECT * FROM train WHERE id_train LIKE ?" ;

    @Override
    public List<Train> findAllTrain() {
        List<Train> result = new ArrayList<Train>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_TRAIN);
            while (rs.next()) {
                result.add(new Train( rs.getString(1), rs.getInt(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Train getTrainById(String id){
        Train result = new Train(null, null);
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_GET_TRAIN_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = new Train( rs.getString(1), rs.getInt(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
