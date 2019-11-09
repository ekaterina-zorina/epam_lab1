package by.epam.tour_agency.service.util;

import by.epam.tour_agency.dao.TourDAO;
import by.epam.tour_agency.dao.exception.DAOException;
import by.epam.tour_agency.dao.factory.DAOFactory;
import by.epam.tour_agency.service.exception.ServiceException;

/**
 * Class for generating unique tour's id, implements singleton pattern.
 */
public class TourIdGenerator {
    private static final TourIdGenerator instance = new TourIdGenerator();

    public static TourIdGenerator getInstance() {
        return instance;
    }

    /**
     * Method get last tour id from DAO, and then increment it.
     *
     * @return new tour id
     * @throws ServiceException if DAOException has occurred
     */
    public int nextId() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TourDAO tourDAO = daoFactory.getTourDAO();

        try {
            int lastId = tourDAO.lastId();
            return lastId + 1;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
