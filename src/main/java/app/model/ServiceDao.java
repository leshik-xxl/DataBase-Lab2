package app.model;

import app.model.dto.CarriageTypeFromTo;
import app.model.dto.RouteFromToDepartMore;
import app.model.dto.TicketPricePrivilegeCarriage;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface ServiceDao {
    List<RouteFromToDepartMore> findRouteFromToDepartMore(String arrive, String depart, Timestamp departTime);
    List<CarriageTypeFromTo> findRouteWithTypeCarriage(String placeDepart, String placeArrive, String type);
    List<TicketPricePrivilegeCarriage> findTicketPricePrivilegeCarriage(BigDecimal price, Boolean privilege, Integer carriageNumber);
    void deleteAll();
}
