package by.epam.tour_agency.service;

import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.service.exception.ServiceException;

/**
 * Interface defines logic of CRUD operations.
 */
public interface TourService {

    /**
     * Create tour.
     *
     * @param tour tour to create
     * @throws ServiceException
     */
    void createTour(Tour tour) throws ServiceException;

    /**
     * Read tour.
     *
     * @param tourId tour id
     * @return read tour or null if tour with such id doesn't exist
     * @throws ServiceException
     */
    Tour readTour(int tourId) throws ServiceException;

    /**
     * Update tour.
     *
     * @param tourId id of updated tour
     * @param newTour new tour
     * @throws ServiceException
     */
    void updateTour(int tourId, Tour newTour) throws ServiceException;

    /**
     * Delete tour.
     *
     * @param tourId id of deleted tour
     * @throws ServiceException
     */
    void deleteTour(int tourId) throws ServiceException;
}
