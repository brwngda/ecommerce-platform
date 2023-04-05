package ecommerce.commands;

import ecommerce.model.Product;
import ecommerce.database.DataAccessObject;

import java.util.List;
import java.util.Optional;

public class ListProduct implements Command {
    DataAccessObject<Product> dao = new DataAccessObject<Product>();

    @Override
    public String getKomenda() {
        return "Product list";
    }

    @Override
    public void obsluga() {
        List<Product> products = dao.findAll(Product.class);
        products.forEach(System.out::println);
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
