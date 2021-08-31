package dio.gu.servicerecordapi.dto;

import dio.gu.servicerecordapi.entities.Phone;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientDTO {

    @Generated
    private long id;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String name;

    @CPF
    @Valid
    private String cpf;


    private String adress;

    @Valid
    private List<Phone> phoneList = new ArrayList<>();


}
