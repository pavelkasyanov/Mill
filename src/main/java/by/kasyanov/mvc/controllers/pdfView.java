package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pdfView")
public class pdfView {

    @Autowired
    ProducerDAO producerDAO;

    @Autowired
    MillDAO millDAO;

    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public ModelAndView pdfMillView(ModelMap model, @RequestParam("id") int id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("listBooks", producerDAO.getAll());
        params.put("millId", id);
        params.put("millDAO", millDAO);

        return new ModelAndView("millPDFBuilder", params);
    }
}
