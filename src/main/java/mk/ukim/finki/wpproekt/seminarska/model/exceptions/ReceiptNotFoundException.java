package mk.ukim.finki.wpproekt.seminarska.model.exceptions;

public class ReceiptNotFoundException extends RuntimeException{

    public ReceiptNotFoundException(){
        super("Receipt not found");
    }
}
