package by.kasyanov.mvc.controllers;


import by.kasyanov.mvc.dao.CountryDAO;
import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.entities.Country;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.Producer;
import by.kasyanov.mvc.services.MillService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

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

        return "mills";
    }

    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public String getMill(ModelMap model, @RequestParam("id") Integer id,
                          HttpServletRequest request) {

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

    @RequestMapping(value = "/action/add", method = RequestMethod.GET)
    public String addMill(ModelMap model) {
        return "addMill";
    }

    @RequestMapping(value = "/action/add", method = RequestMethod.POST)
    @ResponseBody
    public String addMill(@RequestParam("file") MultipartFile file)
    {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
               Mill mIll = millService.parseData(workbook);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "file add";
    }
}
