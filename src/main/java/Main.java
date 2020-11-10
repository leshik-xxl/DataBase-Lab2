import app.model.*;
import app.model.sql.*;



public class Main {
    public static void main(String[] args) {
        ClientDao testClient = new SqlClientDao();
        TrainDao testTrain = new SqlTrainDao();
        RouteDao testRoute = new SqlRouteDao();
        RouteToTrainTimeTableDao testRouteToTimeTableDao = new SqlRouteToTrainTimeTableDao();
        CarriageDao testCarriage = new SqlCarriageDao();
        PlaceDao testPlace = new SqlPlaceDao();
        TicketDao testTicket = new SqlTicketDao();

        RandomServiceDao randomFill = new SqlRandomServiceDao();
        randomFill.fillRandomTable(10000);
        System.out.println(testClient.findAllClient());
        System.out.println("\n");
        System.out.println(testTrain.findAllTrain());
        System.out.println("\n");
        System.out.println(testRoute.findAllRoute());
        System.out.println("\n");
        System.out.println(testRouteToTimeTableDao.findAllRouteToTrainTimeTable());
        System.out.println("\n");
        System.out.println(testCarriage.findAllCarriage());
        System.out.println("\n");
        System.out.println(testPlace.findAllPlace());
        System.out.println("\n");
        System.out.println(testTicket.findAllTicket());

//        Client client = new Client(null, "email@testinsert.net", "leshik", "Test Insert");
//        testClient.insertClient(client);
//        System.out.println("\n\n" + testClient.findAllClient());


//        CarriageDao testCarriage = new SqlCarriageDao();
//        System.out.println(testCarriage.findAllCarriage());
//        testCarriage.updateCarriageRouteToTrain("car01", 17);
//        System.out.println("\n" + testCarriage.findAllCarriage());
//        testCarriage.deleteCarriage("568");
//        testCarriage.insertCarriage(new Carriage("pl", 5, "car06", 17));
//        System.out.println("\n\n\n");
//        System.out.println(testCarriage.findAllCarriage());

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
