package by.kasyanov.mvc.builders;

import by.kasyanov.mvc.dao.MillStateDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MillExelBuilder {

    private Mill mill = null;
    private Sheet sheet;
    private int i = 0;

    public Mill build(Sheet sheet, int i) {
        mill = new Mill();
        this.sheet = sheet;
        this.i = i;

        setMillName();
        setMillYear();
        setCNC();
        setAxis();
        setXYZ();
        setTable();
        setTableWeightMax();
        setSpindleSpeedMax();
        setSpindleWorkTime();
        setToolShoopNumber();
        setPrice();
        setImage();
        setSpindleTaper();
        setSpindlePower();

        return mill;
    }

    private void setMillName() {
        String millName = this.getParam(0, i);
        mill.setName(millName);
    }

    private void setMillYear() {
        String millYear = this.getParam(3, i);
        Double year = Double.valueOf(millYear);

        mill.setYear(year.intValue());
    }

    private void setCNC() {
        String millCNC = this.getParam(4, i);

        mill.setCncType(millCNC);
    }

    private void setAxis() {
        String axisStr = this.getParam(5, i);
        Double axis = Double.valueOf(axisStr);

        mill.setAxis(axis.intValue());
    }

    private void setXYZ() {
        String millXYZ = this.getParam(7, i);
        List<Integer> sizeXYZ = this.parseIntParams(millXYZ, "x");

        mill.setSizeX(sizeXYZ.get(0));
        mill.setSizeY(sizeXYZ.get(1));
        mill.setSizeZ(sizeXYZ.get(2));
    }

    private void setTable() {
        String millTable = this.getParam(8, i);
        List<Integer> millTableSize = this.parseIntParams(millTable, "x");

        mill.setTableWidth(millTableSize.get(1));
        mill.setTableLength(millTableSize.get(0));
    }

    private void setTableWeightMax() {
        String millTableWeightMax = this.getParam(9, i);
        Double val = Double.valueOf(millTableWeightMax);

        mill.setTableWeightMax(val.intValue());
    }

    private void setSpindleTaper() {
        String spindleTaper = this.getParam(10, i);

        mill.setSpindleTaper(spindleTaper);
    }

    private void setSpindleSpeedMax() {
        String millspindleSpeedMax = this.getParam(11, i);
        Double val = Double.valueOf(millspindleSpeedMax);

        mill.setSpindleSpeedMax(val.intValue());
    }

    private void setSpindlePower() {
        String millspindleSpeedMax = this.getParam(12, i);
        Float val = Float.valueOf(millspindleSpeedMax);

        mill.setSpindlePower(val);
    }

    private void setToolShoopNumber() {
        String millToolShoopNumber = this.getParam(13, i);
        Double val = Double.valueOf(millToolShoopNumber);

        mill.setToolShoopNumber(val.intValue());
    }

    private void setSpindleWorkTime() {
        String millspindleWorkTime = this.getParam(16, i);
        Double val = Double.valueOf(millspindleWorkTime);

        mill.setSpindleWorkTime(val.intValue());
    }

    private void  setPrice() {
        String millPrice = this.getParam(17, i);
        Double val = Double.valueOf(millPrice);

        mill.setPrice(val.intValue());
    }

    private void setImage() {
        String img = "DMC 1035 V (2006) - 1.jpg";

        mill.setImage(img);
    }

    public String getParam(int i, int j){
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(j);

        if (cell != null) {
            String str = cell.toString();
            str = str.trim();

            return str;
        }

        return null;
    }

    public List<Integer> parseIntParams(String params, String separator) {
        List<Integer> result = new ArrayList<Integer>();

        for (String str : params.split(separator)) {
            Double temp = Double.valueOf(str);
            result.add(temp.intValue());
        }

        return result;
    }
}
