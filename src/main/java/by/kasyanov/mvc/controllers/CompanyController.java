package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.CompanyDAO;
import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.entities.Company;
import by.kasyanov.mvc.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
