package hu.unideb.nursenotes.pojo.registration;

import java.util.List;

import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationReturnPojo {

    private int httpCode;
    private List<Violation> violationList;
}
