package by.epam.tour_agency.bean.comparators;

import by.epam.tour_agency.bean.User;

import java.util.Comparator;

public class UserSurnameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
