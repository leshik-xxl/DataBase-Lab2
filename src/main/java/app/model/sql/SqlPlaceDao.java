package app.model.sql;

import app.model.CarriageDao;
import app.model.PlaceDao;
import app.model.entities.Carriage;
import app.model.entities.Place;
import app.model.entities.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlPlaceDao implements PlaceDao {
    public static final String SQL_GET_CARRIAGE_NAME = "SELECT * FROM carriage WHERE id_carriage = ?" ;
    public static final String SQL_FIND_ALL_PLACE = "SELECT * FROM place";

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
                        getCarriageName(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Carriage getCarriageName(String id) {
        Carriage result = new Carriage(null, null, null, null);
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_GET_CARRIAGE_NAME);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            CarriageDao carriageDao = new SqlCarriageDao();
            while (rs.next()) {
                result = new Carriage(rs.getString(1), rs.getInt(2),
                        rs.getString(3), carriageDao.getTrainName(rs.getString(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
