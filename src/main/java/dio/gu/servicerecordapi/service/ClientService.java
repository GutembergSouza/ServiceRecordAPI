package dio.gu.servicerecordapi.service;

import dio.gu.servicerecordapi.dto.ClientDTO;
import dio.gu.servicerecordapi.dto.mapper.ClientMapper;
import dio.gu.servicerecordapi.dto.response.MessageResponseDTO;
import dio.gu.servicerecordapi.entities.Client;
import dio.gu.servicerecordapi.repositoy.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public MessageResponseDTO create(ClientDTO clientDTO){
        Client client = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(client);


        MessageResponseDTO messageResponse = createMessageResponse("Created! By ID: "+savedClient.getId());

        return messageResponse;
    }

    private MessageResponseDTO createMessageResponse(String message) {
        return MessageResponseDTO
                .builder()
                .message(message)
                .build();
    }


}
