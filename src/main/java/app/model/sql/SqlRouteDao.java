package app.model.sql;

import app.model.RouteDao;
import app.model.entities.Client;
import app.model.entities.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlRouteDao implements RouteDao {
    public static final String SQL_FIND_ALL_ROUTE = "SELECT * FROM route";
    public static final String SQL_GET_ROUTE_BY_ID = "SELECT * FROM route WHERE id_route = ?";

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
    public Route getRouteById(Integer id) {
//        Route result = new Route(null, null, null);
//        SqlConnection mySqlConnection = SqlConnection.getInstance();
//        Connection connection = mySqlConnection.getConnection();
//        try {
//            PreparedStatement ps = connection.prepareStatement(SQL_GET_ROUTE_BY_ID);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                result = new Route(rs.getInt(1), rs.getString(2),
//                        rs.getString(3));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
        return null;
    }
}
