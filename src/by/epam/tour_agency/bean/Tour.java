package by.epam.tour_agency.bean;

import java.io.Serializable;

public class Tour implements Serializable, Comparable<Tour> {
    private int id;
    private City city;
    private Vehicle vehicle;
    private String departureTime;
    private String arrivalTime;
    private int price;

    public Tour() { }

    public Tour(int id, City city, Vehicle vehicle, String departureTime, String arrivalTime, int price) {
        this.id = id;
        this.city = city;
        this.vehicle = vehicle;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tour tour = (Tour) o;

        if (id != tour.id) {
            return false;
        }
        if (price != tour.price) {
            return false;
        }
        if (city != null ? !city.equals(tour.city) : tour.city != null) {
            return false;
        }
        if (vehicle != tour.vehicle) {
            return false;
        }
        if (departureTime != null ? !departureTime.equals(tour.departureTime) : tour.departureTime != null)
        {
            return false;
        }

        return arrivalTime != null ? arrivalTime.equals(tour.arrivalTime) : tour.arrivalTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", city=" + city +
                ", vehicle=" + vehicle +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Tour anotherTour) {
        return this.id - anotherTour.getId();
    }
}
