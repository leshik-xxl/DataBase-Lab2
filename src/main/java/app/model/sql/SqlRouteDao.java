package app.model.sql;

import app.model.RouteDao;
import app.model.entities.Route;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlRouteDao implements RouteDao {
    public static final String SQL_FIND_ALL_ROUTE = "SELECT * FROM route";
    public static final String SQL_INSERT_ROUTE = "INSERT INTO route (place_of_departure, place_of_arrival) " +
            "VALUES (?, ?)";
    public static final String SQL_DELETE_ROUTE_BY_ID = "DELETE FROM route WHERE id_route = ?";
    public static final String SQL_UPDATE_ROUTE_DEPARTURE = "UPDATE route SET place_of_departure = ? WHERE id_route LIKE ?";
    public static final String SQL_UPDATE_ROUTE_ARRIVAL = "UPDATE route SET place_of_arrival = ? WHERE id_route LIKE ?";




    @Override
    public List<Route> findAllRoute() {
        List<Route> result = new ArrayList<Route>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_ROUTE);
            while (rs.next()) {
                result.add(new Route(rs.getInt(1), rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertRoute(Route route) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_ROUTE);
            ps.setString(1, route.getPlace_of_departure());
            ps.setString(2, route.getPlace_of_arrival());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteRoute(Integer id) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_ROUTE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updatePlaceOfDeparture(Integer id, String departure) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ROUTE_DEPARTURE);
            ps.setString(1, departure);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updatePlaceOfArrival(Integer id, String arrival) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ROUTE_ARRIVAL);
            ps.setString(1, arrival);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
