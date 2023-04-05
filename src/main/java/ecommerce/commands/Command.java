package ecommerce.commands;

import java.util.Optional;
import java.util.Scanner;

public interface Command {
    Scanner scanner = new Scanner(System.in);

    String getCommand();

    void handling();

    Optional<Command> getFollowUpCommand();
}
