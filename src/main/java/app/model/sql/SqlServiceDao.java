package app.model.sql;

import app.model.ServiceDao;
import app.model.dto.CarriageTypeFromTo;
import app.model.dto.RouteFromToDepartMore;
import app.model.dto.TicketPricePrivilegeCarriage;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlServiceDao implements ServiceDao {

    public static final String SQL_DELETE_ALL = "DELETE FROM carriage; " +
            "DELETE FROM client; " +
            "DELETE FROM place; " +
            "DELETE FROM route; " +
            "DELETE FROM route_to_train_time_table; " +
            "DELETE FROM ticket; " +
            "DELETE FROM train;";

    public static final String SQL_TICKET_WITH_PRICELESS_PRIV_CARLESS = "SELECT \n" +
            "\tt.price, \n" +
            "\tt.privillege,\n" +
            "\tt.buy_date,\n" +
            "\tc.full_name,\n" +
            "\tr.place_of_arrival,\n" +
            "\tr.place_of_departure, \n" +
            "\trtt.arrive_time,\n" +
            "\trtt.depart_time,\n" +
            "\ttr.id_train,\n" +
            "\tcar.number,\n" +
            "\tp.number_place\n" +
            "from ticket as t \n" +
            "inner join client as c \n" +
            "\ton t.fk_client_id = c.id_client\n" +
            "inner join place as p\n" +
            "\ton t.fk_id_place = p.id_place\n" +
            "inner join carriage as car \n" +
            "\ton p.carriage_id = car.id_carriage\n" +
            "inner join route_to_train_time_table as rtt\n" +
            "\ton car.fk_route_to_train_time_table = rtt.id_route_to_train\n" +
            "inner join route as r\n" +
            "\ton rtt.id_route = r.id_route\n" +
            "inner join train as tr\n" +
            "\ton rtt.id_train = tr.id_train\n" +
            "where t.price < ? AND t.privillege = ? AND car.number < ?";

    public static final String SQL_ROUTE_FROM_TO_DEPART_MORE = "SELECT r.place_of_departure, r.place_of_arrival, " +
            "rtt.depart_time, rtt.arrive_time FROM route AS r " +
            "INNER JOIN route_to_train_time_table AS rtt " +
            "ON r.id_route = rtt.id_route " +
            "WHERE r.place_of_departure = ? AND r.place_of_arrival = ? AND rtt.depart_time >= ?";

    public static final String SQL_CARRIAGE_ROUTE_TYPE = "SELECT r.place_of_departure, r.place_of_arrival, " +
            "car.type, car.id_carriage, rtt.arrive_time, " +
            "rtt.depart_time FROM route AS r INNER JOIN route_to_train_time_table AS rtt " +
            "ON r.id_route = rtt.id_route " +
            "INNER JOIN carriage AS car ON car.fk_route_to_train_time_table = rtt.id_route_to_train " +
            "WHERE r.place_of_departure = ? AND r.place_of_arrival = ? AND car.type = ?";

    @Override
    public List<TicketPricePrivilegeCarriage> findTicketPricePrivilegeCarriage(BigDecimal price, Boolean privilege, Integer carriageNumber) {
        List<TicketPricePrivilegeCarriage> result = new ArrayList<TicketPricePrivilegeCarriage>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_TICKET_WITH_PRICELESS_PRIV_CARLESS);
            ps.setBigDecimal(1, price);
            ps.setBoolean(2, privilege);
            ps.setInt(3, carriageNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new TicketPricePrivilegeCarriage(rs.getBigDecimal(1), rs.getBoolean(2),
                        rs.getTimestamp(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getTimestamp(7), rs.getTimestamp(8), rs.getString(9),
                        rs.getInt(10), rs.getInt(11)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<RouteFromToDepartMore> findRouteFromToDepartMore(String arrive, String depart, Timestamp departTime) {
        List<RouteFromToDepartMore> result = new ArrayList<RouteFromToDepartMore>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_ROUTE_FROM_TO_DEPART_MORE);
            ps.setString(1, depart);
            ps.setString(2, arrive);
            ps.setTimestamp(3, departTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new RouteFromToDepartMore(rs.getString(1), rs.getString(2),
                        rs.getTimestamp(3), rs.getTimestamp(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<CarriageTypeFromTo> findRouteWithTypeCarriage(String placeDepart, String placeArrive, String type) {
        List<CarriageTypeFromTo> result = new ArrayList<CarriageTypeFromTo>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_CARRIAGE_ROUTE_TYPE);
            ps.setString(1, placeDepart);
            ps.setString(2, placeArrive);
            ps.setString(3, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new CarriageTypeFromTo(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteAll() {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            query.executeUpdate(SQL_DELETE_ALL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
