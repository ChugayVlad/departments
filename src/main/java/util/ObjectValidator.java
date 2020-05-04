package util;

import exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;

import java.util.HashMap;
import java.util.List;

public class ObjectValidator {

    private Validator validator;

    public ObjectValidator() {
        this.validator = new Validator();
    }

    public void validateObject(Object object) throws ValidationException {
        List<ConstraintViolation> violations = validator.validate(object);
        HashMap<String, String> map = new HashMap<>();
        for (ConstraintViolation violation : violations) {
            FieldContext fieldContext = (FieldContext) violation.getContext();
            map.put(fieldContext.getField().getName(), violation.getMessage());
        }
        if (!violations.isEmpty()){
            throw new ValidationException(map);
        }
    }
}
