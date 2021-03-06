package by.kasyanov.mvc.entities;

import java.util.Date;

public class Mill {
    private int id;
    private String productId;
    private int millType;
    private String model;
    private int producerId;
    private int countryProducingId;
    private String cncType;
    private int year;
    private int machineLocation;
    private int axisCount;
    private int movingX;
    private int movingY;
    private int movingZ;
    private int tableLength;
    private int tableWidth;
    private int tableWeightMax;
    private String spindleTaper;
    private int spindleSpeedMax;
    private String spindlePower;
    private int spindleTorqueMax;
    private String spindleType;
    private String spindleCooling;
    private int toolShoopType;
    private int toolShoopNumber;
    private int toolShoopMaxD;
    private int toolShoopWeightMax;
    private float toolShoopChangeTime;
    private float positioningAccuracy;
    private float positioningRepeatability;
    private int spindleWorkTime;
    private int workTime;
    private String additionalConfiguration;
    private int millStateId;
    private int price;
    private Date addedDate;
    private int addedById;

    public Mill() {
    }

    public Mill(int id, String productId, int millType, String model, int producerId,
                int countryProducingId, String cncType, int year, int machineLocation,
                int axisCount, int movingX, int movingY, int movingZ, int tableLength,
                int tableWidth, int tableWeightMax, String spindleTaper, int spindleSpeedMax,
                String spindlePower, int spindleTorqueMax, String spindleType, String spindleCooling,
                int toolShoopType, int toolShoopNumber, int toolShoopMaxD, int toolShoopWeightMax,
                float toolShoopChangeTime, float positioningAccuracy, float positioningRepeatability,
                int spindleWorkTime, int workTime, String additionalConfiguration, int millStateId,
                int price, Date addedDate, int addedById) {
        this.id = id;
        this.productId = productId;
        this.millType = millType;
        this.model = model;
        this.producerId = producerId;
        this.countryProducingId = countryProducingId;
        this.cncType = cncType;
        this.year = year;
        this.machineLocation = machineLocation;
        this.axisCount = axisCount;
        this.movingX = movingX;
        this.movingY = movingY;
        this.movingZ = movingZ;
        this.tableLength = tableLength;
        this.tableWidth = tableWidth;
        this.tableWeightMax = tableWeightMax;
        this.spindleTaper = spindleTaper;
        this.spindleSpeedMax = spindleSpeedMax;
        this.spindlePower = spindlePower;
        this.spindleTorqueMax = spindleTorqueMax;
        this.spindleType = spindleType;
        this.spindleCooling = spindleCooling;
        this.toolShoopType = toolShoopType;
        this.toolShoopNumber = toolShoopNumber;
        this.toolShoopMaxD = toolShoopMaxD;
        this.toolShoopWeightMax = toolShoopWeightMax;
        this.toolShoopChangeTime = toolShoopChangeTime;
        this.positioningAccuracy = positioningAccuracy;
        this.positioningRepeatability = positioningRepeatability;
        this.spindleWorkTime = spindleWorkTime;
        this.workTime = workTime;
        this.additionalConfiguration = additionalConfiguration;
        this.millStateId = millStateId;
        this.price = price;
        this.addedDate = addedDate;
        this.addedById = addedById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getMillType() {
        return millType;
    }

    public void setMillType(int millType) {
        this.millType = millType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public int getCountryProducingId() {
        return countryProducingId;
    }

    public void setCountryProducingId(int countryProducingId) {
        this.countryProducingId = countryProducingId;
    }

    public String getCncType() {
        return cncType;
    }

    public void setCncType(String cncType) {
        this.cncType = cncType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMachineLocation() {
        return machineLocation;
    }

    public void setMachineLocation(int machineLocation) {
        this.machineLocation = machineLocation;
    }

    public int getAxisCount() {
        return axisCount;
    }

    public void setAxisCount(int axisCount) {
        this.axisCount = axisCount;
    }

    public int getMovingX() {
        return movingX;
    }

    public void setMovingX(int movingX) {
        this.movingX = movingX;
    }

    public int getMovingY() {
        return movingY;
    }

    public void setMovingY(int movingY) {
        this.movingY = movingY;
    }

    public int getMovingZ() {
        return movingZ;
    }

    public void setMovingZ(int movingZ) {
        this.movingZ = movingZ;
    }

    public int getTableLength() {
        return tableLength;
    }

    public void setTableLength(int tableLength) {
        this.tableLength = tableLength;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    public void setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
    }

    public int getTableWeightMax() {
        return tableWeightMax;
    }

    public void setTableWeightMax(int tableWeightMax) {
        this.tableWeightMax = tableWeightMax;
    }

    public String getSpindleTaper() {
        return spindleTaper;
    }

    public void setSpindleTaper(String spindleTaper) {
        this.spindleTaper = spindleTaper;
    }

    public int getSpindleSpeedMax() {
        return spindleSpeedMax;
    }

    public void setSpindleSpeedMax(int spindleSpeedMax) {
        this.spindleSpeedMax = spindleSpeedMax;
    }

    public String getSpindlePower() {
        return spindlePower;
    }

    public void setSpindlePower(String spindlePower) {
        this.spindlePower = spindlePower;
    }

    public int getSpindleTorqueMax() {
        return spindleTorqueMax;
    }

    public void setSpindleTorqueMax(int spindleTorqueMax) {
        this.spindleTorqueMax = spindleTorqueMax;
    }

    public String getSpindleType() {
        return spindleType;
    }

    public void setSpindleType(String spindleType) {
        this.spindleType = spindleType;
    }

    public String getSpindleCooling() {
        return spindleCooling;
    }

    public void setSpindleCooling(String spindleCooling) {
        this.spindleCooling = spindleCooling;
    }

    public int getToolShoopType() {
        return toolShoopType;
    }

    public void setToolShoopType(int toolShoopType) {
        this.toolShoopType = toolShoopType;
    }

    public int getToolShoopNumber() {
        return toolShoopNumber;
    }

    public void setToolShoopNumber(int toolShoopNumber) {
        this.toolShoopNumber = toolShoopNumber;
    }

    public int getToolShoopMaxD() {
        return toolShoopMaxD;
    }

    public void setToolShoopMaxD(int toolShoopMaxD) {
        this.toolShoopMaxD = toolShoopMaxD;
    }

    public int getToolShoopWeightMax() {
        return toolShoopWeightMax;
    }

    public void setToolShoopWeightMax(int toolShoopWeightMax) {
        this.toolShoopWeightMax = toolShoopWeightMax;
    }

    public float getToolShoopChangeTime() {
        return toolShoopChangeTime;
    }

    public void setToolShoopChangeTime(float toolShoopChangeTime) {
        this.toolShoopChangeTime = toolShoopChangeTime;
    }

    public float getPositioningAccuracy() {
        return positioningAccuracy;
    }

    public void setPositioningAccuracy(float positioningAccuracy) {
        this.positioningAccuracy = positioningAccuracy;
    }

    public float getPositioningRepeatability() {
        return positioningRepeatability;
    }

    public void setPositioningRepeatability(float positioningRepeatability) {
        this.positioningRepeatability = positioningRepeatability;
    }

    public int getSpindleWorkTime() {
        return spindleWorkTime;
    }

    public void setSpindleWorkTime(int spindleWorkTime) {
        this.spindleWorkTime = spindleWorkTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getAdditionalConfiguration() {
        return additionalConfiguration;
    }

    public void setAdditionalConfiguration(String additionalConfiguration) {
        this.additionalConfiguration = additionalConfiguration;
    }

    public int getMillStateId() {
        return millStateId;
    }

    public void setMillStateId(int millStateId) {
        this.millStateId = millStateId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getAddedById() {
        return addedById;
    }

    public void setAddedById(int addedById) {
        this.addedById = addedById;
    }
}
