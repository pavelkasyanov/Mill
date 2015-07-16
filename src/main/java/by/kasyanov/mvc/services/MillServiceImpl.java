package by.kasyanov.mvc.services;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.dao.ProducerDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import by.kasyanov.mvc.entities.Producer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MillServiceImpl implements MillService {

    @Autowired
    MillDAO millDAO;
    @Autowired
    ProducerDAO producerDAO;

    @Autowired
    MillStateDAO millStateDAO;

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
    public boolean addMillFromFile(MultipartFile file) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            break;
                        case Cell.CELL_TYPE_STRING:
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
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
            if (item.getSizeX() >= minParam && item.getSizeX() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTransversalTravelY(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getSizeY() >= minParam && item.getSizeY() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByTransversalTravelZ(List<Mill> millList, int minParam, int maxParam) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getSizeZ() >= minParam && item.getSizeZ() <= maxParam) {
                result.add(item);
            }
        }

        return result;
    }

    private List<Mill> selectByCnc(List<Mill> millList, String cnc) {
        List<Mill> result = new ArrayList<Mill>();
        for(Mill item : millList) {
            if (item.getCncType().equals(cnc)) {
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
}
