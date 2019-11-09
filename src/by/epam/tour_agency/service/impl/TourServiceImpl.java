package by.epam.tour_agency.service.impl;

import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.dao.TourDAO;
import by.epam.tour_agency.dao.exception.DAOException;
import by.epam.tour_agency.dao.factory.DAOFactory;
import by.epam.tour_agency.service.TourService;
import by.epam.tour_agency.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Class implements logic of CRUD operations.
 */
public class TourServiceImpl implements TourService {

    /**
     * Create tour.
     *
     * @param tour tour to create
     * @throws ServiceException if DAOException has occurred
     */
    @Override
    public void createTour(Tour tour) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TourDAO tourDAO = daoFactory.getTourDAO();
            tourDAO.addTour(tour);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Read tour.
     *
     * @param tourId tour id
     * @return read tour or null if tour with such id doesn't exist
     * @throws ServiceException if id < 0 or DAOException has occurred
     */
    @Override
    public Tour readTour(int tourId) throws ServiceException {
        if (tourId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TourDAO tourDAO = daoFactory.getTourDAO();
            Tour tour = tourDAO.findTourById(tourId);

            return tour;

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Update tour.
     *
     * @param tourId id of updated tour
     * @param newTour new tour
     * @throws ServiceException if id < 0 or DAOException has occurred
     */
    @Override
    public void updateTour(int tourId, Tour newTour) throws ServiceException {
        if (tourId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TourDAO tourDAO = daoFactory.getTourDAO();
            ArrayList<Tour> tours = (ArrayList<Tour>)tourDAO.readTours();

            for (Tour tour : tours) {
                if (tour.getId() == tourId) {

                    tour.setCity(newTour.getCity());
                    tour.setVehicle(newTour.getVehicle());
                    tour.setDepartureTime(newTour.getDepartureTime());
                    tour.setArrivalTime(newTour.getArrivalTime());
                    tour.setPrice(newTour.getPrice());

                    tourDAO.addAllTours(tours);
                    return;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Delete tour.
     *
     * @param tourId id of deleted tour
     * @throws ServiceException if id < 0 or DAOException has occurred
     */
    @Override
    public void deleteTour(int tourId) throws ServiceException {
        if (tourId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TourDAO tourDAO = daoFactory.getTourDAO();
            tourDAO.deleteTour(tourId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
