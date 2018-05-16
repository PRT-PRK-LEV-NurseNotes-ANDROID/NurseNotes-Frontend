package hu.unideb.nursenotes.pojo.client;

import java.util.List;

import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientListReturnPojo {

    private int httpCode;
    private List<ClientResponse> clientResponses;
}
