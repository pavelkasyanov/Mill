package by.kasyanov.mvc.controllers;


import by.kasyanov.mvc.dao.*;
import by.kasyanov.mvc.entities.*;
import by.kasyanov.mvc.services.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mills")
public class MillController {

    @Autowired
    MillService millService;
    @Autowired
    ProducerDAO producerDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    MillDAO millDAO;
    @Autowired
    ImageDAO imageDAO;
    @Autowired
    MillTypeDAO millTypeDAO;
    @Autowired
    ToolShoopTypeDAO toolShoopTypeDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        List<Mill> mills = millService.getAll();
        model.addAttribute("mills", mills);

        List<Producer> producersList = producerDAO.getAll();
        Collections.sort(producersList);
        model.addAttribute("producersList", producersList);

        List<Country> countryList = countryDAO.getAll();
        Collections.sort(countryList);
        model.addAttribute("countryList", countryList);

        Map<Integer, Image> imageMap = millService.getMillsImages();
        model.addAttribute("imageMap", imageMap);

        return "mills";
    }

    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public String getMill(ModelMap model, @RequestParam("id") Integer id,
                          HttpServletRequest request) {

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

        return "mill";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchMills(ModelMap model,
                              @RequestParam("beginYear") String beginYear,
                              @RequestParam("endYear") String endYear,
                              @RequestParam("millProducer") String millProducer,
                              @RequestParam("minLongitudinalTravelX") String minLongitudinalTravelX,
                              @RequestParam("maxLongitudinalTravelX") String maxLongitudinalTravelX,
                              @RequestParam("minTransversalTravelY") String minTransversalTravelY,
                              @RequestParam("maxTransversalTravelY") String maxTransversalTravelY,
                              @RequestParam("minVerticalTravelZ") String minVerticalTravelZ,
                              @RequestParam("maxVerticalTravelZ") String maxVerticalTravelZ,
                              @RequestParam("CNC") String cnc,
                              @RequestParam("minTableLength") String minTableLength,
                              @RequestParam("maxTableLength") String maxTableLength,
                              @RequestParam("minTableWidth") String minTableWidth,
                              @RequestParam("maxTableWidth") String maxTableWidth) {

        int beginYearParam = -1;
        int endYearParam = -1;
        if (beginYear != null && beginYear != "") {
            beginYearParam = Integer.parseInt(beginYear);
        }

        if (endYear != null && endYear != "") {
            endYearParam = Integer.parseInt(endYear);
        }

        int minLongitudinalTravelXParam = -1;
        int maxLongitudinalTravelXParam = -1;
        if (minLongitudinalTravelX != null && !("".equals(minLongitudinalTravelX))) {
            minLongitudinalTravelXParam = Integer.parseInt(minLongitudinalTravelX);
        }
        if (maxLongitudinalTravelX != null && !("".equals(maxLongitudinalTravelX))) {
            maxLongitudinalTravelXParam = Integer.parseInt(maxLongitudinalTravelX);
        }

        int minTransversalTravelYParam = -1;
        int maxTransversalTravelYParam = -1;
        if (minTransversalTravelY != null && !("".equals(minTransversalTravelY))) {
            minTransversalTravelYParam = Integer.parseInt(minTransversalTravelY);
        }
        if (maxTransversalTravelY != null && !("".equals(maxTransversalTravelY))) {
            maxTransversalTravelYParam = Integer.parseInt(maxTransversalTravelY);
        }

        int minVerticalTravelZParam = -1;
        int maxVerticalTravelZParam = -1;
        if (minVerticalTravelZ != null && !("".equals(minVerticalTravelZ))) {
            minVerticalTravelZParam = Integer.parseInt(minVerticalTravelZ);
        }
        if (maxVerticalTravelZ != null && !("".equals(maxVerticalTravelZ))) {
            maxVerticalTravelZParam = Integer.parseInt(maxVerticalTravelZ);
        }

        int minTableLengthParam = -1;
        int maxTableLengthParam = -1;
        if (minTableLength != null && !("".equals(minTableLength))) {
            minTableLengthParam = Integer.parseInt(minTableLength);
        }
        if (maxTableLength != null && !("".equals(maxTableLength))) {
            maxTableLengthParam = Integer.parseInt(maxTableLength);
        }

        int minTableWidthParam = -1;
        int maxTableWidthParam = -1;
        if (minTableWidth != null && !("".equals(minTableWidth))) {
            minTableWidthParam = Integer.parseInt(minTableWidth);
        }
        if (maxTableWidth != null && !("".equals(maxTableWidth))) {
            maxTableWidthParam = Integer.parseInt(maxTableWidth);
        }

        List<Mill> mills = millService.search(beginYearParam, endYearParam, millProducer,
                minLongitudinalTravelXParam, maxLongitudinalTravelXParam,
                minTransversalTravelYParam, maxTransversalTravelYParam,
                minVerticalTravelZParam, maxVerticalTravelZParam,
                cnc,
                minTableLengthParam, maxTableLengthParam,
                minTableWidthParam, maxTableWidthParam);

        model.addAttribute("mills", mills);

        List<Producer> producersList = producerDAO.getAll();
        Collections.sort(producersList);
        model.addAttribute("producersList", producersList);

        List<Country> countryList = countryDAO.getAll();
        Collections.sort(countryList);
        model.addAttribute("countryList", countryList);

        return "mills";
    }

    @RequestMapping(value = "/action/delete/{id}", method = RequestMethod.GET)
    public String deleteMill(@PathVariable("id") Integer id) {

        millDAO.deleteById(id);

        return "redirect:/mills";
    }

    @RequestMapping(value = "/action/add", method = RequestMethod.GET)
    public String addMill(ModelMap model) {
        return "addMill";
    }

    @RequestMapping(value = "/action/add", method = RequestMethod.POST)
    public String addMillFromFile(ModelMap model,
                          @RequestParam("file") MultipartFile file)
    {
        if (!file.isEmpty()) {
            String result = millService.addMillFromFile(file);
            model.addAttribute("addResult", result);
        } else {
          model.addAttribute("addResult", "file is empty");
        }

        return "addMill";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compareMills(ModelMap model,
                                @RequestParam("from") int idFrom,
                                @RequestParam("with") int idWith) {

        return "compareMils";
    }
}
