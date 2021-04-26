package mk.ukim.finki.wpproekt.seminarska.model.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Product not found");
    }
}
