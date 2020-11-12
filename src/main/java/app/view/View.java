package app.view;

import app.model.dto.CarriageTypeFromTo;
import app.model.dto.RouteFromToDepartMore;
import app.model.dto.TicketPricePrivilegeCarriage;
import app.model.entities.*;

import java.util.List;

public interface View {
    void mainMenu();

    void randomGen();

    void request();

    void sqlDao();

    void allTable();

    void insertTable(int table);

    void deleteTable(int table);

    void updateTable(int table);

    void requestNumber(int table);

    void printCarriage(List<Carriage> list);

    void printClient(List<Client> list);

    void printPlace(List<Place> list);

    void printRoute(List<Route> list);

    void printRouteToTrainTimeTable(List<RouteToTrainTimeTable> list);

    void printTicket(List<Ticket> list);

    void printTrain(List<Train> list);

    void printCarriageTypeFromTo(List<CarriageTypeFromTo> list);

    void printRouteFromToDepartMore(List<RouteFromToDepartMore> list);

    void printTicketPrivilegeCarriage(List<TicketPricePrivilegeCarriage> list);

    void wrong();
}
