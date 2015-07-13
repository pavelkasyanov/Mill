package by.kasyanov.mvc.entities;

public class Skype {
    private int id;
    private int companyId;
    private int userId;
    private String skypeLogin;

    public Skype() {
    }

    public Skype(int id, int companyId, int userId, String skypeLogin) {
        this.id = id;
        this.companyId = companyId;
        this.userId = userId;
        this.skypeLogin = skypeLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSkypeLogin() {
        return skypeLogin;
    }

    public void setSkypeLogin(String skypeLogin) {
        this.skypeLogin = skypeLogin;
    }
}
