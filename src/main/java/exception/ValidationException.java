package exception;

import java.util.HashMap;

public class ValidationException extends Throwable {
    private final HashMap<String, String> validationMap;

    public ValidationException(HashMap<String, String> validationMap) {
        this.validationMap = validationMap;
    }

    public HashMap<String, String> getValidationMap() {
        return validationMap;
    }
}