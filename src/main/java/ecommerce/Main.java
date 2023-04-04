package ecommerce;

import ecommerce.commands.AddProduct;
import ecommerce.commands.Command;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Command> commandList = new ArrayList<>(
                List.of(
                        new AddProduct()
                        //new ProductList()
                ));
        String command;
        do {
            System.out.println("List of the available commands:");
            for (int i = 0; i < commandList.size(); i++) {


                System.out.println((i + 1) + ". " + commandList.get(i).getKomenda());
            }
            System.out.println("Choose one of the above commands");
            command = Command.scanner.nextLine();

            for (Command availableCommand : commandList) {
                if (availableCommand.getKomenda().equalsIgnoreCase(command)) {
                    availableCommand.obsluga();

                    Optional<Command> followUpCommand = availableCommand.getFollowUpCommand();
                    followUpCommand.ifPresent(Command::obsluga);

                }
            }
        } while (!command.equalsIgnoreCase("exit"));
    }
}