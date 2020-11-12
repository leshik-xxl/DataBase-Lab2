package app.model.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TicketPricePrivilegeCarriage {
    private BigDecimal price;
    private Boolean privilege;
    private Timestamp buyDate;
    private String fullName;
    private String placeOfDepart;
    private String placeOfArrive;
    private Timestamp arriveTime;
    private Timestamp departTime;
    private String train;
    private Integer numberCarriage;
    private Integer numberPlace;

    public TicketPricePrivilegeCarriage(BigDecimal price, Boolean privilege,
                                        Timestamp buyDate, String fullName,
                                        String placeOfDepart, String placeOfArrive,
                                        Timestamp arriveTime, Timestamp departTime,
                                        String train, Integer numberCarriage, Integer numberPlace) {
        this.price = price;
        this.privilege = privilege;
        this.buyDate = buyDate;
        this.fullName = fullName;
        this.placeOfDepart = placeOfDepart;
        this.placeOfArrive = placeOfArrive;
        this.arriveTime = arriveTime;
        this.departTime = departTime;
        this.train = train;
        this.numberCarriage = numberCarriage;
        this.numberPlace = numberPlace;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Boolean privilege) {
        this.privilege = privilege;
    }

    public Timestamp getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaceOfDepart() {
        return placeOfDepart;
    }

    public void setPlaceOfDepart(String placeOfDepart) {
        this.placeOfDepart = placeOfDepart;
    }

    public String getPlaceOfArrive() {
        return placeOfArrive;
    }

    public void setPlaceOfArrive(String placeOfArrive) {
        this.placeOfArrive = placeOfArrive;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public Integer getNumberCarriage() {
        return numberCarriage;
    }

    public void setNumberCarriage(Integer numberCarriage) {
        this.numberCarriage = numberCarriage;
    }

    public Integer getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(Integer numberPlace) {
        this.numberPlace = numberPlace;
    }

    @Override
    public String toString() {
        return "TicketPricePrivilegeCarriage{" +
                "price=" + price +
                ", privilege=" + privilege +
                ", buyDate=" + buyDate +
                ", fullName='" + fullName + '\'' +
                ", placeOfDepart='" + placeOfDepart + '\'' +
                ", placeOfArrive='" + placeOfArrive + '\'' +
                ", arriveTime=" + arriveTime +
                ", departTime=" + departTime +
                ", train='" + train + '\'' +
                ", numberCarriage=" + numberCarriage +
                ", numberPlace=" + numberPlace +
                "}\n";
    }
}
