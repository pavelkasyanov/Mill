package by.kasyanov.mvc.entities;

public class Phone {
    private int id;
    private int companyId;
    private int userId;
    private int operatorId;
    private String number;

    public Phone() {
    }

    public Phone(int id, int companyId, int userId,
                 int operatorId, String number) {
        this.id = id;
        this.companyId = companyId;
        this.userId = userId;
        this.operatorId = operatorId;
        this.number = number;
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

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
