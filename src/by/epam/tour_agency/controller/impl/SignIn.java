package by.epam.tour_agency.controller.impl;

import by.epam.tour_agency.bean.AuthorizationInfo;
import by.epam.tour_agency.controller.command.Command;
import by.epam.tour_agency.service.UserService;
import by.epam.tour_agency.service.exception.ServiceException;
import by.epam.tour_agency.service.factory.ServiceFactory;

/**
 * Class implements sign in command.
 */
public class SignIn implements Command {

    /**
     * Authorization.
     *
     * @param request string with the name of the command and its parameters, where
     *                command name: sign_in
     *                parameters: String login
     *                            String password
     * @return response
     */
    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        String response;

        if (params.length != 3) {
            response = "Invalid input format";
            return response;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        AuthorizationInfo authInfo = new AuthorizationInfo(params[1], params[2]);

        try {
            if (userService.signIn(authInfo)) {
                response = "Authorization is successful";
            } else {
                response = "Authorization is failed";
            }
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
