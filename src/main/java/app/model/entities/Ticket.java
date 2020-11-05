package app.model.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {
    private Integer id;
    private Integer client;
    private Integer place;
    private BigDecimal price;
    private Date buy_date;
    private Boolean privilege;

    public Ticket(Integer id, Integer client, Integer place, BigDecimal price, Date buy_date, Boolean privilege) {
        this.id = id;
        this.client = client;
        this.place = place;
        this.price = price;
        this.buy_date = buy_date;
        this.privilege = privilege;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    public Boolean getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Boolean privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", place=" + place +
                ", price=" + price +
                ", buy_date=" + buy_date +
                ", privilege=" + privilege +
                "}\n";
    }
}
