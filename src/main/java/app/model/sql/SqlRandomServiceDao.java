package app.model.sql;

import app.model.RandomServiceDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
    public static final String SQL_RANDOM_DATE = "'2014-01-10 20:00:00'::timestamp +" +
    "random() * ('2014-01-20 20:00:00'::timestamp -" +
    " '2014-01-10 10:00:00'::timestamp)";

    public static final String SQL_FILL_RANDOM_CLIENT = "INSERT INTO client (email , login, full_name) " +
            "SELECT " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "|| '@gmail.com' " +"," +
             SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " FROM generate_series(1, ?)";

    public static final String SQL_FILL_ROUTE = "INSERT INTO route (place_of_departure, place_of_arrival) " +
            "SELECT" + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " FROM generate_series(1, ?)";

    public static final String SQL_FILL_TRAIN = "INSERT INTO train (id_train, max_carriage) " +
            "SELECT" + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + " || " + SQL_RANDOM_CHAR + "," +
            SQL_RANDOM_INT + " FROM generate_series(1, ?)";
    
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

    @Override
    public void fillRandomTable(int numberRow) {
            fillClient(numberRow);
            fillRoute(numberRow);
            fillTrain(numberRow);

    }
}
