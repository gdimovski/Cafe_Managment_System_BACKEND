package mk.ukim.finki.wpproekt.seminarska.model.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){
        super("Order was not found");
    }
}
