package app.model.entities;

import java.util.Date;
import java.util.List;

public class Ticket {
    private Integer id;
    private List<Client> clientList;
    private List<Place> placeList;
    private Integer price;
    private Date buy_date;
    private String privilege;

    public Ticket(Integer id, List<Client> clientList, List<Place> placeList,
                  Integer price, Date buy_date, String privilege) {
        this.id = id;
        this.clientList = clientList;
        this.placeList = placeList;
        this.price = price;
        this.buy_date = buy_date;
        this.privilege = privilege;
    }

    public Integer getId() {
        return id;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
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
                ", clientList=" + clientList +
                ", placeList=" + placeList +
                ", price=" + price +
                ", buy_date=" + buy_date +
                ", privilege='" + privilege + '\'' +
                "}\n";
    }
}
