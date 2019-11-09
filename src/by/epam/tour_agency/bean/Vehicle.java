package by.epam.tour_agency.bean;


public enum Vehicle {
    BUS("bus"),
    PLANE("plane"),
    TRAIN("train"),
    SHIP("ship");

    private String type;

    private Vehicle(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
