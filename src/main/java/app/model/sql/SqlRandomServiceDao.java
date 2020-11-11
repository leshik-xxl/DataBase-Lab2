package app.model.sql;

import app.model.*;
import app.model.entities.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
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
    public static final String SQL_RANDOM_INT = "floor(random()*(200-1+1))+1";
    public static final String SQL_RANDOM_NUMERIC = "random()*(1300 - 50) + 50";
    public static final String SQL_RANDOM_DATE = "'2020-01-1 20:00:00'::timestamp + " +
            "random() * ('2020-12-30 20:00:00'::timestamp - '2020-01-10 10:00:00'::timestamp)";

    public static final String SQL_SELECT_FK_ROUTE = "SELECT r.id_route FROM route AS r LEFT OUTER JOIN route_to_train_time_table AS rtt " +
            "ON r.id_route = rtt.id_route WHERE rtt.id_route IS NULL";

    public static final String SQL_SELECT_FK_ROUTE_TO_TRAIN_TIME_TABLE = "SELECT rtt.id_route_to_train FROM route_to_train_time_table AS rtt LEFT OUTER JOIN carriage AS c " +
            "ON rtt.id_route_to_train = c.fk_route_to_train_time_table WHERE c.fk_route_to_train_time_table IS NULL";

    public static final String SQL_SELECT_FK_TRAIN = "SELECT t.id_train FROM train AS t LEFT OUTER JOIN route_to_train_time_table AS rtt " +
            "ON t.id_train = rtt.id_train WHERE rtt.id_train IS NULL";

    public static final String SQL_SELECT_FK_CARRIAGE = "SELECT c.id_carriage FROM carriage AS c LEFT OUTER JOIN place AS p " +
            "ON c.id_carriage = p.carriage_id WHERE p.carriage_id IS NULL";

    public static final String SQL_SELECT_FK_CLIENT = "SELECT c.id_client FROM client AS c LEFT OUTER JOIN ticket AS t " +
            "ON c.id_client = t.fk_client_id WHERE t.fk_client_id IS NULL";

    public static final String SQL_SELECT_FK_PLACE = "SELECT p.id_place FROM place AS p LEFT OUTER JOIN ticket AS t " +
            "ON p.id_place = t.fk_id_place WHERE t.fk_id_place IS NULL";


    private String getRandomChar() {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomString = connection.createStatement();
            ResultSet rs = randomString.executeQuery("SELECT " + SQL_RANDOM_CHAR);
            rs.next();

            String res = rs.getString(1);
            return res;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private String getRandomString(int characters) {
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < characters; i++) {
            if (getRandomChar() != null) strBuild.append(getRandomChar());
        }
        return String.valueOf(strBuild);
    }

    private Integer getRandomInteger() {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomInt = connection.createStatement();
            ResultSet rs = randomInt.executeQuery("SELECT " + SQL_RANDOM_INT);
            rs.next();

            Integer res = rs.getInt(1);
            return res;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Timestamp getRandomTimestamp() {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomInt = connection.createStatement();
            ResultSet rs = randomInt.executeQuery("SELECT " + SQL_RANDOM_DATE);
            rs.next();

            Timestamp res = rs.getTimestamp(1);
            return res;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private BigDecimal getRandomNumeric(){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomInt = connection.createStatement();
            ResultSet rs = randomInt.executeQuery("SELECT " + SQL_RANDOM_NUMERIC);
            rs.next();

            BigDecimal res = rs.getBigDecimal(1);
            return res;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Boolean getRandomBoolean(){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomInt = connection.createStatement();
            ResultSet rs = randomInt.executeQuery("SELECT floor(random() * 2)");
            rs.next();
            int res = rs.getInt(1);
            if(res == 1) return true;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private List<Integer> findAllRouteAvailableRouteId() {
        List<Integer> result = new ArrayList<Integer>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_ROUTE);
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private List<Integer> findAllCarriageRouteTrainTimeTable() {
        List<Integer> result = new ArrayList<Integer>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_ROUTE_TO_TRAIN_TIME_TABLE);
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private List<String> findAllCarriage() {
        List<String> result = new ArrayList<String>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_CARRIAGE);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private List<String> findAllRouteAvailableTrainId() {
        List<String> result = new ArrayList<String>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_TRAIN);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private List<Integer> findAllPlace() {
        List<Integer> result = new ArrayList<Integer>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_PLACE);
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private List<Integer> findAllClient() {
        List<Integer> result = new ArrayList<Integer>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_SELECT_FK_CLIENT);
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private void fillClient(int numberRow) {
        ClientDao insertClient = new SqlClientDao();
        for (int i = 0; i < numberRow; i++) {
            insertClient.insertClient(new Client(null, getRandomString(9) + "@gmail.com", getRandomString(7),
                    getRandomString(7) + " " + getRandomString(8)));
        }
    }

    private void fillRoute(int numberRow) {
        RouteDao insertRoute = new SqlRouteDao();
        for (int i = 0; i < numberRow; i++) {
            insertRoute.insertRoute(new Route(null, getRandomString(20), getRandomString(20)));
        }
    }

    private void fillTrain(int numberRow) {
        TrainDao insertTrain = new SqlTrainDao();
        for (int i = 0; i < numberRow; i++) {
            insertTrain.InsertTrain(new Train(getRandomString(5), getRandomInteger()));
        }
    }

    private void fillRouteToTrainTimeTable() {
        RouteToTrainTimeTableDao insertRouteToTrainTimeTable = new SqlRouteToTrainTimeTableDao();
        List<Integer> id_route = findAllRouteAvailableRouteId();
        List<String> id_train = findAllRouteAvailableTrainId();
        int numberRow = id_route.size();
        if(id_route.size() > id_train.size())
            numberRow = id_train.size();
        for (int i = 0; i < numberRow; i++) {
            insertRouteToTrainTimeTable.insertRouteToTrainTimeTable(new RouteToTrainTimeTable(null, id_route.get(i),
                    id_train.get(i), getRandomTimestamp(), getRandomTimestamp()));
        }
    }

    private void fillCarriage() {
        CarriageDao insertCarriage = new SqlCarriageDao();
        List<Integer> fk_id_route_to_train_time_table = findAllCarriageRouteTrainTimeTable();
        for (Integer integer : fk_id_route_to_train_time_table) {
            insertCarriage.insertCarriage(new Carriage(getRandomString(7), getRandomInteger(),
                    getRandomString(5), integer));
        }
    }

    private void fillPlace() {
        PlaceDao insertPlace = new SqlPlaceDao();
        List<String> id_carriage = findAllCarriage();
        for (String s : id_carriage) {
            insertPlace.insertPlace(new Place(null, getRandomInteger(), s));
        }

    }

    private void fillTicket() {
        TicketDao insertTicket = new SqlTicketDao();
        List<Integer> fk_client_id = findAllClient();
        List<Integer> fk_id_place = findAllPlace();
        int numberRow = fk_client_id.size();
        if(fk_client_id.size() > fk_id_place.size())
            numberRow = fk_id_place.size();
        for(int i = 0; i < numberRow; i++){
            insertTicket.insertTicket(new Ticket(null, fk_client_id.get(i), fk_id_place.get(i),
                    getRandomNumeric(), getRandomTimestamp(), getRandomBoolean()));
        }
    }


    @Override
    public void fillRandomTable(int numberRow) {
        fillClient(numberRow);
        fillRoute(numberRow);
        fillTrain(numberRow);
        fillRouteToTrainTimeTable();
        fillCarriage();
        fillPlace();
        fillTicket();
    }
}

