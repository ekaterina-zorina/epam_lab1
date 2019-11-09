package by.epam.tour_agency.controller;

import by.epam.tour_agency.controller.command.Command;

/**
 * Class implements control layer.
 */
public class Controller {
    private static final Controller instance = new Controller();
    private final CommandProvider provider = new CommandProvider();

    public static Controller getInstance() {
        return instance;
    }

    /**
     * Execute task.
     *
     * @param request string with command name and parameters
     * @return response
     */
    public String executeTask(String request) {
        String[] params = request.split(" ");
        String commandName = params[0];
        Command executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
