package app.model.sql;

import app.model.ServiceDao;
import app.model.dto.TicketWithLessPricePrivilegeIsCarriageNumberLess;
import app.model.entities.Place;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlServiceDao implements ServiceDao {

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

    @Override
    public List<TicketWithLessPricePrivilegeIsCarriageNumberLess> findTicketWithLessPricePrivilegeIsCarriageNumberLess(BigDecimal price, Boolean privilege, Integer carriageNumber) {
        List<TicketWithLessPricePrivilegeIsCarriageNumberLess> result = new ArrayList<TicketWithLessPricePrivilegeIsCarriageNumberLess>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_TICKET_WITH_PRICELESS_PRIV_CARLESS);
            ps.setBigDecimal(1, price);
            ps.setBoolean(2, privilege);
            ps.setInt(3, carriageNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new TicketWithLessPricePrivilegeIsCarriageNumberLess(rs.getBigDecimal(1), rs.getBoolean(2),
                        rs.getTimestamp(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getTimestamp(7), rs.getTimestamp(8), rs.getString(9),
                        rs.getInt(10), rs.getInt(11)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
