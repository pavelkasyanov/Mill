package by.kasyanov.mvc.controllers;


import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.Producer;
import by.kasyanov.mvc.services.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/mills")
public class MillController {

    @Autowired
    MillService millService;

    @Autowired
    ProducerDAO producerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        List<Mill> mills = millService.getAll();
        model.addAttribute("mills", mills);

        List<Producer> producersList = producerDAO.getAll();

        Collections.sort(producersList);

        model.addAttribute("producersList", producersList);

        return "mills";
    }

    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public String getMill(ModelMap model, @RequestParam("id") Integer id) {

        Mill mill = millService.getById(id);
        Producer producer = millService.getProducerForMill(mill.getId());

        model.addAttribute("mill", mill);
        model.addAttribute("millProducer", producer);

        return "mill";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchMills(ModelMap model,
                              @RequestParam("beginYear") String beginYear,
                              @RequestParam("endYear") String endYear,
                              @RequestParam("millProducer") String millProducer) {

        int beginYearParam = -1;
        int endYearParam = -1;

        if (beginYear != null && beginYear != "") {
            beginYearParam = Integer.parseInt(beginYear);
        }

        if (endYear != null && endYear != "") {
            endYearParam = Integer.parseInt(endYear);
        }

        List<Mill> mills = millService.search(beginYearParam, endYearParam, millProducer);

        model.addAttribute("mills", mills);

        List<Producer> producersList = producerDAO.getAll();
        model.addAttribute("producersList", producersList);

        return "mills";
    }
}
