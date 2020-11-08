package app.model.sql;

import app.model.RandomServiceDao;
import app.model.entities.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlRandomServiceDao implements RandomServiceDao {
    //filling procedure
    /*
    * client
    * route
    * train
    * route_to_train_time_table
    * carriage
    * place
    * ticket
    * */
    public static final String SQL_RANDOM_CHAR = "chr(trunc(97 + random()*25)::int)";
    public static final String SQL_RANDOM_INT = "floor(random()*(100-1+1))+1";
    public static final String SQL_RANDOM_NUMERIC = "random()*(1300 - 50) + 50";
    public static final String SQL_RANDOM_DATE = "'2014-01-10 20:00:00'::timestamp + " +
    "random() * ('2014-01-20 20:00:00'::timestamp - '2014-01-10 10:00:00'::timestamp)";

    public static final String SQL_SELECT_ID_ROUTE = "SELECT id_route FROM route";
    public static final String SQL_SELECT_ID_TRAIN = "SELECT id_train FROM train";
    public static final String SQL_SELECT_ID_ROUTE_TO_TRAIN_TIME_TABLE = "SELECT id_route_to_train FROM route_to_train_time_table";
    public static final String SQL_SELECT_ID_CARRIAGE = "SELECT id_carriage FROM carriage";
    public static final String SQL_SELECT_ID_PLACE = "SELECT id_place FROM place";
    public static final String SQL_SELECT_ID_CLIENT = "SELECT id_client FROM client";

    public static final String SQL_FILL_RANDOM_CLIENT = "INSERT INTO client (email , login, full_name) " +
            "SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "|| '@gmail.com' " +"," +
             SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " FROM generate_series(1, ?)";

    public static final String SQL_FILL_ROUTE = "INSERT INTO route (place_of_departure, place_of_arrival) " +
            " SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " FROM generate_series(1, ?)";

    public static final String SQL_FILL_TRAIN = "INSERT INTO train (id_train, max_carriage) " +
            " SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_INT + " FROM generate_series(1, ?)";

    public static final String SQL_FILL_ROUTE_TO_TRAIN_TIMETABLE = "INSERT INTO route_to_train_time_table (id_route, id_train, arrive_time, depart_time)" +
            " SELECT ?, ?, " +
            SQL_RANDOM_DATE + ", " + SQL_RANDOM_DATE;

    public static final String SQL_FILL_CARRIAGE = "INSERT INTO carriage (type, number, id_carriage, fk_route_to_train_time_table) " +
            "SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " ," + SQL_RANDOM_INT +" , " +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + ", " + "?";

    public static final String SQL_FILL_PLACE = "INSERT INTO place (number_place, carriage_id) SELECT " + SQL_RANDOM_INT + ", ?";

    public static final String SQL_FILL_TICKET = "INSERT INTO ticket (fk_client_id, fk_id_place, price, buy_date, privillege) " +
            "SELECT " + "? , ? , " + SQL_RANDOM_NUMERIC + " , " + SQL_RANDOM_DATE + ", false";

    private void fillClient(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_FILL_RANDOM_CLIENT);
            ps.setInt(1, numberRow);
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void fillRoute(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_FILL_ROUTE);
            ps.setInt(1, numberRow);
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void fillTrain(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_FILL_TRAIN);
            ps.setInt(1, numberRow);
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void fillRouteToTrainTimeTable(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement queryRoute = connection.createStatement();
            ResultSet rsRoute = queryRoute.executeQuery(SQL_SELECT_ID_ROUTE);

            Statement queryTrain = connection.createStatement();
            ResultSet rsTrain = queryTrain.executeQuery(SQL_SELECT_ID_TRAIN);

            for(int i = 0; i < numberRow; i++){
                rsRoute.next();
                rsTrain.next();
                PreparedStatement ps = connection.prepareStatement(SQL_FILL_ROUTE_TO_TRAIN_TIMETABLE);
                ps.setInt(1, rsRoute.getInt(1));
                ps.setString(2, rsTrain.getString(1));
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillCarriage(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement queryRouteToTrainTimeTable = connection.createStatement();
            ResultSet rsRouteToTrainTimeTable = queryRouteToTrainTimeTable.executeQuery(SQL_SELECT_ID_ROUTE_TO_TRAIN_TIME_TABLE);

            for(int i = 0; i < numberRow; i++){
                rsRouteToTrainTimeTable.next();
                PreparedStatement ps = connection.prepareStatement(SQL_FILL_CARRIAGE);
                ps.setInt(1, rsRouteToTrainTimeTable.getInt(1));
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillPlace(int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement queryCarriage = connection.createStatement();
            ResultSet rsCarriage = queryCarriage.executeQuery(SQL_SELECT_ID_CARRIAGE);

            for(int i = 0; i < numberRow; i++){
                rsCarriage.next();
                PreparedStatement ps = connection.prepareStatement(SQL_FILL_PLACE);
                ps.setString(1, rsCarriage.getString(1));
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillTicket (int numberRow){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement queryClient = connection.createStatement();
            ResultSet rsClient = queryClient.executeQuery(SQL_SELECT_ID_CLIENT);

            Statement queryPlace = connection.createStatement();
            ResultSet rsPlace = queryPlace.executeQuery(SQL_SELECT_ID_PLACE);

            for(int i = 0; i < numberRow; i++){
                rsClient.next();
                rsPlace.next();
                PreparedStatement ps = connection.prepareStatement(SQL_FILL_TICKET);
                ps.setInt(1, rsClient.getInt(1));
                ps.setInt(2, rsPlace.getInt(1));
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void fillRandomTable(int numberRow) {
            fillClient(numberRow);
            fillRoute(numberRow);
            fillTrain(numberRow);
            fillRouteToTrainTimeTable(numberRow);
            fillCarriage(numberRow);
            fillPlace(numberRow);
            fillTicket(numberRow);
    }
}

