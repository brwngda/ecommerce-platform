package ecommerce;

import ecommerce.commands.AddProduct;
import ecommerce.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        List<Command> listaKomend = new ArrayList<>(
                List.of(
                        new AddProduct()
                )
        );
        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {


                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println("Podaj komende:");
            komenda = Command.scanner.nextLine();

            for (Command dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();

                    Optional<Command> followUpCommand = dostepnaKomenda.getFollowUpCommand();
                    followUpCommand.ifPresent(Command::obsluga);
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
