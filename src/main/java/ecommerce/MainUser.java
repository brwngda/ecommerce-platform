package ecommerce;

import ecommerce.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainUser {
    public static void main(String[] args) {

        List<Command> commandList = new ArrayList<>(
                List.of(
                        new AddUser()

                ));
        String command;
        do {
            System.out.println("List of the available commands:");
            for (int i = 0; i < commandList.size(); i++) {


                System.out.println((i + 1) + ". " + commandList.get(i).getCommand());
            }
            System.out.println("Choose one of the above commands");
            command = Command.scanner.nextLine();

            for (Command availableCommand : commandList) {
                if (availableCommand.getCommand().equalsIgnoreCase(command)) {
                    availableCommand.handling();

                    Optional<Command> followUpCommand = availableCommand.getFollowUpCommand();
                    followUpCommand.ifPresent(Command::handling);

                }
            }
        } while (!command.equalsIgnoreCase("exit"));
    }
}

