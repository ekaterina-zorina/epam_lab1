package by.epam.tour_agency.controller.impl;

import by.epam.tour_agency.controller.command.Command;
import by.epam.tour_agency.service.TourService;
import by.epam.tour_agency.service.exception.ServiceException;
import by.epam.tour_agency.service.factory.ServiceFactory;

/**
 * Class implements delete tour command.
 */
public class DeleteTour implements Command {

    /**
     * Delete tour.
     *
     * @param request string with the name of the command and its parameters, where
     *                command name: delete_tour
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
            tourService.deleteTour(id);
            response = "Tour successfully deleted";
        } catch (ServiceException e) {
            response = "Error during deleting tour";
        }

        return response;
    }
}
