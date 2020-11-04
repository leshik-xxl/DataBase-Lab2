package app.model.entities;

public class Client {
    private Integer id;
    private String e_mail;
    private String login;
    private String full_name;

    public Client(Integer id, String e_mail, String login, String full_name) {
        this.id = id;
        this.e_mail = e_mail;
        this.login = login;
        this.full_name = full_name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public Integer getId() {
        return id;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", e_mail='" + e_mail + '\'' +
                ", login='" + login + '\'' +
                ", full_name='" + full_name + '\'' +
                "}\n";
    }
}
