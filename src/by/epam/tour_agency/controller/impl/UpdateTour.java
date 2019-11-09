package by.epam.tour_agency.controller.impl;

import by.epam.tour_agency.bean.City;
import by.epam.tour_agency.bean.Country;
import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.bean.Vehicle;
import by.epam.tour_agency.controller.command.Command;
import by.epam.tour_agency.service.TourService;
import by.epam.tour_agency.service.exception.ServiceException;
import by.epam.tour_agency.service.factory.ServiceFactory;

/**
 * Class implements update tour command.
 */
public class UpdateTour implements Command {

    /**
     * Update tour.
     *
     * @param request string with the name of the command and its parameters, where
     *                command name: update_tour
     *                parameters: int id
     *                            String city
     *                            String country
     *                            String vehicle (bus, plane, train or ship)
     *                            String departure_date [dd-mm-yyyy]
     *                            String departure_time [hh:mm]
     *                            String arrival_date [dd-mm-yyyy]
     *                            String arrival_time [hh:mm]
     *                            int price
     * @return response
     */
    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        String response;

        if (params.length != 10) {
            response = "Invalid input format";
            return response;
        }

        int id;
        try {
            id = Integer.parseInt(params[1]);
        } catch (NumberFormatException e) {
            response = "Id must be a number";
            return response;
        }

        String cityParam = params[2];
        String countryParam = params[3];
        City city = new City(cityParam, new Country(countryParam));

        String vehicleParam = params[4];
        Vehicle[] vehicles = Vehicle.values();
        Vehicle vehicle = null;
        for (Vehicle vehicle1 : vehicles) {
            if (vehicleParam.equals(vehicle1.getType())) {
                vehicle = vehicle1;
                break;
            }
        }

        if (vehicle == null) {
            response = "Invalid vehicle value";
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TourService tourService = serviceFactory.getTourService();

        try {
            StringBuilder departureParam = new StringBuilder(params[5]).append(" ").append(params[6]);
            StringBuilder arrivalParam = new StringBuilder(params[7]).append(" ").append(params[8]);

            int price = Integer.parseInt(params[9]);

            Tour tour = new Tour(id, city, vehicle, departureParam.toString(), arrivalParam.toString(), price);
            tourService.updateTour(id, tour);
            response = "Tour successfully updated";

        } catch (NumberFormatException e) {
            response = "Price must be a number";
        } catch (ServiceException e) {
            response = "Error during updating tour";
        }

        return response;
    }
}
