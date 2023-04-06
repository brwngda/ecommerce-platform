package ecommerce.model;

import ecommerce.commands.Command;

import java.util.Optional;

public class AddUser implements Command {
    @Override
    public String getCommand() {
        return "Fill the registration form";
    }

    @Override
    public void handling() {

    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
