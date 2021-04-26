package mk.ukim.finki.wpproekt.seminarska.model.exceptions;

public class DeskNotFoundException extends  RuntimeException{

    public DeskNotFoundException(){
        super("Desk not found");
    }
}
