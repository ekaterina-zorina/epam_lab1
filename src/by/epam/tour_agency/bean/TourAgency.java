package by.epam.tour_agency.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TourAgency implements Serializable {
    private String name;
    private List<Tour> tours = new ArrayList<>();

    public TourAgency() { }

    public TourAgency(String name, List<Tour> tours) {
        this.name = name;
        this.tours = tours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TourAgency that = (TourAgency) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return tours != null ? tours.equals(that.tours) : that.tours == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tours != null ? tours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TourAgency{" +
                "name='" + name + '\'' +
                ", tours=" + tours +
                '}';
    }
}
