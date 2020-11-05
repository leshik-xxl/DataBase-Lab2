package app.model.entities;

public class Train {
    private String id_train;
    private Integer max_carriage;

    public Train(String id_train, Integer max_carriage) {
        this.id_train = id_train;
        this.max_carriage = max_carriage;
    }

    public String getId_train() {
        return id_train;
    }

    public void setId_train(String id_train) {
        this.id_train = id_train;
    }

    public Integer getMax_carriage() {
        return max_carriage;
    }

    public void setMax_carriage(Integer max_carriage) {
        this.max_carriage = max_carriage;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id_train='" + id_train + '\'' +
                ", max_carriage=" + max_carriage +
                "}\n";
    }
}
