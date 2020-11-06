import app.model.*;
import app.model.entities.Carriage;
import app.model.entities.Client;
import app.model.entities.Route;
import app.model.entities.Ticket;
import app.model.sql.*;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
//        ClientDao testClient = new SqlClientDao();
//        System.out.println(testClient.findAllClient());
//
//        Client client = new Client(null, "email@testinsert.net", "leshik", "Test Insert");
//        testClient.insertClient(client);
//        System.out.println("\n\n" + testClient.findAllClient());


        CarriageDao testCarriage = new SqlCarriageDao();
        System.out.println(testCarriage.findAllCarriage());
        testCarriage.deleteCarriage("568");
        //testCarriage.insertCarriage(new Carriage("pl", 5, "car06", 17));
        System.out.println("\n\n\n");
        System.out.println(testCarriage.findAllCarriage());

//
//        System.out.println("\n\n\n");
//        PlaceDao testPlace = new SqlPlaceDao();
//        System.out.println(testPlace.findAllPlace());
//
//        System.out.println("\n\n\n");
//        RouteDao testRoute = new SqlRouteDao();
//        System.out.println(testRoute.findAllRoute());
//
//        Route route = new Route(null, "Rivne", "Odessa");
//        testRoute.insertRoute(route);
//        System.out.println("\n\n" + testRoute.findAllRoute());
//
//        System.out.println("\n\n\n");
//        TrainDao testTrain = new SqlTrainDao();
//        System.out.println(testTrain.findAllTrain());
//
//        System.out.println("\n\n\n");
//        RouteToTrainTimeTableDao testRouteToTrainTimeTable = new SqlRouteToTrainTimeTableDao();
//        System.out.println(testRouteToTrainTimeTable.findAllRouteToTrainTimeTable());
//
//        System.out.println("\n\n\n");
//        TicketDao testTicket = new SqlTicketDao();
//        System.out.println(testTicket.findAllTicket());
    }

}
