package app.model;

import app.model.entities.Ticket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TicketDao {
    List<Ticket> findAllTicket();
    void insertTicket(Ticket ticket);
    void deleteTicket(Integer id);
    void updateTicketPriceById(Integer id, BigDecimal price);
    void updateTicketBuyDateById(Integer id, Date buyDate);
    void updateTicketPrivilegeById(Integer id, Boolean privilege);
}
