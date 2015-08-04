package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.builders.MillPDFBuilder;
import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.services.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.concurrent.ConcurrentHashMap;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = (authentication != null &&
                !(authentication instanceof AnonymousAuthenticationToken) &&
                authentication.isAuthenticated());

        Map<String, Object> params = new ConcurrentHashMap<String, Object>();
        params.put("isAuthenticated", isAuthenticated);
        params.put("millModel", millService.getMillModelById(id));
        params.put("PdfBuilderImpl", new MillPDFBuilder());

        return new ModelAndView("millPDFBuilder", params);
    }
}
