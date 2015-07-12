package by.kasyanov.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mills")
public class MillController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "mills";
    }
}
