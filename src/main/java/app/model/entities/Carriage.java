package app.model.entities;

public class Carriage {
    private Integer id;
    private String type;
    private Integer number;

    public Carriage(Integer id, String type, Integer number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
