package app.model.sql;

import app.model.PlaceDao;
import app.model.entities.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlPlaceDao implements PlaceDao {
    public static final String SQL_FIND_ALL_PLACE = "SELECT * FROM place";
    public static final String SQL_INSERT_PLACE = "INSERT INTO place (number_place, carriage_id) " +
            "VALUES (?, ?, ?)";

    public static final String SQL_DELETE_PLACE_BY_ID = "DELETE FROM place WHERE id_place = ?";



    @Override
    public List<Place> findAllPlace() {
        List<Place> result = new ArrayList<Place>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_PLACE);
            while (rs.next()) {
                result.add(new Place(rs.getInt(1), rs.getInt(2),
                        rs.getString(3)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void insertPlace(Place place) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PLACE);
            ps.setInt(1, place.getNumber());
            ps.setString(2, place.getCarriage());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePlace(Integer id) {
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_PLACE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
