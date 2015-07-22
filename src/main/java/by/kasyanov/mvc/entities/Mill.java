package by.kasyanov.mvc.entities;

public class Mill {
    private int id;
    private String name;
    private int producerId;
    private int year;
    private String cncType;
    private int axis;
    private int millStateId;
    private int price;
    private String image;
    private boolean specialOffer;
    private String description;
    private int countryProducingId;

    private int sizeX;
    private int sizeY;
    private int sizeZ;

    private float speedUpX;
    private float speedUpY;
    private float speedUpZ;

    private int spindleSpeedMax;
    private String spindleTaper;
    private float spindlePower;
    private int spindleTorqueMax;
    private String spindleCooling;
    private int spindleWorkTime;

    private int tableLength;
    private int tableWidth;
    private int tableWeightMax;

    private int toolShoopNumber;
    private int toolShoopMaxD;
    private int toolShoopWeightMax;
    private float toolShoopChangeTime;

    private float positioningAccuracy;
    private float positioningRepeatability;


    public Mill() {
    }

    public Mill(int id, String name, int producerId,
                int year, String cncType, int axis,
                int millStateId, int price, String image,
                boolean specialOffer, String description, int countryProducingId,
                int sizeX, int sizeY, int sizeZ,
                float speedUpX, float speedUpY, float speedUpZ,
                int spindleSpeedMax, String spindleTaper, float spindlePower,
                int spindleTorqueMax, String spindleCooling, int spindleWorkTime,
                int tableLength, int tableWidth, int tableWeightMax,
                int toolShoopNumber, int toolShoopMaxD, int toolShoopWeightMax,
                float toolShoopChangeTime, float positioningAccuracy, float positioningRepeatability) {
        this.id = id;
        this.name = name;
        this.producerId = producerId;
        this.year = year;
        this.cncType = cncType;
        this.axis = axis;
        this.millStateId = millStateId;
        this.price = price;
        this.image = image;
        this.specialOffer = specialOffer;
        this.description = description;
        this.countryProducingId = countryProducingId;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.speedUpX = speedUpX;
        this.speedUpY = speedUpY;
        this.speedUpZ = speedUpZ;
        this.spindleSpeedMax = spindleSpeedMax;
        this.spindleTaper = spindleTaper;
        this.spindlePower = spindlePower;
        this.spindleTorqueMax = spindleTorqueMax;
        this.spindleCooling = spindleCooling;
        this.spindleWorkTime = spindleWorkTime;
        this.tableLength = tableLength;
        this.tableWidth = tableWidth;
        this.tableWeightMax = tableWeightMax;
        this.toolShoopNumber = toolShoopNumber;
        this.toolShoopMaxD = toolShoopMaxD;
        this.toolShoopWeightMax = toolShoopWeightMax;
        this.toolShoopChangeTime = toolShoopChangeTime;
        this.positioningAccuracy = positioningAccuracy;
        this.positioningRepeatability = positioningRepeatability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCncType() {
        return cncType;
    }

    public void setCncType(String cncType) {
        this.cncType = cncType;
    }

    public int getAxis() {
        return axis;
    }

    public void setAxis(int axis) {
        this.axis = axis;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountryProducingId() {
        return countryProducingId;
    }

    public void setCountryProducingId(int countryProducingId) {
        this.countryProducingId = countryProducingId;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(int sizeZ) {
        this.sizeZ = sizeZ;
    }

    public float getSpeedUpX() {
        return speedUpX;
    }

    public void setSpeedUpX(float speedUpX) {
        this.speedUpX = speedUpX;
    }

    public float getSpeedUpY() {
        return speedUpY;
    }

    public void setSpeedUpY(float speedUpY) {
        this.speedUpY = speedUpY;
    }

    public float getSpeedUpZ() {
        return speedUpZ;
    }

    public void setSpeedUpZ(float speedUpZ) {
        this.speedUpZ = speedUpZ;
    }

    public int getSpindleSpeedMax() {
        return spindleSpeedMax;
    }

    public void setSpindleSpeedMax(int spindleSpeedMax) {
        this.spindleSpeedMax = spindleSpeedMax;
    }

    public String getSpindleTaper() {
        return spindleTaper;
    }

    public void setSpindleTaper(String spindleTaper) {
        this.spindleTaper = spindleTaper;
    }

    public float getSpindlePower() {
        return spindlePower;
    }

    public void setSpindlePower(float spindlePower) {
        this.spindlePower = spindlePower;
    }

    public int getSpindleTorqueMax() {
        return spindleTorqueMax;
    }

    public void setSpindleTorqueMax(int spindleTorqueMax) {
        this.spindleTorqueMax = spindleTorqueMax;
    }

    public String getSpindleCooling() {
        return spindleCooling;
    }

    public void setSpindleCooling(String spindleCooling) {
        this.spindleCooling = spindleCooling;
    }

    public int getSpindleWorkTime() {
        return spindleWorkTime;
    }

    public void setSpindleWorkTime(int spindleWorkTime) {
        this.spindleWorkTime = spindleWorkTime;
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
}
