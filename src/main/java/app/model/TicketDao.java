package app.model;

import app.model.entities.Ticket;

import java.util.List;

public interface TicketDao {
    List<Ticket> findAllTicket();

}
