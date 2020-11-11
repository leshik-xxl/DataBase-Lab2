package app.model;

import app.model.dto.TicketWithLessPricePrivilegeIsCarriageNumberLess;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceDao {
    List<TicketWithLessPricePrivilegeIsCarriageNumberLess> findTicketWithLessPricePrivilegeIsCarriageNumberLess(BigDecimal price, Boolean privilege, Integer carriageNumber);
}
