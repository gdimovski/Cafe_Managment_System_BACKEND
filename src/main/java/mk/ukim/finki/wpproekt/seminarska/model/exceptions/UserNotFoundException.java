package mk.ukim.finki.wpproekt.seminarska.model.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User does not exist");
    }
}