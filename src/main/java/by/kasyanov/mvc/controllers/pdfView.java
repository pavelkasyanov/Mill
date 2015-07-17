package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.services.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pdfView")
public class pdfView {

    @Autowired
    ProducerDAO producerDAO;

    @Autowired
    MillDAO millDAO;

    @Autowired
    MillService millService;

    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public ModelAndView pdfMillView(ModelMap model, @RequestParam("id") int id,
                                    HttpServletRequest request) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("millId", id);
        params.put("millDAO", millDAO);
        //params.put("imagePath", request.getSession().getServletContext().getRealPath("/resources/jpg/"));
        params.put("producer", millService.getProducerForMill(id));
        params.put("millState", millService.getMillState(id));

        return new ModelAndView("millPDFBuilder", params);
    }
}
