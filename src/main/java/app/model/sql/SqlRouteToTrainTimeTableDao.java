package app.model.sql;

import app.model.RouteDao;
import app.model.RouteToTrainTimeTableDao;
import app.model.TrainDao;
import app.model.entities.RouteToTrainTimeTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlRouteToTrainTimeTableDao implements RouteToTrainTimeTableDao {
    public static final String SQL_FIND_ALL_ROUTE_TO_TRAIN = "SELECT * FROM route_to_train_time_table";

    @Override
    public List<RouteToTrainTimeTable> findAllRouteToTrainTimeTable() {
        List<RouteToTrainTimeTable> result = new ArrayList<RouteToTrainTimeTable>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_ROUTE_TO_TRAIN);
            while (rs.next()) {
                result.add(new RouteToTrainTimeTable(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getTimestamp(4), rs.getTimestamp(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
