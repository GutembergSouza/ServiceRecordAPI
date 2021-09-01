package dio.gu.servicerecordapi.controller;

import dio.gu.servicerecordapi.dto.ClientDTO;
import dio.gu.servicerecordapi.dto.response.MessageResponseDTO;
import dio.gu.servicerecordapi.exceptions.ClientNotFoundException;
import dio.gu.servicerecordapi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.create(clientDTO);
    }

    @GetMapping
    private List<ClientDTO> listAllClient(){
       return clientService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(@PathVariable Long id) throws ClientNotFoundException {
          clientService.deleteById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) throws ClientNotFoundException {
       return clientService.update(id, clientDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ClientDTO findById(@PathVariable Long id)throws ClientNotFoundException {
       return clientService.findById(id);

    }

}
