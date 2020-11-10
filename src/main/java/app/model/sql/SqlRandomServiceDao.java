package app.model.sql;

import app.model.*;
import app.model.entities.*;

import java.sql.*;
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
    public static final String SQL_RANDOM_DATE = "'2020-01-10 20:00:00'::timestamp + " +
            "random() * ('2020-01-20 20:00:00'::timestamp - '2020-01-10 10:00:00'::timestamp)";

    public static final String SQL_SELECT_ID_ROUTE = "SELECT id_route FROM route";
    public static final String SQL_SELECT_ID_TRAIN = "SELECT id_train FROM train";
    public static final String SQL_SELECT_ID_ROUTE_TO_TRAIN_TIME_TABLE = "SELECT id_route_to_train FROM route_to_train_time_table";
    public static final String SQL_SELECT_ID_CARRIAGE = "SELECT id_carriage FROM carriage";
    public static final String SQL_SELECT_ID_PLACE = "SELECT id_place FROM place";
    public static final String SQL_SELECT_ID_CLIENT = "SELECT id_client FROM client";

    public static final String SQL_SELECT_FK_ROUTE = "SELECT r.id_route FROM route AS r LEFT OUTER JOIN route_to_train_time_table AS rtt " +
            "ON r.id_route = rtt.id_route WHERE rtt.id_route IS NULL";

    public static final String SQL_SELECT_FK_TRAIN = "SELECT t.id_train FROM train AS t LEFT OUTER JOIN route_to_train_time_table AS rtt " +
            "ON t.id_train = rtt.id_train WHERE rtt.id_train IS NULL";

    public static final String SQL_FILL_RANDOM_CLIENT = "INSERT INTO client (email , login, full_name) " +
            "SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "|| '@gmail.com' " + "," +
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
            "SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " ," + SQL_RANDOM_INT + " , " +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + ", " + "?";

    public static final String SQL_FILL_PLACE = "INSERT INTO place (number_place, carriage_id) SELECT " + SQL_RANDOM_INT + ", ?";

    public static final String SQL_FILL_TICKET = "INSERT INTO ticket (fk_client_id, fk_id_place, price, buy_date, privillege) " +
            "SELECT " + "? , ? , " + SQL_RANDOM_NUMERIC + " , " + SQL_RANDOM_DATE + ", ?";

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

    private String getRandomString(int characters){
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < characters; i++){
            if(getRandomChar() != null) strBuild.append(getRandomChar());
        }
        return String.valueOf(strBuild);
    }

    private Integer getRandomInteger(){
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement randomInt = connection.createStatement();
            ResultSet rs = randomInt.executeQuery("SELECT " + SQL_RANDOM_INT);
            rs.next();

            Integer res = rs.getInt(1);
            System.out.println(res);
            return res;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


        private void fillClient ( int numberRow){
            ClientDao insertClient = new SqlClientDao();
            for (int i = 0; i < numberRow; i++) {
                insertClient.insertClient(new Client(null, getRandomString(9) + "@gmail.com", getRandomString(7),
                        getRandomString(7) + " " + getRandomString(8)));
            }
        }

        private void fillRoute ( int numberRow){
            RouteDao insertRoute = new SqlRouteDao();
            for(int i = 0; i < numberRow;i++){
                insertRoute.insertRoute(new Route(null, getRandomString(20), getRandomString(20)));
            }
        }

        private void fillTrain ( int numberRow){
            TrainDao insertTrain = new SqlTrainDao();
            for(int i = 0; i < numberRow; i++){
                insertTrain.InsertTrain(new Train(getRandomString(5), getRandomInteger()));
            }
        }

        private List<Integer> findAllRouteAvailableRouteId(){
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
            System.out.println(result);
            return result;
        }

    private List<String> findAllRouteAvailableTrainId(){
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
        System.out.println(result);
        return result;
    }

        private void fillRouteToTrainTimeTable ( int numberRow){
            RouteToTrainTimeTableDao insertRouteToTrainTimeTable = new SqlRouteToTrainTimeTableDao();
            List<Integer> id_route = findAllRouteAvailableRouteId();
            List<String> id_train = findAllRouteAvailableTrainId();
            for(int i = 0; i < numberRow; i++){
                insertRouteToTrainTimeTable.insertRouteToTrainTimeTable(new RouteToTrainTimeTable(null, id_route.get(numberRow),
                        id_train.get(numberRow), ));
            }
        }

        private void fillCarriage ( int numberRow){
            SqlConnection mySqlConnection = SqlConnection.getInstance();
            Connection connection = mySqlConnection.getConnection();
            try {
                Statement queryRouteToTrainTimeTable = connection.createStatement();
                ResultSet rsRouteToTrainTimeTable = queryRouteToTrainTimeTable.executeQuery(SQL_SELECT_ID_ROUTE_TO_TRAIN_TIME_TABLE);

                for (int i = 0; i < numberRow; i++) {
                    rsRouteToTrainTimeTable.next();
                    PreparedStatement ps = connection.prepareStatement(SQL_FILL_CARRIAGE);
                    ps.setInt(1, rsRouteToTrainTimeTable.getInt(1));
                    ps.executeUpdate();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void fillPlace ( int numberRow){
            SqlConnection mySqlConnection = SqlConnection.getInstance();
            Connection connection = mySqlConnection.getConnection();
            try {
                Statement queryCarriage = connection.createStatement();
                ResultSet rsCarriage = queryCarriage.executeQuery(SQL_SELECT_ID_CARRIAGE);

                for (int i = 0; i < numberRow; i++) {
                    rsCarriage.next();
                    PreparedStatement ps = connection.prepareStatement(SQL_FILL_PLACE);
                    ps.setString(1, rsCarriage.getString(1));
                    ps.executeUpdate();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void fillTicket ( int numberRow){
            SqlConnection mySqlConnection = SqlConnection.getInstance();
            Connection connection = mySqlConnection.getConnection();
            try {
                Statement queryClient = connection.createStatement();
                ResultSet rsClient = queryClient.executeQuery(SQL_SELECT_ID_CLIENT);

                Statement queryPlace = connection.createStatement();
                ResultSet rsPlace = queryPlace.executeQuery(SQL_SELECT_ID_PLACE);
                Boolean privilege;

                for (int i = 0; i < numberRow; i++) {
                    if (((int) Math.random() * 2) == 0)
                        privilege = false;
                    else privilege = true;
                    rsClient.next();
                    rsClient.next();
                    rsPlace.next();
                    PreparedStatement ps = connection.prepareStatement(SQL_FILL_TICKET);
                    ps.setInt(1, rsClient.getInt(1));
                    ps.setInt(2, rsPlace.getInt(1));
                    ps.setBoolean(3, privilege);
                    ps.executeUpdate();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        @Override
        public void fillRandomTable ( int numberRow){
        findAllRouteAvailableRouteId();
//        getRandomInteger();
//            fillClient(numberRow);
//        fillRoute(numberRow);
//        fillTrain(numberRow);
//        fillRouteToTrainTimeTable(numberRow);
//        fillCarriage(numberRow);
//        fillPlace(numberRow);
//        fillTicket(numberRow);
        }
    }

