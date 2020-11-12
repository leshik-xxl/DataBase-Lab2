package app.controller;

import app.model.*;
import app.model.entities.*;
import app.model.sql.*;
import app.view.View;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    public static Timestamp parseDate(String date) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parsingDate = null;
        try {
            parsingDate = ft.parse(date);
            //System.out.println(parsingDate);
        } catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }
        return new Timestamp(parsingDate.getTime());
    }

    public void appDo() {
        while (true) {
            if (mainMenu() == 1) return;
        }

    }

    private int mainMenu() {
        view.mainMenu();
        switch (listener()) {
            case 1:
                while (true) {
                    if (sqlDaoCarriage() == 1) break;
                }
                break;
            case 2:
                while (true) {
                    if (sqlDaoClient() == 1) break;
                }
                break;
            case 3:
                while (true) {
                    if (sqlDaoPlace() == 1) break;
                }
                break;
            case 4:
                while (true) {
                    if (sqlDaoRoute() == 1) break;
                }
                break;
            case 5:
                while (true) {
                    if (sqlDaoRouteToTrain() == 1) break;
                }
                break;
            case 6:
                while (true) {
                    if (sqlDaoTicket() == 1) break;
                }
                break;
            case 7:
                while (true) {
                    if (sqlDaoTrain() == 1) break;
                }
                break;
            case 8:
                while (true) {
                    if (allTable() == 1) break;
                }
                break;
            case 9:
                while (true) {
                    if (sqlRequest() == 1) break;
                }
                break;
            case 10:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoCarriage() {
        Scanner scan = new Scanner(System.in);
        CarriageDao carriageDao = new SqlCarriageDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(1);
                carriageDao.insertCarriage(new Carriage(scan.nextLine(), Integer.parseInt(scan.nextLine()), scan.nextLine(), scan.nextInt()));
                break;
            case 2:
                view.deleteTable(1);
                carriageDao.deleteCarriage(scan.nextLine());
                break;
            case 3:
                view.updateTable(1);
                carriageDao.updateCarriageNumber(scan.nextLine(), scan.nextInt());
                break;
            case 4:
                view.printCarriage(carriageDao.findAllCarriage());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoClient() {
        Scanner scan = new Scanner(System.in);
        ClientDao clientDao = new SqlClientDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(2);
                clientDao.insertClient(new Client(null, scan.nextLine(), scan.nextLine(), scan.nextLine()));
                break;
            case 2:
                view.deleteTable(2);
                clientDao.deleteClient(scan.nextInt());
                break;
            case 3:
                view.updateTable(2);
                clientDao.updateClient(scan.nextLine(), scan.nextLine());
                break;
            case 4:
                view.printClient(clientDao.findAllClient());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoPlace() {
        Scanner scan = new Scanner(System.in);
        PlaceDao placeDao = new SqlPlaceDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(3);
                placeDao.insertPlace(new Place(null, scan.nextInt(), scan.nextLine()));
                break;
            case 2:
                view.deleteTable(3);
                placeDao.deletePlace(scan.nextInt());
                break;
            case 3:
                view.updateTable(3);
                placeDao.updateNumberPlace(scan.nextInt(), scan.nextInt());
                break;
            case 4:
                view.printPlace(placeDao.findAllPlace());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoRoute() {
        Scanner scan = new Scanner(System.in);
        RouteDao routeDao = new SqlRouteDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(4);
                routeDao.insertRoute(new Route(null, scan.nextLine(), scan.nextLine()));
                break;
            case 2:
                view.deleteTable(4);
                routeDao.deleteRoute(scan.nextInt());
                break;
            case 3:
                view.updateTable(4);
                routeDao.updatePlaceOfArrival(scan.nextInt(), scan.nextLine());
                break;
            case 4:
                view.printRoute(routeDao.findAllRoute());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoRouteToTrain() {
        Scanner scan = new Scanner(System.in);
        RouteToTrainTimeTableDao routeToTrainTimeTableDao = new SqlRouteToTrainTimeTableDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(5);
                routeToTrainTimeTableDao.insertRouteToTrainTimeTable(new RouteToTrainTimeTable(null, Integer.parseInt(scan.nextLine()),
                        scan.nextLine(), parseDate(scan.nextLine()), parseDate(scan.nextLine())));
                break;
            case 2:
                view.deleteTable(5);
                routeToTrainTimeTableDao.deleteRouteToTrainTimeTable(scan.nextInt());
                break;
            case 3:
                view.updateTable(5);
                routeToTrainTimeTableDao.updateRouteToTrainTimeTableOfDeparture(Integer.parseInt(scan.nextLine()), parseDate(scan.nextLine()));
                break;
            case 4:
                view.printRouteToTrainTimeTable(routeToTrainTimeTableDao.findAllRouteToTrainTimeTable());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoTicket() {
        Scanner scan = new Scanner(System.in);
        TicketDao ticketDao = new SqlTicketDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(6);
                ticketDao.insertTicket(new Ticket(null, Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), new BigDecimal(scan.nextLine()),
                        parseDate(scan.nextLine()), Boolean.parseBoolean(scan.nextLine())));
                break;
            case 2:
                view.deleteTable(6);
                ticketDao.deleteTicket(scan.nextInt());
                break;
            case 3:
                view.updateTable(6);
                ticketDao.updateTicketPriceById(scan.nextInt(), scan.nextBigDecimal());
                break;
            case 4:
                view.printTicket(ticketDao.findAllTicket());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlDaoTrain() {
        Scanner scan = new Scanner(System.in);
        TrainDao trainDao = new SqlTrainDao();
        view.sqlDao();
        switch (listener()) {
            case 1:
                view.insertTable(7);
                trainDao.InsertTrain(new Train(scan.nextLine(), scan.nextInt()));
                break;
            case 2:
                view.deleteTable(7);
                trainDao.deleteTrain(scan.nextLine());
                break;
            case 3:
                view.updateTable(7);
                trainDao.updateTrainMaxCarriage(scan.nextLine(), scan.nextInt());
                break;
            case 4:
                view.printTrain(trainDao.findAllTrain());
                break;
            case 5:
                return 1;
            default:
                view.wrong();
                break;
        }
        return 0;
    }

    public int sqlRequest() {
        Scanner scan = new Scanner(System.in);
        ServiceDao serviceDao = new SqlServiceDao();
        view.request();
        switch (listener()) {
            case 1:
                view.requestNumber(1);
                view.printTicketPrivilegeCarriage(serviceDao.findTicketPricePrivilegeCarriage(new BigDecimal(scan.nextLine()), Boolean.parseBoolean(scan.nextLine()),
                        Integer.parseInt(scan.nextLine())));
                break;
            case 2:
                view.requestNumber(2);
                view.printRouteFromToDepartMore(serviceDao.findRouteFromToDepartMore(scan.nextLine(), scan.nextLine(), parseDate(scan.nextLine())));
                break;
            case 3:
                view.requestNumber(3);
                view.printCarriageTypeFromTo(serviceDao.findRouteWithTypeCarriage(scan.nextLine(), scan.nextLine(), scan.nextLine()));
                break;
            case 4:
                return 1;
            default:
                view.wrong();
                break;

        }
        return 0;
    }

    public int allTable() {
        Scanner scan = new Scanner(System.in);
        RandomServiceDao randomServiceDao = new SqlRandomServiceDao();
        ServiceDao serviceDao = new SqlServiceDao();
        view.allTable();
        switch (listener()) {
            case 1:
                view.randomGen();
                randomServiceDao.fillRandomTable(scan.nextInt());
                break;
            case 2:
                serviceDao.deleteAll();
                break;
            case 3:
                return 1;
            default:
                view.wrong();
                break;

        }
        return 0;
    }

    private int listener() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
