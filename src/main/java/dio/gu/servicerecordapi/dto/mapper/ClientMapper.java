package dio.gu.servicerecordapi.dto.mapper;

import dio.gu.servicerecordapi.dto.ClientDTO;
import dio.gu.servicerecordapi.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ClientMapper {

     Client toModel(ClientDTO dto);

     ClientDTO toDTO(Client dto);

}
