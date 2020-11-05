package app.model.sql;

import app.model.RouteDao;
import app.model.RouteToTrainDao;
import app.model.TrainDao;
import app.model.entities.RouteToTrain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlRouteToTrainDao implements RouteToTrainDao {
    public static final String SQL_FIND_ALL_ROUTE_TO_TRAIN = "SELECT * FROM route_to_train";

    @Override
    public List<RouteToTrain> findAllRouteToTrain() {
        List<RouteToTrain> result = new ArrayList<RouteToTrain>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_ROUTE_TO_TRAIN);
            RouteDao route = new SqlRouteDao();
            TrainDao train = new SqlTrainDao();
            while (rs.next()) {
                result.add(new RouteToTrain(rs.getInt(1), route.getRouteById(rs.getInt(2)),
                        train.getTrainById(rs.getString(3)), rs.getDate(4), rs.getDate(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
