package by.epam.tour_agency.dao;

import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.dao.exception.DAOException;

import java.util.List;

/**
 * Interface to access Tour DAO.
 */
public interface TourDAO {
    /**
     * Add tour to DAO.
     *
     * @param tour tour to add
     * @throws DAOException
     */
    void addTour(Tour tour) throws DAOException;

    /**
     * Add all tours from list to DAO.
     *
     * @param tours list of tours to add
     * @throws DAOException
     */
    void addAllTours(List<Tour> tours) throws DAOException;

    /**
     * Read all tours from DAO.
     *
     * @return list of read tours or empty list if there are no tours
     * @throws DAOException
     */
    List<Tour> readTours() throws DAOException;

    /**
     * Delete tour from DAO.
     *
     * @param tourId tour id
     * @throws DAOException
     */
    void deleteTour(int tourId) throws DAOException;

    /**
     * Find a tour by its id.
     *
     * @param tourId tour id
     * @return tour if found or null if not
     * @throws DAOException
     */
    Tour findTourById(int tourId) throws DAOException;

    /**
     * Gets id of last tour in DAO, so that in the future each tour has a unique id.
     *
     * @return id of the last tour
     * @throws DAOException
     */
    int lastId() throws DAOException;
}
