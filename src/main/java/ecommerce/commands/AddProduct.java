package ecommerce.commands;

import ecommerce.database.DataAccessObject;
import ecommerce.model.Gender;
import ecommerce.model.Product;
import ecommerce.model.Size;

import java.util.Optional;

public class AddProduct implements Command {

    DataAccessObject<Product> dao = new DataAccessObject<Product>();

    @Override
    public String getKomenda() {
        return "Add product";
    }

    @Override
    public void obsluga() {
        System.out.println("Enter the product name");
        String name = Command.scanner.nextLine();

        System.out.println("Enter the description");
        String description = Command.scanner.nextLine();

        System.out.println("Enter the size  (XS/S/M/L/XL/XXL)");
        String sizeString = Command.scanner.nextLine();
        Size size = Size.valueOf(sizeString.toUpperCase());

        System.out.println("Enter the gender (BABY/BOY/GIRL/MEN/WOMEN)");
        String genderString = Command.scanner.nextLine();
        Gender gender = Gender.valueOf(genderString.toUpperCase());

        System.out.println("Enter the price");
        String priceString = Command.scanner.nextLine();
        double price = Double.parseDouble(priceString);


        Product product = Product.builder()
                .name(name)
                .description(description)
                .size(size)
                .gender(gender)
                .price(price)
                .build();

        dao.insert(product);
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
