package by.epam.tour_agency.dao.impl;

import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.dao.TourDAO;
import by.epam.tour_agency.dao.exception.DAOException;
import by.epam.tour_agency.dao.util.XMLSerializer;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to access a file with tours.
 */
public class FileTourDAO implements TourDAO {

    private String path = "resources\\tours.xml";

    /**
     * Add all tours from list to file.
     *
     * @param tour tour to add
     * @throws DAOException if file cannot be found
     */
    @Override
    public void addTour(Tour tour) throws DAOException {
        ArrayList<Tour> tours = readTours();
        tours.add(tour);

        try (XMLSerializer serializer = new XMLSerializer(path)) {
            serializer.serialize(tours);
        } catch (FileNotFoundException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Add all tours from list to file.
     *
     * @param tours list of tours to add
     * @throws DAOException if file cannot be found
     */
    @Override
    public void addAllTours(List<Tour> tours) throws DAOException {
        try (XMLSerializer serializer = new XMLSerializer(path)) {
            serializer.serialize(tours);
        } catch (FileNotFoundException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Read all tours from file.
     *
     * @return list of read tours or empty list if there are no tours
     * @throws DAOException if file cannot be found
     */
    @Override
    public ArrayList<Tour> readTours() throws DAOException {
        ArrayList<Tour> tours;

        File file = new File(path);
        if (file.length() == 0) {
            return new ArrayList<>();
        }

        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            tours = (ArrayList<Tour>)decoder.readObject();
        } catch (FileNotFoundException e) {
            throw new DAOException(e.getMessage());
        }

        return tours;
    }

    /**
     * Delete tour from file.
     *
     * @param tourId tour id
     * @throws DAOException if file cannot be found
     */
    @Override
    public void deleteTour(int tourId) throws DAOException {
        ArrayList<Tour> tours = readTours();

        for (Tour tour : tours) {
            if (tour.getId() == tourId) {
                tours.remove(tour);

                try (XMLSerializer serializer = new XMLSerializer(path)) {
                    serializer.serialize(tours);
                } catch (FileNotFoundException e) {
                    throw new DAOException(e.getMessage());
                }

                return;
            }
        }
    }

    /**
     * Find a tour by its id.
     *
     * @param tourId tour id
     * @return tour if found or null if not
     * @throws DAOException if file cannot be found
     */
    @Override
    public Tour findTourById(int tourId) throws DAOException {
        ArrayList<Tour> tours = readTours();

        for (Tour tour : tours) {
            if (tour.getId() == tourId) {
                return tour;
            }
        }

        return null;
    }

    /**
     * Gets id of last tour in file, so that in the future each tour has a unique id.
     *
     * @return id of the last tour
     * @throws DAOException if file cannot be found
     */
    @Override
    public int lastId() throws DAOException {
        ArrayList<Tour> tours = readTours();

        if (tours.size() > 0) {
            return tours.get(tours.size() - 1).getId();
        }

        return 0;
    }
}
