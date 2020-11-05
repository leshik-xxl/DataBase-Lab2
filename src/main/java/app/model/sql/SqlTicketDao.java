package app.model.sql;

import app.model.TicketDao;
import app.model.entities.Client;
import app.model.entities.RouteToTrainTimeTable;
import app.model.entities.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlTicketDao implements TicketDao {
    public static final String SQL_FIND_ALL_TICKET = "SELECT * FROM ticket";

    @Override
    public List<Ticket> findAllTicket() {
        List<Ticket> result = new ArrayList<Ticket>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_TICKET);
            while (rs.next()) {
                result.add(new Ticket(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getBigDecimal(4), rs.getTimestamp(5), rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
