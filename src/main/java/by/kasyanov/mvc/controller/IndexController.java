package by.kasyanov.mvc.controller;

import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    CountryDAO countryDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<Country> countryList = countryDAO.getAll();

        model.addAttribute("message", "Hello world!");
        model.addAttribute("countryList", countryList);

        return "index";
    }
}
