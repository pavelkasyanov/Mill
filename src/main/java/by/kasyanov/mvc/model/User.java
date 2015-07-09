package by.kasyanov.mvc.model;

public class User {
    private int id;
    private String firstName;
    private String surName;
    private String patronymic;
    private int companyId;

    public User() {
    }

    public User(int id, String firstName, String surName,
                String patronymic, int companyId) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.patronymic = patronymic;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ", firstName:" + this.firstName + ", surName:" + this.surName + ", patronymic" +
                this.patronymic + ", companyId:" + this.companyId;
    }
}
