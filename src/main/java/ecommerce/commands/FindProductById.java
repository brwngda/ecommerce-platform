package ecommerce.commands;

import ecommerce.database.DataAccessObject;
import ecommerce.model.Product;

import java.util.Optional;

public class FindProductById implements Command {

    DataAccessObject<Product> dao = new DataAccessObject<Product>();

    @Override
    public String getCommand() {
        return "Find product";
    }

    @Override
    public void handling() {
        System.out.println("Enter ID of the product");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);


        Optional<Product> productOptional = dao.find(Product.class, id);
        if (productOptional.isPresent()) {
            System.out.println(productOptional.get());
        } else {
            System.err.println("Record not found");
        }
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
