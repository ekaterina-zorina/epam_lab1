package by.epam.tour_agency.controller;

import by.epam.tour_agency.controller.command.Command;
import by.epam.tour_agency.controller.command.CommandName;
import by.epam.tour_agency.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class implements access to commands by its names.
 */
public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.CREATE_TOUR, new CreateTour());
        repository.put(CommandName.READ_TOUR, new ReadTour());
        repository.put(CommandName.UPDATE_TOUR, new UpdateTour());
        repository.put(CommandName.DELETE_TOUR, new DeleteTour());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    /**
     * Get command by name.
     *
     * @param name command name
     * @return Command object
     */
    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
