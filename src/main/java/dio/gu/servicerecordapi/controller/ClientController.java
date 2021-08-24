package dio.gu.servicerecordapi.controller;

import dio.gu.servicerecordapi.dto.ClientDTO;
import dio.gu.servicerecordapi.dto.response.MessageResponseDTO;
import dio.gu.servicerecordapi.entities.Client;
import dio.gu.servicerecordapi.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;
    @RequestMapping
    private String welcomeToClient(){
        return "Bem Vindo! Pagina para Gerenciamento de Clientes!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO){
        return clientService.create(clientDTO);
    }

    @GetMapping
    private List<ClientDTO> listAllClient(){
       return clientService.listAll();
    }




}
