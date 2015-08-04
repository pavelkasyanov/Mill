package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.CompanyDAO;
import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.entities.Company;
import by.kasyanov.mvc.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    CountryDAO countryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model)
    {
        List<Company> companyList = companyDAO.getAll();
        model.addAttribute("companyList", companyList);

        List<Country> countryList = countryDAO.getAll();
        Collections.sort(countryList);
        model.addAttribute("countryList", countryList);

        return "companies";
    }

    @RequestMapping(value = "/company/{id}")
    public String getCompany(ModelMap model,
                             @PathVariable("id") int id) {

        Company company = companyDAO.getById(id);
        model.addAttribute("company", company);

        Country country = countryDAO.getById(company.getCountryId());
        model.addAttribute("country", country);

        return "company";
    }

    @RequestMapping(value = "/company/{id}.json", method = RequestMethod.GET)
    public @ResponseBody Company getCompanyJson(
                            @PathVariable("id") int id) {

        Company company = companyDAO.getById(id);

        return company;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCompanyPage(ModelMap model) {

        model.addAttribute("countyList", countryDAO.getAll());

        return "addCompany";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompany(ModelMap model,
                             @RequestParam("name") String name,
                             @RequestParam("county_id") int countryId,
                             @RequestParam("city") String city,
                             @RequestParam("street") String street,
                             @RequestParam("home") String home,
                             @RequestParam("office") String office,
                             @RequestParam("postcode") int postcode,
                             @RequestParam("site") String site,
                             @RequestParam("description") String description) {


        Company company = new Company();
        company.setName(name);
        company.setCountryId(countryId);
        company.setCity(city);
        company.setStreet(street);
        company.setHome(home);
        company.setOffice(office);
        company.setPostcode(postcode);
        company.setSite(site);
        company.setDescription(description);

        companyDAO.insert(company);

        return "addCompany";
    }
}
