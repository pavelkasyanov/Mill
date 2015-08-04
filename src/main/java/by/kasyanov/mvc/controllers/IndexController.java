package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.dao.CompanyEmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    CompanyEmployeeDAO companyEmployeeDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public ModelAndView authorization(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
            model.setViewName("login");
        }

        if (logout != null) {
            model.setViewName("redirect");
        }

        return model;

    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
}
