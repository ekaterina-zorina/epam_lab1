package by.epam.tour_agency.dao.factory;

import by.epam.tour_agency.dao.TourDAO;
import by.epam.tour_agency.dao.UserDAO;
import by.epam.tour_agency.dao.impl.FileTourDAO;
import by.epam.tour_agency.dao.impl.FileUserDAO;

/**
 * Class of DAO factory, implements singleton pattern.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO fileUserImpl = new FileUserDAO();
    private final TourDAO fileTourImpl = new FileTourDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }

    public TourDAO getTourDAO() {
        return fileTourImpl;
    }
}
