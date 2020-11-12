package app.view;

import app.model.dto.CarriageTypeFromTo;
import app.model.dto.RouteFromToDepartMore;
import app.model.dto.TicketPricePrivilegeCarriage;
import app.model.entities.*;

import java.util.List;

public class ConsoleViewer implements View{
    @Override
    public void mainMenu() {
        System.out.println("____Main Menu____");
        System.out.println("Choose table or operation");
        System.out.println("1. Table Carriage");
        System.out.println("2. Table Client");
        System.out.println("3. Table Place");
        System.out.println("4. Table Route");
        System.out.println("5. Table RouteToTrainTimeTable");
        System.out.println("6. Table Ticket");
        System.out.println("7. Table Train");
        System.out.println("8. All Table");
        System.out.println("9. Request");
        System.out.println("10. Exit");
        System.out.println("Choose variant: ");
    }

    @Override
    public void randomGen() {
        System.out.println("Enter count of rows to generate random data: ");
    }

    @Override
    public void request() {
        System.out.println("1. Tickets for which the price is less than the specified one,\n" +
                " the carriages on this train are less than the specified one, whether there are any benefits");
        System.out.println("2. Trains that depart on a given route from a given time");
        System.out.println("3. Trains that go on a given route with a specified type of carriage");
        System.out.println("4. To Main Menu");
    }

    @Override
    public void sqlDao() {
        System.out.println("1. Insert");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Find All");
        System.out.println("5. To Main Menu");
    }


    @Override
    public void allTable() {
        System.out.println("1. Random generator");
        System.out.println("2. Delete All");
        System.out.println("3. To Main Menu");
    }

    @Override
    public void insertTable(int table) {
        switch (table){
            case 1:
                System.out.println("Insert(type(String), number(Int), id(String), idRouteToTrainTimeTable(Int)) ");
                break;
            case 2:
                System.out.println("Insert(email(String), login(String), fullName(String)): ");
                break;
            case 3:
                System.out.println("Insert(number_place(integer), carriage_id(String)): ");
                break;
            case 4:
                System.out.println("Insert (place_of_departure(String), place_of_arrival(String)): ");
                break;
            case 5:
                System.out.println("Insert (fk_id_route(Int)), fk_id_train(String), arrive_time(format: yyyy-MM-dd HH:mm), depart_time(format: yyyy-MM-dd HH:mm)");
                break;
            case 6:
                System.out.println("Insert (fk_client_id(Int), fk_id_place(Int), price(BigDecimal), buy_date(format: yyyy-MM-dd HH:mm), privilege(Boolean))");
                break;
            case 7:
                System.out.println("Insert(id(String), max_number(Int))");
                break;
            default:
                break;
        }
    }

    @Override
    public void deleteTable(int table){
        switch (table){
            case 1:
                System.out.println("DeleteById: (String) ");
                break;
            case 2:
                System.out.println("DeleteById id(Int): ");
                break;
            case 3:
                System.out.println("DeleteById id(Int): ");
                break;
            case 4:
                System.out.println("DeleteById id(Int): ");
                break;
            case 5:
                System.out.println("DeleteById id(Int): ");
                break;
            case 6:
                System.out.println("DeleteById id(Int): ");
                break;
            case 7:
                System.out.println("DeleteById id(Int): ");
                break;
            default:
                break;
        }
    }

    @Override
    public void updateTable(int table){
        switch (table){
            case 1:
                System.out.println("Update Number Carriage by Id: (String), (Int) ");
                break;
            case 2:
                System.out.println("Update email by login(login(String), email(String)): ");
                break;
            case 3:
                System.out.println("Update number_place By Id (id(Integer), number_place(Integer)): ");
                break;
            case 4:
                System.out.println("Update placeOfArrive By Id(id(Integer), placeOfArrive(String))");
                break;
            case 5:
                System.out.println("Update departTime By Id(id(Int), depart_time)(format: yyyy-MM-dd HH:mm)");
                break;
            case 6:
                System.out.println("Update price By Id (id(Integer), price(BigDecimal))");
                break;
            case 7:
                System.out.println("Update max_carriage By id(id(String), max_carriage(Int)) ");
                break;
            default:
                break;
        }
    }

    @Override
    public void requestNumber(int table){
        switch (table){
            case 1:
                System.out.println("price(BigDecimal), privilege(Boolean), carriageNumber(Int)");
                break;
            case 2:
                System.out.println("arrive_place(String), depart_time(String), depart_time(format: yyyy-MM-dd HH:mm)");
                break;
            case 3:
                System.out.println("arrive_place(String), depart_time(String), type(String)");
                break;
            default:
                break;
        }
    }

    @Override
    public void printCarriage(List<Carriage> list) {
        System.out.println(list);
    }

    @Override
    public void printClient(List<Client> list) {
        System.out.println(list);
    }

    @Override
    public void printPlace(List<Place> list) {
        System.out.println(list);
    }

    @Override
    public void printRoute(List<Route> list) {
        System.out.println(list);
    }

    @Override
    public void printRouteToTrainTimeTable(List<RouteToTrainTimeTable> list) {
        System.out.println(list);
    }

    @Override
    public void printTicket(List<Ticket> list) {
        System.out.println(list);
    }

    @Override
    public void printTrain(List<Train> list) {
        System.out.println(list);
    }

    @Override
    public void printCarriageTypeFromTo(List<CarriageTypeFromTo> list) {
        System.out.println(list);
    }

    @Override
    public void printRouteFromToDepartMore(List<RouteFromToDepartMore> list) {
        System.out.println(list);
    }

    @Override
    public void printTicketPrivilegeCarriage(List<TicketPricePrivilegeCarriage> list) {
        System.out.println(list);
    }

    @Override
    public void wrong() {
        System.out.println("Input Error");
    }
}
