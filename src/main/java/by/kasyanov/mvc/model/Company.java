package by.kasyanov.mvc.model;

public class Company {
    private int id;
    private String name;
    private String city;
    private int CountryId;
    private String street;
    private String home;
    private String office;
    private int postcode;
    private String description;
    private String site;

    public Company() {
    }

    public Company(int id, String name, String city, int countryId,
                   String street, String home, String office,
                   int postcode, String description, String site) {
        this.id = id;
        this.name = name;
        this.city = city;
        CountryId = countryId;
        this.street = street;
        this.home = home;
        this.office = office;
        this.postcode = postcode;
        this.description = description;
        this.site = site;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
