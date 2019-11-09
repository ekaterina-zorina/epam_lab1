package by.epam.tour_agency.controller.impl;

import by.epam.tour_agency.bean.Tour;
import by.epam.tour_agency.controller.command.Command;
import by.epam.tour_agency.service.TourService;
import by.epam.tour_agency.service.exception.ServiceException;
import by.epam.tour_agency.service.factory.ServiceFactory;

/**
 * Class implements read tour command.
 */
public class ReadTour implements Command {

    /**
     * Read tour.
     *
     * @param request string with the name of the command and its parameters, where
     *                command name: read_tour
     *                parameters: int id
     * @return response
     */
    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        String response;

        if (params.length != 2) {
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

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TourService tourService = serviceFactory.getTourService();

        try {
            Tour tour = tourService.readTour(id);

            if (tour != null) {
                StringBuilder resultStr = new StringBuilder(String.valueOf(id));
                resultStr.append(" ").append(tour.getCity().getName());
                resultStr.append(" ").append(tour.getVehicle());
                resultStr.append(" ").append(tour.getDepartureTime());
                resultStr.append(" ").append(tour.getArrivalTime());
                resultStr.append(" ").append(tour.getPrice());

                response = resultStr.toString();

            } else {
                response = "There is no tour with such id";
            }

        } catch (ServiceException e) {
            response = "Error during reading tour";
        }

        return response;
    }
}
