package app.model.sql;

import app.model.TicketDao;
import app.model.entities.Client;
import app.model.entities.RouteToTrainTimeTable;
import app.model.entities.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlTicketDao implements TicketDao {
    public static final String SQL_FIND_ALL_TICKET = "SELECT * FROM ticket";
    public static final String SQL_INSERT_TICKET = "INSERT INTO ticket (fk_client_id, fk_id_place, price, buy_date, privillege ) " +
            "VALUES (?, ?, ?, ?, ?)";

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

    @Override
    public void insertTicket(Ticket ticket) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_TICKET);
            ps.setInt(1, ticket.getClient());
            ps.setInt(2, ticket.getPlace());
            ps.setBigDecimal(3, ticket.getPrice());
            ps.setTimestamp(4, (Timestamp) ticket.getBuy_date());
            ps.setBoolean(5, ticket.getPrivilege());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
