import app.controller.Controller;
import app.model.*;
import app.model.sql.*;
import app.view.ConsoleViewer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleViewer());
        controller.appDo();
    }

}
