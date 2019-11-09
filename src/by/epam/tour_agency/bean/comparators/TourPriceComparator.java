package by.epam.tour_agency.bean.comparators;

import by.epam.tour_agency.bean.Tour;

import java.util.Comparator;

public class TourPriceComparator implements Comparator<Tour> {

    @Override
    public int compare(Tour o1, Tour o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
