package app.model.sql;

import app.model.TicketDao;
import app.model.entities.Ticket;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqlTicketDao implements TicketDao {
    public static final String SQL_FIND_ALL_TICKET = "SELECT * FROM ticket";
    public static final String SQL_INSERT_TICKET = "INSERT INTO ticket (fk_client_id, fk_id_place, price, buy_date, privillege ) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_DELETE_TICKET_BY_ID = "DELETE FROM ticket WHERE id_ticket = ?";
    public static final String SQL_UPDATE_TICKET_PRICE =
            "UPDATE ticket SET price = ? WHERE id_ticket LIKE ?";
    public static final String SQL_UPDATE_TICKET_BUY_DATE =
            "UPDATE ticket SET buy_date = ? WHERE id_ticket LIKE ?";
    public static final String SQL_UPDATE_TICKET_PRIVILEGE =
            "UPDATE ticket SET privillege = ? WHERE id_ticket LIKE ?";

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

    @Override
    public void deleteTicket(Integer id) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_TICKET_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateTicketPriceById(Integer id, BigDecimal price) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_TICKET_PRICE);
            ps.setBigDecimal(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateTicketBuyDateById(Integer id, Date buyDate) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_TICKET_BUY_DATE);
            ps.setTimestamp(1, (Timestamp) buyDate);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateTicketPrivilegeById(Integer id, Boolean privilege) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_TICKET_PRIVILEGE);
            ps.setBoolean(1, privilege);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
