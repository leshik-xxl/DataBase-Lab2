package app.model.sql;

import app.model.CarriageDao;
import app.model.PlaceDao;
import app.model.entities.Place;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlPlaceDao implements PlaceDao {
    public static final String SQL_FIND_ALL_PLACE = "SELECT * FROM place";

    @Override
    public List<Place> findAllPlace() {
        List<Place> result = new ArrayList<Place>();
        SqlConnection mySqlConnection = SqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_PLACE);
            CarriageDao carriageDao = new SqlCarriageDao();
            while (rs.next()) {
                result.add(new Place(rs.getInt(1), rs.getInt(2),
                        carriageDao.getCarriageById(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
