package hu.unideb.nursenotes.frontend.pojo;

import java.util.List;

import hu.unideb.nursenotes.commons.pojo.validator.Violation;
import hu.unideb.nursenotes.commons.pojo.validator.ViolationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.Callback;

@SuppressWarnings("ALL")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponsePojo {

    private int httpCode;
    private List<Violation> violationList;

}
