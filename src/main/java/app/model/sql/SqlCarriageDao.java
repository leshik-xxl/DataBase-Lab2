package app.model.sql;

import app.model.CarriageDao;
import app.model.entities.Carriage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlCarriageDao implements CarriageDao {

    public static final String SQL_FIND_ALL_CARRIAGE = "SELECT * FROM carriage";
    public static final String SQL_INSERT_CARRIAGE = "INSERT INTO carriage (type, number, id_carriage, fk_route_to_train_time_table) " +
            "VALUES (?, ?, ?, ?)";

    @Override
    public List<Carriage> findAllCarriage() {
        List<Carriage> result = new ArrayList<Carriage>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_CARRIAGE);
            while (rs.next()) {
                result.add(new Carriage(rs.getString(1), rs.getInt(2),
                        rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertCarriage(Carriage carriage) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_CARRIAGE);
            ps.setString(1, carriage.getType());
            ps.setInt(2, carriage.getNumber());
            ps.setString(3, carriage.getId());
            ps.setInt(4, carriage.getRouteToTrainTimeTable());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
