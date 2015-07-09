package by.kasyanov.mvc.controller;

import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.dao.UserDAO;
import by.kasyanov.mvc.model.Country;
import by.kasyanov.mvc.model.User;
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

    @Autowired
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        Country country = countryDAO.getById(5);
        //countryDAO.insert(country);

        List<Country> countryList = countryDAO.getAll();

        countryList.add(country);

        List<User> users = userDAO.getAll();

        model.addAttribute("message", "Hello world!");
        model.addAttribute("users", users);

        return "index";
    }
}
