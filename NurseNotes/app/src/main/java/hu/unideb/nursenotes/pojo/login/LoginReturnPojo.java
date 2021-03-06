package hu.unideb.nursenotes.pojo.login;

import java.util.List;

import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReturnPojo {

    private int httpCode;
    private List<ClientResponse> clientResponseList;
}
