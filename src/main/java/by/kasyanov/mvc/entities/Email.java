package by.kasyanov.mvc.entities;

public class Email {
    private int id;
    private int companyId;
    private int userId;
    private String email;

    public Email() {
    }

    public Email(int id, int companyId, int userId, String email) {
        this.id = id;
        this.companyId = companyId;
        this.userId = userId;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
