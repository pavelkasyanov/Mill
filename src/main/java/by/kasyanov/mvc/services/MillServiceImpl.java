package by.kasyanov.mvc.services;

import by.kasyanov.mvc.Models.MillModel;
import by.kasyanov.mvc.builders.MillExelBuilder;
import by.kasyanov.mvc.dao.*;
import by.kasyanov.mvc.entities.*;
import by.kasyanov.mvc.exceptions.ModelMappingExeption;
import by.kasyanov.mvc.exceptions.ParseExelException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MillServiceImpl implements MillService {

    @Autowired
    MillDAO millDAO;
    @Autowired
    ProducerDAO producerDAO;
    @Autowired
    MillStateDAO millStateDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ImageDAO imageDAO;
    @Autowired
    MillTypeDAO millTypeDAO;
    @Autowired
    ToolShoopTypeDAO toolShoopTypeDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public void insert(Mill mill) {
        millDAO.insert(mill);
    }

    @Override
    public Mill getById(int id) {
        return millDAO.getById(id);
    }

    @Override
    public void update(Mill mill) {
        millDAO.update(mill);
    }

    @Override
    public void deleteById(int id) {
        millDAO.deleteById(id);
    }

    @Override
    public List<Mill> getAll() {
        return millDAO.getAll();
    }

    @Override
    public Producer getProducerForMill(int millId) {
        return producerDAO.getById(millDAO.getById(millId).getProducerId());
    }

    @Override
    public List<Mill> search(int beginYear, int endYear, String producerName,
                             int minLongitudinalTravelX,
                             int maxLongitudinalTravelX,
                             int minTransversalTravelY,
                             int maxTransversalTravelY,
                             int minVerticalTravelZ,
                             int maxVerticalTravelZ,
                             String cnc,
                             int minTableLength,
                             int maxTableLength,
                             int minTableWidth,
                             int maxTableWidth) {
        List<Mill> mills  = null;

        if (beginYear == -1) {
            beginYear = 0;
        }

        if (endYear == -1) {
            endYear = (Calendar.getInstance().get(Calendar.YEAR) + 1);
        }

        mills = millDAO.sortByManufactureDate(beginYear, endYear);

        //if (mills  == null) return mills;

        if (producerName != null && producerName != "") {
            mills = this.selectByProducer(mills, producerName);
        }
        if (maxLongitudinalTravelX == -1) {
            maxLongitudinalTravelX = Integer.MAX_VALUE;
        }
        mills = this.selectByLongitudinalTravelX(mills, minLongitudinalTravelX, maxLongitudinalTravelX);

        if (maxTransversalTravelY == -1) {
            maxTransversalTravelY = Integer.MAX_VALUE;
        }
        mills = this.selectByTransversalTravelY(mills, minTransversalTravelY, maxTransversalTravelY);

        if (maxVerticalTravelZ == -1) {
            maxVerticalTravelZ = Integer.MAX_VALUE;
        }
        mills = this.selectByTransversalTravelZ(mills, minVerticalTravelZ, maxVerticalTravelZ);

        if (maxTableLength == -1) {
            maxTableLength = Integer.MAX_VALUE;
        }
        mills = this.selectByTableLength(mills, minTableLength, maxTableLength);

        if (cnc != null && !"".equals(cnc)) {
            mills = selectByCnc(mills, cnc);
        }

        if (maxTableWidth == -1) {
            maxTableWidth = Integer.MAX_VALUE;
        }
        mills = this.selectByTableWidth(mills, minTableWidth, maxTableWidth);

        return mills;
    }

    @Override
    public MillState getMillState(int MillId) {
        return millStateDAO.getById(millDAO.getById(MillId).getMillStateId());
    }

    private List<Mill> selectByProducer(List<Mill> millList, String producerName) {

        final Producer producer = producerDAO.getByName(producerName);

        List<Mill> result = new ArrayList<Mill>();

        for(Mill item : millList) {
            if (item.getProducerId() == producer.getId()) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByLongitudinalTravelX(List<Mill> millList, int minParam, int maxParam) {

        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getMovingX() >= minParam && item.getMovingX() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTransversalTravelY(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getMovingY() >= minParam && item.getMovingY() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTransversalTravelZ(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getMovingZ() >= minParam && item.getMovingZ() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByCnc(List<Mill> millList, String cnc) {
        List<Mill> result = new ArrayList<Mill>();
        cnc = cnc.trim();
        for(Mill item : millList) {
            if (item.getCncType().equalsIgnoreCase(cnc)) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTableWidth(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getTableWidth() >= minParam && item.getTableWidth() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTableLength(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getTableLength() >= minParam && item.getTableLength() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public String addMillFromFile(MultipartFile file) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            MillExelBuilder millExelBuilder = new MillExelBuilder();

            Sheet sheet = workbook.getSheetAt(0);
            Mill mill = millExelBuilder.build(sheet, 1);

            String millTypeStr = millExelBuilder.getParam(1, 1);
            MillType millType = millTypeDAO.getByName(millTypeStr);
            mill.setMillType(millType.getId());

            String producerStr = millExelBuilder.getParam(3, 1);
            Producer producer = producerDAO.getByName(producerStr);
            mill.setProducerId(producer.getId());

            String countryProducingStr = millExelBuilder.getParam(4, 1);
            Country countryProducing = countryDAO.getByName(countryProducingStr);
            mill.setCountryProducingId(countryProducing.getId());

            String machineLocationStr = millExelBuilder.getParam(7, 1);
            Country machineLocation = countryDAO.getByName(machineLocationStr);
            mill.setMachineLocation(machineLocation.getId());

            String toolShoopTypeStr = millExelBuilder.getParam(18, 1);
            ToolShoopType toolShoopType = toolShoopTypeDAO.getByName(toolShoopTypeStr);
            mill.setToolShoopType(toolShoopType.getId());

            String millStateStr = millExelBuilder.getParam(28, 1);
            MillState millState = millStateDAO.getByName(millStateStr);
            mill.setMillStateId(millState.getId());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            User user = userDAO.getByName(userName);
            mill.setAddedById(user.getId());

            int millId = millDAO.insert(mill);

            String millImages = millExelBuilder.getParam(30, 1);
            String[] imagesStr = millImages.split("\n");
            for(String imgSrc:imagesStr) {
                Image image = new Image();
                image.setMillId(millId);
                image.setSrc(imgSrc);

                imageDAO.insert(image);
            }

            String str = "123";
            return "Machine successfully added";

        }catch (ParseExelException ex) {
            return "error adding: " + ex.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "unknown error adding";
        }
    }

    @Override
    public Map<Integer, Image> getMillsImages() {
        Map<Integer, Image> imageMap = new ConcurrentHashMap<Integer, Image>();

        List<Mill> mills = this.getAll();
        for(Mill mill : mills) {
            Image image = imageDAO.getImagesFromMill(mill.getId()).get(0);
            imageMap.put(mill.getId(), image);
        }

        return imageMap;
    }

    @Override
    public MillModel getMillModelById(int millId) throws ModelMappingExeption {
        Mill mill = millDAO.getById(millId);
        if (mill == null) {
            throw new ModelMappingExeption("mill(id=" + millId + ") not found");
        }

        MillType millType = millTypeDAO.getById(mill.getMillType());
        if (millType == null){
            throw new ModelMappingExeption("millType(id=" + mill.getMillType() + ") not found");
        }

        MillState millState = millStateDAO.getById(mill.getMillStateId());
        if (millState == null) {
            throw new ModelMappingExeption("millState(id=" + mill.getMillStateId() + ") not found");
        }

        Producer producer = producerDAO.getById(mill.getProducerId());
        if (producer == null) {
            throw new ModelMappingExeption("producer(id=" + mill.getProducerId() + ") not found");
        }

        Country countryProducing = countryDAO.getById(mill.getCountryProducingId());
        if (countryProducing == null) {
            throw new ModelMappingExeption("countryProducing(id=" + mill.getCountryProducingId() + ") not found");
        }

        Country machineLocation = countryDAO.getById(mill.getMachineLocation());
        if (machineLocation == null) {
            throw new ModelMappingExeption("machineLocation(id=" + mill.getMachineLocation() + ") not found");
        }

        ToolShoopType toolShoopType = toolShoopTypeDAO.getById(mill.getToolShoopType());
        if (toolShoopType == null) {
            throw new ModelMappingExeption("toolShoopType(id=" + mill.getToolShoopType() + ") not found");
        }
        List<Image> imageList = imageDAO.getImagesFromMill(millId);
        if (imageList == null) {
            throw new ModelMappingExeption("images from mill(id=" + mill.getToolShoopType() + ") not found");
        }

        MillModel model = new MillModel();

        model.setId(mill.getId());
        model.setProductId(mill.getProductId());
        model.setMillType(millType);
        model.setModel(mill.getModel());
        model.setProducer(producer);
        model.setCountryProducing(countryProducing);
        model.setCncType(mill.getCncType());
        model.setYear(mill.getYear());

        model.setMachineLocation(machineLocation);
        model.setAxisCount(mill.getAxisCount());
        model.setMovingX(mill.getMovingX());
        model.setMovingY(mill.getMovingY());
        model.setMovingZ(mill.getMovingZ());
        model.setTableLength(mill.getTableLength());
        model.setTableWidth(mill.getTableWidth());
        model.setTableWeightMax(mill.getToolShoopWeightMax());
        model.setSpindleTaper(mill.getSpindleTaper());
        model.setSpindleSpeedMax(mill.getSpindleSpeedMax());
        model.setSpindlePower(mill.getSpindlePower());
        model.setSpindleTorqueMax(mill.getSpindleTorqueMax());
        model.setSpindleType(mill.getSpindleType());
        model.setSpindleCooling(mill.getSpindleCooling());

        model.setToolShoopType(toolShoopType);
        model.setToolShoopNumber(mill.getToolShoopNumber());
        model.setToolShoopMaxD(mill.getToolShoopMaxD());
        model.setToolShoopWeightMax(mill.getToolShoopWeightMax());
        model.setToolShoopChangeTime(mill.getToolShoopChangeTime());
        model.setPositioningAccuracy(mill.getPositioningAccuracy());
        model.setPositioningRepeatability(mill.getPositioningRepeatability());
        model.setSpindleWorkTime(mill.getSpindleWorkTime());
        model.setWorkTime(mill.getWorkTime());
        model.setAdditionalConfiguration(mill.getAdditionalConfiguration());

        model.setMillState(millState);
        model.setPrice(mill.getPrice());
        model.setAddedDate(mill.getAddedDate());
        model.setAddedById(mill.getAddedById());

        model.setImages(imageList);

        return model;
    }
}
