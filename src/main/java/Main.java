import app.model.*;
import app.model.entities.Route;
import app.model.sql.*;

public class Main {
    public static void main(String[] args) {
        ClientDao testClient = new SqlClientDao();
        System.out.println(testClient.findAllClient());

        System.out.println("\n\n\n");
        CarriageDao testCarriage = new SqlCarriageDao();
        System.out.println(testCarriage.findAllCarriage());

        System.out.println("\n\n\n");
        PlaceDao testPlace = new SqlPlaceDao();
        System.out.println(testPlace.findAllPlace());

        System.out.println("\n\n\n");
        RouteDao testRoute = new SqlRouteDao();
        System.out.println(testRoute.findAllRoute());

        System.out.println("\n\n\n");
        TrainDao testTrain = new SqlTrainDao();
        System.out.println(testTrain.findAllTrain());

        System.out.println("\n\n\n");
        RouteToTrainDao testRouteToTrain = new SqlRouteToTrainDao();
        System.out.println(testRouteToTrain.findAllRouteToTrain());
    }

}
