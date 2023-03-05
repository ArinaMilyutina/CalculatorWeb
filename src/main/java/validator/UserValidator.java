package validator;

public class UserValidator {
    private static final String USERNAME = "^[a-zA-Z][a-zA-Z0-9-_.]{1,10}$";
    private static final String PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD);
    }
}



