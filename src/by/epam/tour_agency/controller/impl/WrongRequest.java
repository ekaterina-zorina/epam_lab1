package by.epam.tour_agency.controller.impl;

import by.epam.tour_agency.controller.command.Command;

/**
 * Class implements wrong request.
 */
public class WrongRequest implements Command {

    /**
     * Wrong request. If no command is recognized, this command is executed.
     *
     * @param request any unsuitable string
     * @return response
     */
    @Override
    public String execute(String request) {
        return "Wrong request";
    }
}
