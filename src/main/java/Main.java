import app.model.ClientDao;
import app.model.sql.SqlClientDao;

public class Main {
    public static void main(String[] args) {
        ClientDao test = new SqlClientDao();
        System.out.println(test.findAllClient());
    }

}
