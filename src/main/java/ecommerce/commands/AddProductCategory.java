package ecommerce.commands;

import ecommerce.database.DataAccessObject;
import ecommerce.model.ProductCategory;


import java.util.Optional;

public class AddProductCategory implements Command {

    DataAccessObject<ProductCategory> dao = new DataAccessObject<ProductCategory>();

    @Override
    public String getCommand() {
        return "Add product category";
    }

    @Override
    public void handling() {
        System.out.println("Enter the product name");
        String name = Command.scanner.nextLine();

        System.out.println("Enter the description");
        String description = Command.scanner.nextLine();


        ProductCategory productCategory = ProductCategory.builder()
                .name(name)
                .description(description)
                .build();

        dao.insert(productCategory);
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}

