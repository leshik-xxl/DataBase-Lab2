package app.model.sql;

import app.model.TrainDao;
import app.model.entities.Route;
import app.model.entities.Train;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlTrainDao implements TrainDao{
    public static final String SQL_FIND_ALL_TRAIN = "SELECT * FROM train";
    public static final String SQL_INSERT_TRAIN = "INSERT INTO train (id_train, max_carriage) " +
            "VALUES (?, ?)";
    public static final String SQL_DELETE_TRAIN_BY_ID = "DELETE FROM train WHERE id_train = ?";


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

    @Override
    public void InsertTrain(Train train) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_TRAIN);
            ps.setString(1, train.getId_train());
            ps.setInt(2, train.getMax_carriage());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteTrain(String trainId) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_TRAIN_BY_ID);
            ps.setString(1, trainId);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
