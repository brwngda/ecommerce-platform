package ecommerce.commands;

import java.util.Optional;
import java.util.Scanner;

public interface Command {
    Scanner scanner = new Scanner(System.in);

    String getKomenda();

    void obsluga();

    Optional<Command> getFollowUpCommand();
}
