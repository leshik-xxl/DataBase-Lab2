package app.model.entities;

import org.postgresql.replication.PGReplicationConnectionImpl;

import java.util.Date;
import java.util.List;

public class Ticket {
    private Integer id;
    private Client client;
    private Place place;
    private Integer price;
    private Date buy_date;
    private String privilege;

    public Ticket(Integer id, Client client, Place place, Integer price, Date buy_date, String privilege) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client.getFull_name() +
                ", place=" + place.getNumber() +
                ", carriage=" + place.getCarriage().getNumber() +
                ", train=" + place.getCarriage().getTrain().getId_train() +
                ", price=" + price +
                ", buy_date=" + buy_date +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
