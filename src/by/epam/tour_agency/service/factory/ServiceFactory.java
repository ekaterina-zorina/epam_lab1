package by.epam.tour_agency.service.factory;

import by.epam.tour_agency.service.TourService;
import by.epam.tour_agency.service.UserService;
import by.epam.tour_agency.service.impl.TourServiceImpl;
import by.epam.tour_agency.service.impl.UserServiceImpl;
import by.epam.tour_agency.service.util.TourIdGenerator;

/**
 * Class of service factory, implements singleton pattern.
 */
public class ServiceFactory {
    private TourIdGenerator idGenerator;
    {
        idGenerator = TourIdGenerator.getInstance();
    }

    private static final ServiceFactory instance = new ServiceFactory();

    private final TourService tourService = new TourServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TourService getTourService() {
        return tourService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TourIdGenerator getIdGenerator() {
        return idGenerator;
    }
}
