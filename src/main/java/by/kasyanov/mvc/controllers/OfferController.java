package by.kasyanov.mvc.controllers;

import by.kasyanov.mvc.dao.*;
import by.kasyanov.mvc.entities.*;
import by.kasyanov.mvc.services.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    MillService millService;
    @Autowired
    ImageDAO imageDAO;
    @Autowired
    MillTypeDAO millTypeDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ToolShoopTypeDAO toolShoopTypeDAO;
    @Autowired
    CompanyDAO companyDAO;
    @Autowired
    CompanyEmployeeDAO companyEmployeeDAO;

    public String index(ModelMap model) {
        return "offers";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createOffer(ModelMap model,
                              @RequestParam("from") int id) {

        Mill mill = millService.getById(id);
        model.addAttribute("mill", mill);

        Producer producer = millService.getProducerForMill(mill.getId());
        model.addAttribute("millProducer", producer);

        List<Image> images = imageDAO.getImagesFromMill(mill.getId());
        model.addAttribute("millImages", images);

        MillType millType = millTypeDAO.getById(mill.getMillType());
        model.addAttribute("millType", millType);

        Country countryProducing = countryDAO.getById(mill.getCountryProducingId());
        model.addAttribute("countryProducing", countryProducing);

        Country countryMachineLocation = countryDAO.getById(mill.getMachineLocation());
        model.addAttribute("countryMachineLocation", countryMachineLocation);

        ToolShoopType toolShoopType = toolShoopTypeDAO.getById(mill.getToolShoopType());
        model.addAttribute("toolShoopType", toolShoopType);

        MillState millState = millService.getMillState(mill.getId());
        model.addAttribute("millState", millState);

        List<Company> companies = companyDAO.getAll();
        model.addAttribute("companies", companies);

        return "offer";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView buildOffer(ModelMap model,
                                   @RequestParam("millId") int millId,
                                   @RequestParam("companyName") String companyName,
                                   @RequestParam("directorName") String directorName){

        Map<String, Object> params = new ConcurrentHashMap<String, Object>();

        Mill mill = millService.getById(millId);
        params.put("mill", mill);

        params.put("companyName", companyName);
        params.put("directorName", directorName);

        return new ModelAndView("", null);
    }
}
