package dio.gu.servicerecordapi.service;

import dio.gu.servicerecordapi.dto.ClientDTO;
import dio.gu.servicerecordapi.dto.mapper.ClientMapper;
import dio.gu.servicerecordapi.dto.response.MessageResponseDTO;
import dio.gu.servicerecordapi.entities.Client;
import dio.gu.servicerecordapi.exceptions.PersonNotFoundException;
import dio.gu.servicerecordapi.repositoy.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;


    public MessageResponseDTO create(ClientDTO clientDTO) {
        Client client = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(client);

        MessageResponseDTO messageResponse = createMessageResponse("Created! By ID: "+savedClient.getId());

        return messageResponse;
    }

    public List<ClientDTO> listAll(){
       List<Client> client = clientRepository.findAll();

       return client.stream()
               .map(clientMapper::toDTO)
               .collect(Collectors.toList());
    }


    public void deleteById(Long id)throws PersonNotFoundException {
          clientRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String message) {
        return MessageResponseDTO
                .builder()
                .message(message)
                .build();
    }

    public ClientDTO findById(Long id) throws PersonNotFoundException {
        Client client =
                clientRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return clientMapper.toDTO(client);
    }

    public MessageResponseDTO update(Long id, ClientDTO clientDTO) throws PersonNotFoundException{
        clientRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        Client updatedClient = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(updatedClient);
        MessageResponseDTO messageResponseDTO = createMessageResponse("Client suscefull updated wih id: "+ savedClient.getId());
        return messageResponseDTO;
    }
}
