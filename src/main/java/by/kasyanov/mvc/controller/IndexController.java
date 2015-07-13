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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        if (logout != null) {
            //model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("index");

        return model;

    }

    @RequestMapping(value = "/error403_1", method = RequestMethod.GET)
    public String error() {
        return "error403";
    }
}
