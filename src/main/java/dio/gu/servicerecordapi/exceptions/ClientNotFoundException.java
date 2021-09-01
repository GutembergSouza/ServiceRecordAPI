package dio.gu.servicerecordapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {

    public ClientNotFoundException(Long id){
        super (String.format("Client not founded for id  %s", id));
    }

}
