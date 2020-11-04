import app.model.CarriageDao;
import app.model.ClientDao;
import app.model.PlaceDao;
import app.model.sql.SqlCarriageDao;
import app.model.sql.SqlClientDao;
import app.model.sql.SqlPlaceDao;

public class Main {
    public static void main(String[] args) {
        ClientDao test = new SqlClientDao();
        System.out.println(test.findAllClient());
        System.out.println("\n\n\n");
        CarriageDao testCarriage = new SqlCarriageDao();
        System.out.println(testCarriage.findAllCarriage());
        System.out.println("\n\n\n");
        PlaceDao testPlace = new SqlPlaceDao();
        System.out.println(testPlace.findAllPlace());
    }

}
