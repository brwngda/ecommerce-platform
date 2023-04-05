package ecommerce.commands;

import ecommerce.model.Product;
import ecommerce.database.DataAccessObject;

import java.util.Optional;

public class DeleteProduct implements Command {
    DataAccessObject<Product> dao = new DataAccessObject<Product>();


    @Override
    public String getCommand() {
        return "Delete product";
    }

    @Override
    public void handling() {
        System.out.println("Enter ID of the product");
        String idString = Command.scanner.nextLine();
        Long id =Long.parseLong(idString);

        if(dao.delete(Product.class, id)) {
            System.out.println("Product has been deleted");
        } else {
            System.err.println("Something went wrong");
        }
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
