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
 * Class implements create tour command.
 */
public class CreateTour implements Command {

    /**
     * Create new tour.
     *
     * @param request string with the name of the command and its parameters, where
     *                command name: create_tour
     *                parameters: String city
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

        if (params.length != 9) {
            response = "Invalid input format";
            return response;
        }

        String cityParam = params[1];
        String countryParam = params[2];
        City city = new City(cityParam, new Country(countryParam));

        String vehicleParam = params[3];
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
            int id = serviceFactory.getIdGenerator().nextId();

            StringBuilder departureParam = new StringBuilder(params[4]).append(" ").append(params[5]);
            StringBuilder arrivalParam = new StringBuilder(params[6]).append(" ").append(params[7]);

            int price = Integer.parseInt(params[8]);

            Tour tour = new Tour(id, city, vehicle, departureParam.toString(), arrivalParam.toString(), price);
            tourService.createTour(tour);
            response = "Tour successfully added";

        } catch (NumberFormatException e) {
            response = "Price must be a number";
        } catch (ServiceException e) {
            response = "Error during adding tour";
        }

        return response;
    }
}
