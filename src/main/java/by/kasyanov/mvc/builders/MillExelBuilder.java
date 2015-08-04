package by.kasyanov.mvc.builders;

import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.exceptions.ParseExelException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class MillExelBuilder {

    private Mill mill = null;
    private Sheet sheet;
    private int i = 0;

    public Mill build(Sheet sheet, int i) throws ParseExelException{
        mill = new Mill();
        this.sheet = sheet;
        this.i = i;

        setProductId();
        setMillModel();
        setCNC();
        setMillYear();
        setAxis();
        setXYZ();
        setTable();
        setTableWeightMax();
        setSpindleTaper();
        setSpindleSpeedMax();
        setSpindlePower();
        setSpindleTorqueMax();
        setSpindleType();
        setSpindleCooling();
        setToolShoopNumber();
        setToolShoopMaxD();
        setToolShoopWeightMax();
        setToolShoopChangeTime();
        setPositioningAccuracy();
        setPositioningRepeatability();
        setSpindleWorkTime();
        setWorkTime();
        setAdditionalConfiguration();
        setPrice();

        return mill;
    }

    private void setAdditionalConfiguration() throws ParseExelException {
        String additionalConfiguration = this.getParam(27, i);
        mill.setAdditionalConfiguration(additionalConfiguration);
    }

    private void setWorkTime() throws ParseExelException {
        String workTime = this.getParam(26, i);
        try {
            int value = (Double.valueOf(workTime)).intValue();
            mill.setWorkTime(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: workTime(" + workTime + ")");
        }
    }

    private void setPositioningRepeatability() throws ParseExelException {
        String positioningRepeatability = this.getParam(24, i);
        try {
            float value = Float.valueOf(positioningRepeatability);
            mill.setPositioningRepeatability(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: toolShoopChangeTime(" + positioningRepeatability +")");
        }
    }

    private void setPositioningAccuracy() throws ParseExelException {
        String positioningAccuracy = this.getParam(23, i);
        try {
            float value = Float.valueOf(positioningAccuracy);
            mill.setPositioningAccuracy(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: toolShoopChangeTime(" + positioningAccuracy +")");
        }
    }

    private void setToolShoopChangeTime() throws ParseExelException {
        String toolShoopChangeTime = this.getParam(22, i);
        try {
            float value = Float.valueOf(toolShoopChangeTime);
            mill.setToolShoopChangeTime(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: toolShoopChangeTime(" + toolShoopChangeTime +")");
        }
    }

    private void setToolShoopWeightMax() throws ParseExelException {
        String toolShoopWeightMax = this.getParam(21, i);
        try {
            int value = (Double.valueOf(toolShoopWeightMax)).intValue();
            mill.setToolShoopWeightMax(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: toolShoopWeightMax(" + toolShoopWeightMax + ")");
        }
    }

    private void setToolShoopMaxD() throws ParseExelException {
        String toolShoopMaxD = getParam(20, i);
        try {
            int value = (Double.valueOf(toolShoopMaxD)).intValue();
            mill.setToolShoopMaxD(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: toolShoopMaxD(" + toolShoopMaxD + ")");
        }
    }

    private void setSpindleCooling() throws ParseExelException {
        String spindleCooling = getParam(17, i);
        mill.setSpindleCooling(spindleCooling);
    }

    private void setSpindleType() throws ParseExelException {
        String spindleType = getParam(16, i);
        mill.setSpindleType(spindleType);
    }

    private void setSpindleTorqueMax() throws ParseExelException {
        String spindleTorqueMax = this.getParam(15, i);
        try {
            int value = (Double.valueOf(spindleTorqueMax)).intValue();
            mill.setSpindleTorqueMax(value);
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: spindleTorqueMax(" + spindleTorqueMax + ")");
        }
    }

    private void setMillModel() throws ParseExelException {
        String millName = this.getParam(2, i);

        mill.setModel(millName);
    }

    private void setMillYear() throws ParseExelException {
        String millYear = this.getParam(6, i);
        try {
            Double year = Double.valueOf(millYear);
            mill.setYear(year.intValue());
        }catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: mill year(" + millYear + ")");
        }
    }

    private void setCNC() throws ParseExelException {
        String millCNC = this.getParam(5, i);

        mill.setCncType(millCNC);
    }

    private void setAxis() throws ParseExelException {
        String axisStr = this.getParam(8, i);
        try {
            Double axis = Double.valueOf(axisStr);
            mill.setAxisCount(axis.intValue());
        }catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: axis(" + axisStr + ")");
        }

    }

    private void setXYZ() throws ParseExelException {
        String millXYZ = this.getParam(9, i);
        try {
            List<Integer> sizeXYZ = this.parseIntParams(millXYZ, "x");

            mill.setMovingX(sizeXYZ.get(0));
            mill.setMovingY(sizeXYZ.get(1));
            mill.setMovingZ(sizeXYZ.get(2));
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error params: xyz(" + millXYZ + ")");
        }
    }

    private void setTable() throws ParseExelException {
        String millTable = this.getParam(10, i);
        try {
            List<Integer> millTableSize = this.parseIntParams(millTable, "x");

            mill.setTableWidth(millTableSize.get(1));
            mill.setTableLength(millTableSize.get(0));
        }catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: TableWidthHeight(" + ex.getMessage() + ")");
        }
    }

    private void setTableWeightMax() throws ParseExelException {
        String millTableWeightMax = this.getParam(11, i);
        try {
            Double val = Double.valueOf(millTableWeightMax);
            mill.setTableWeightMax(val.intValue());
        }catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: TableWeightMax(" + millTableWeightMax + ")");
        }
    }

    private void setSpindleTaper() throws ParseExelException {
        String spindleTaper = this.getParam(12, i);

        mill.setSpindleTaper(spindleTaper);
    }

    private void setSpindleSpeedMax() throws ParseExelException {
        String millspindleSpeedMax = this.getParam(13, i);
        try {
            Double val = Double.valueOf(millspindleSpeedMax);
            mill.setSpindleSpeedMax(val.intValue());
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: SpindleSpeedMax(" + millspindleSpeedMax + ")");
        }
    }

    private void setSpindlePower() throws ParseExelException {
        String millSpindlePower = this.getParam(14, i);

        mill.setSpindlePower(millSpindlePower);
    }

    private void setToolShoopNumber() throws ParseExelException {
        String millToolShoopNumber = this.getParam(13, i);
        try {
            Double val = Double.valueOf(millToolShoopNumber);
            mill.setToolShoopNumber(val.intValue());
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: ShoopNumber(" + millToolShoopNumber + ")");
        }
    }

    private void setSpindleWorkTime() throws ParseExelException {
        String millSpindleWorkTime = this.getParam(25, i);
        try {
            Double val = Double.valueOf(millSpindleWorkTime);
            mill.setSpindleWorkTime(val.intValue());
        } catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: SpindleWorkTime(" + millSpindleWorkTime + ")");
        }
    }

    private void  setPrice() throws ParseExelException {
        String millPrice = this.getParam(29, i);
        try {
            Double val = Double.valueOf(millPrice);
            mill.setPrice(val.intValue());
        }catch (IllegalArgumentException ex) {
            throw new ParseExelException("error param: Price(" + millPrice + ")");
        }
    }

    private void setProductId() throws ParseExelException {
        String productId = getParam(0, i);
        mill.setProductId(productId);
    }

    public String getParam(int i, int j) throws ParseExelException {
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(j);

        if (cell != null) {
            String str = cell.toString();

            if (str == null || "".equals(str)) {
                throw new ParseExelException("error param in row = " + (++i));
            }

            str = str.trim();

            return str;
        }

        return null;
    }

    public List<Integer> parseIntParams(String params, String separator) throws ParseExelException {
        List<Integer> result = new ArrayList<Integer>();

        for (String str : params.split(separator)) {
            Double temp = Double.valueOf(str);
            result.add(temp.intValue());
        }

        return result;
    }
}
