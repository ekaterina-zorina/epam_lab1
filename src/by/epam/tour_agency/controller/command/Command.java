package by.epam.tour_agency.controller.command;

/**
 * Common interface of all commands.
 */
public interface Command {
    /**
     * Execute command.
     *
     * @param request string with the name of the command and its parameters
     * @return command result
     */
    String execute(String request);
}
